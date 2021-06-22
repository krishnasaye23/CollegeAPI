package com.example.schoolapi.Entity;

import com.example.schoolapi.Model.Departments;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Data
@Getter
@Setter
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    protected int dept_id;
    protected String dept_name;
    protected String hod;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    protected Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    protected Instant lastupdatedon;
    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JsonManagedReference(value = "teachers")
    protected List<TeacherEntity> teacher_id;
    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JsonManagedReference(value = "department")
    protected List<StudentEntity> student_id;
    @OneToOne(mappedBy = "department",cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JsonManagedReference(value = "association")
    public Dept_AssociationEntity asc_id;
}
