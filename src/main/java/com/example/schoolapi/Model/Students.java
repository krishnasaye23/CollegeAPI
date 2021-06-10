package com.example.schoolapi.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

@Data
@MappedSuperclass
public class Students {
    @Id
    @Min(value = 300)
    protected int student_id;
    protected enum Gender{
        MALE, FEMALE
    }
}
