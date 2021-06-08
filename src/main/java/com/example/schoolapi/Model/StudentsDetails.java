package com.example.schoolapi.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students_details")
@Getter
@Setter
@NoArgsConstructor
public class StudentsDetails {
    @Id
    private int id;
    private String father_name;
    private String mother_name;
    private String email;
    private double cgpa;
    private String contact_no;
    @OneToOne(cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    //@JsonBackReference(value="studentsdetails")
    private Students students;
}
