package com.example.schoolapi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students_details")
public class StudentsDetailEntity {
    @Id
    private int id;
    private String father_name;
    private String mother_name;
    private String email;
    private double cgpa;
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
