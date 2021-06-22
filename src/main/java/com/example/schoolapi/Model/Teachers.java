package com.example.schoolapi.Model;

import com.example.schoolapi.Entity.DepartmentEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teachers {
    @Id
    @Min(value = 300)
    private int teacher_id;
    @NotNull(message = "teacher name should not be null")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String teacher_name;
    private String sect;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private Date dob;
    private Gender gender;
    public enum Gender{
        MALE, FEMALE
    }
    private Instant createdon;
    private Instant lastupdatedon;
    private DepartmentEntity department;
}
