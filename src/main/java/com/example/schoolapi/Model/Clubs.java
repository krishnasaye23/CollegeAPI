package com.example.schoolapi.Model;

import com.example.schoolapi.Entity.StudentEntity;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clubs {
    @Id
    private int club_id;
    @NotNull(message = "club name cannot be null")
    private String club_name;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String president;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String vice_president;
    private String about;
    private Instant createdon;
    private Instant lastupdatedon;
    private List<StudentEntity> members;
}
