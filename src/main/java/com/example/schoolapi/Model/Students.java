package com.example.schoolapi.Model;

import com.example.schoolapi.Entity.ClubEntity;
import com.example.schoolapi.Entity.DepartmentEntity;
import com.example.schoolapi.Entity.Dept_AssociationEntity;
import com.example.schoolapi.Entity.StudentsDetailEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Students {
    @Id
    @Min(value = 300)
    private int student_id;
    @NotNull(message = "student name should not be null")
    @Pattern(regexp = "^[a-zA-Z ]*$",message = "Name should not contain special characters")
    private String student_name;
    private int batch;  //year
    private String sect;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    protected enum Gender{
        MALE, FEMALE
    }
    private Instant createdon;
    private Instant lastupdatedon;
    private DepartmentEntity department;
    private ClubEntity clubs;
    private Dept_AssociationEntity dept_association;
    private StudentsDetailEntity students_details;
}
