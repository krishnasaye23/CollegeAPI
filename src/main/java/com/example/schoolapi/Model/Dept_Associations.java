package com.example.schoolapi.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@ApiModel(description = "Details of the Department Associations")
public class Dept_Associations {
    @Id
    @ApiModelProperty(notes = "Id of the department association",required = true)
    private int asc_id;
}
