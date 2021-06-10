package com.example.schoolapi.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Dept_Associations {
    @Id
    protected int asc_id;
}
