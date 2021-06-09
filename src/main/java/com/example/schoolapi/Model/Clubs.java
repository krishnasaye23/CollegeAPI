package com.example.schoolapi.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="clubs")
@NamedNativeQuery(name="Clubs.getClubsOrderedAscending",query = "select * from clubs order by club_name ASC ",resultClass = Clubs.class)
public class Clubs {
    @Id
    private int club_id;
    @NotNull(message = "club name cannot be null")
    private String club_name;
    private String president;
    private String vice_president;
    private String about;
    @Column(nullable = false,updatable=false)
    @CreationTimestamp
    private Instant createdon;
    @Column(nullable = false)
    @UpdateTimestamp
    private Instant lastupdatedon;
    @OneToMany(mappedBy = "clubs",cascade = CascadeType.PERSIST,targetEntity = Students.class)
    @JsonManagedReference(value = "club")
    private List<Students> members;
}
