package com.example.schoolapi.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Students {
    @Id
    @Min(value = 300)
    private int student_id;
    @NotNull(message = "student name should not be null")
    // @Pattern(regexp="^[a-z][A-Z][0-9]",message="should not contain special characters")
    //@Pattern(regexp = )
    private String student_name;
    private int batch;  //year
    private String sect;
    private Date dob;
    private String gender;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastupdatedon;
    @PrePersist
    private void onCreate(){
        lastupdatedon=new Date();
    }

   @ManyToOne( cascade = CascadeType.PERSIST)
   @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
   @JsonBackReference(value = "department")
   private Department department;
   @ManyToOne( cascade = CascadeType.PERSIST)
   @JoinColumn(name = "Club_id",referencedColumnName = "club_id")
   @JsonBackReference(value="club")
   private Clubs clubs;
    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Asc_id",referencedColumnName = "asc_id")
    @JsonBackReference(value="dept_association")
    private Dept_Association dept_association;
    @OneToOne(mappedBy = "students",cascade = CascadeType.PERSIST,targetEntity = StudentsDetails.class)
    //@JsonManagedReference(value = "studentsdetails")
    private StudentsDetails students_details;


    public Students(int student_id, String student_name, int batch, String sect, Date dob, String gender,Date lastupdatedon) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.batch = batch;
        this.sect = sect;
        this.dob = dob;
        this.gender = gender;
        this.lastupdatedon=lastupdatedon;
    }

}
