package com.example.schoolapi.Entity;

import com.example.schoolapi.Model.StudentsDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.Instant;

@Entity
@Table(name = "students_details")
@Getter
@Setter
@NoArgsConstructor
public class StudentsDetailEntity extends StudentsDetails {

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
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Student_id",referencedColumnName = "student_id")
    @JsonBackReference(value="studentsdetails")
    private StudentEntity students;

}
