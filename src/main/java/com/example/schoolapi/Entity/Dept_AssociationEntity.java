package com.example.schoolapi.Entity;

import com.example.schoolapi.Model.Dept_Associations;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dept_association")
public class Dept_AssociationEntity extends Dept_Associations {

    @NotNull(message = "association name cannot be null")
    private String asc_name;
    private String president;
    private String vice_president;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
    @JsonBackReference(value="association")
    private DepartmentEntity department;
    @OneToMany(mappedBy = "dept_association",cascade = CascadeType.PERSIST,targetEntity = StudentEntity.class)
    @JsonManagedReference(value = "dept_association")
    private List<StudentEntity> asc_members;
}
