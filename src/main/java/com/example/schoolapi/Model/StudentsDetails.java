package com.example.schoolapi.Model;

import com.example.schoolapi.Entity.StudentEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentsDetails {
    @Id
    private int id;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String father_name;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String mother_name;
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email-id is invalid....check again")
    private String email;
    private double cgpa;
    @Pattern(regexp = "^[0-9]+$")
    private String contact_no;
    @Transient
    public String remarks;
    private Instant createdon;
    private Instant lastupdatedon;
    private StudentEntity students;
}
