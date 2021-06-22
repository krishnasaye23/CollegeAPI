package com.example.schoolapi.Entity;

import com.example.schoolapi.Model.Teachers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "students")
@NamedNativeQueries(value = {@NamedNativeQuery(name = "StudentEntity.getBoysOrGirls",query = "select * from students where gender=? order by student_name",resultClass = StudentEntity.class),
                             @NamedNativeQuery(name = "StudentEntity.getStudentsByBatch",query = "select * from students where batch=?",resultClass = StudentEntity.class)})
public class StudentEntity {
    @Id
    private int student_id;
    private String student_name;
    private int batch;  //year
    private String sect;
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Teachers.Gender gender;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;

   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
   @JsonBackReference(value = "department")
   private DepartmentEntity department;
   @ManyToOne( cascade = CascadeType.PERSIST)
   @JoinColumn(name = "Club_id",referencedColumnName = "club_id")
   @JsonBackReference(value="club")
   private ClubEntity clubs;
    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Asc_id",referencedColumnName = "asc_id")
    @JsonBackReference(value="dept_association")
    private Dept_AssociationEntity dept_association;
    @OneToOne(mappedBy = "students",cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JsonManagedReference(value = "studentsdetails")
    private StudentsDetailEntity students_details;

}
