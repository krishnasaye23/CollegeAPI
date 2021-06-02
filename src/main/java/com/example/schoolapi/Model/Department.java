package com.example.schoolapi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String dept_name;
    private String hod;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    //@JoinColumn(name = "Teacher_id",referencedColumnName = "teacher_id")
    private List<Teachers> teacher_id;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    //@JoinColumn(name = "Student_id",referencedColumnName = "student_id")
    private List<Students> student_id;
}
