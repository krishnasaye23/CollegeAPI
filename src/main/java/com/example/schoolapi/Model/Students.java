package com.example.schoolapi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Students")
public class Students {
    @Id
    @Min(value = 300)
    private int student_id;
    @NotNull(message = "student name should not be null")
    // @Pattern(regexp="^[a-z][A-Z][0-9]",message="should not contain special characters")
    //@Pattern(regexp = )
    private String student_name;
    private String batch;  //year
    private String sect;
    private Date dob;
    private String gender;
    @ManyToOne//( cascade = CascadeType.ALL)
    @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
    //@JsonBackReference
    private Department department;

}
