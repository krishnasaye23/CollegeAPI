package com.example.schoolapi.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

@Data
@MappedSuperclass
public class Teachers {
    @Id
    @Min(value = 300)
    protected int teacher_id;
    protected enum Gender{
        MALE, FEMALE
    }
}
