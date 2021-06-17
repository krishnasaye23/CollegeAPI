package com.example.schoolapi.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class StudentsDetails {
    @Id
    protected int id;

}
