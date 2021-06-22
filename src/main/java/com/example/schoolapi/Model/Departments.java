package com.example.schoolapi.Model;

import com.example.schoolapi.Entity.DepartmentEntity;
import com.example.schoolapi.Entity.Dept_AssociationEntity;
import com.example.schoolapi.Entity.StudentEntity;
import com.example.schoolapi.Entity.TeacherEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Departments {
    @Id
    protected int dept_id;
    @NotNull(message = "department name cannot be null")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    protected String dept_name;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    protected String hod;
    protected Instant createdon;
    protected Instant lastupdatedon;
    protected List<TeacherEntity> teacher_id;
    protected List<StudentEntity> student_id;
    public Dept_AssociationEntity asc_id;
}
