package com.example.schoolapi.Entity;

import com.example.schoolapi.Model.Departments;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class DepartmentEntity extends Departments {

    @NotNull(message = "department name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String dept_name;
    private String hod;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,targetEntity = TeacherEntity.class)
    //@JoinColumn(name = "Teacher_id",referencedColumnName = "teacher_id")
    private List<TeacherEntity> teacher_id;
    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,targetEntity = StudentEntity.class)
    //@JoinColumn(name = "Student_id",referencedColumnName = "student_id")
    @JsonManagedReference(value = "department")
    private List<StudentEntity> student_id;
    @OneToOne(mappedBy = "department",cascade = CascadeType.PERSIST,targetEntity = Dept_AssociationEntity.class)
    @JsonManagedReference(value = "association")
    private Dept_AssociationEntity asc_id;
}
