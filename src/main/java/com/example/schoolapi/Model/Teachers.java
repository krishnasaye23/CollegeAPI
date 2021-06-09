package com.example.schoolapi.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.Instant;

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
    private String teacher_name;
    private String sect;
    private Date dob;
    private String gender;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
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

