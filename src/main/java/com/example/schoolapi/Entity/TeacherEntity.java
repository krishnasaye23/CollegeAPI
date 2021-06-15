package com.example.schoolapi.Entity;
import com.example.schoolapi.Model.Teachers;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Teachers")
public class TeacherEntity extends Teachers {

    @NotNull(message = "teacher name should not be null")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String teacher_name;
    private String sect;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
    //@JsonBackReference
    private DepartmentEntity department;

    public TeacherEntity(int teacher_id,String teacher_name) {
        this.teacher_id=teacher_id;
        this.teacher_name = teacher_name;
    }
}

