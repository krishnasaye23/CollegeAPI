package com.example.schoolapi.Entity;

import com.example.schoolapi.Model.Clubs;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="clubs")
@NamedNativeQuery(name="ClubEntity.getClubsOrderedAscending",query = "select * from clubs order by club_name ASC ",resultClass = ClubEntity.class)
public class ClubEntity extends Clubs {

    @NotNull(message = "club name cannot be null")
    private String club_name;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String president;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String vice_president;
    private String about;
    @Column(nullable = false,updatable=false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @OneToMany(mappedBy = "clubs",cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JsonManagedReference(value = "club")
    private List<StudentEntity> members;
}
