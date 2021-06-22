package com.example.schoolapi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "dept_association")
public class Dept_AssociationEntity {
    @Id
    private int asc_id;
   // @NotNull(message = "association name cannot be null")
    //@Pattern(regexp = "^[a-zA-Z ]*$")
    private String asc_name;
    //@Pattern(regexp = "^[a-zA-Z ]*$")
    private String president;
    //@Pattern(regexp = "^[a-zA-Z ]*$")
    private String vice_president;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @OneToOne(cascade = CascadeType.PERSIST,targetEntity = DepartmentEntity.class)
    @JoinColumn(name = "Dept_id",referencedColumnName = "dept_id")
    @JsonBackReference(value="association")
    private DepartmentEntity department;
    @OneToMany(mappedBy = "dept_association",cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JsonManagedReference(value = "dept_association")
    private List<StudentEntity> asc_members;
}
