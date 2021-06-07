package com.example.schoolapi.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    private String dept_id;
    @NotNull(message = "department name cannot be null")
    private String dept_name;
    private String hod;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private java.util.Date lastupdatedon;
    @PrePersist
    private void onCreate(){
        lastupdatedon=new java.util.Date();
    }
    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,targetEntity = Teachers.class)
    //@JoinColumn(name = "Teacher_id",referencedColumnName = "teacher_id")
    private List<Teachers> teacher_id;
    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,targetEntity = Students.class)
    //@JoinColumn(name = "Student_id",referencedColumnName = "student_id")
    @JsonManagedReference(value = "department")
    private List<Students> student_id;
    @OneToOne(mappedBy = "department",cascade = CascadeType.PERSIST,targetEntity = Dept_Association.class)
    @JsonManagedReference(value = "association")
    private Dept_Association asc_id;
}
