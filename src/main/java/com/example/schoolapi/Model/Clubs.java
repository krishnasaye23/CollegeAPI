package com.example.schoolapi.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="clubs")
public class Clubs {
    @Id
    private int club_id;
    @NotNull(message = "club name cannot be null")
    private String club_name;
    private String president;
    private String vice_president;
    private String about;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private java.util.Date lastupdatedon;
    @PrePersist
    private void onCreate(){
        lastupdatedon=new java.util.Date();
    }
    @OneToMany(mappedBy = "clubs",cascade = CascadeType.PERSIST,targetEntity = Students.class)
    @JsonManagedReference(value = "club")
    private List<Students> members;
}
