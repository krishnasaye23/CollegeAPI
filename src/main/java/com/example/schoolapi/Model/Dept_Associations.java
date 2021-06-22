package com.example.schoolapi.Model;

import com.example.schoolapi.Entity.DepartmentEntity;
import com.example.schoolapi.Entity.StudentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Details of the Department Associations")
public class Dept_Associations {
    @Id
    @ApiModelProperty(notes = "Id of the department association",required = true)
    private int asc_id;
    @NotNull(message = "association name cannot be null")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String asc_name;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String president;
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String vice_president;
    private Instant createdon;
    private Instant lastupdatedon;
    private DepartmentEntity department;
    private List<StudentEntity> asc_members;
}
