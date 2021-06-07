package com.example.schoolapi.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Teachers")
public class Teachers {
    @Id
    @Min(value = 300)
    private int teacher_id;
    @NotNull(message = "teacher name should not be null")
    // @Pattern(regexp="^[a-z][A-Z][0-9]",message="should not contain special characters")
    //@Pattern(regexp = )
    private String teacher_name;
    private String sect;
    private Date dob;
    private String gender;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private java.util.Date lastupdatedon;
    @PrePersist
    private void onCreate(){
        lastupdatedon=new java.util.Date();
    }
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
    //@JsonBackReference
    private Department department;

    public Teachers(int teacher_id, String teacher_name, String sect, Date dob, String gender) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.sect = sect;
        this.dob = dob;
        this.gender = gender;
    }
}

