package com.example.schoolapi.Model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Clubs {
    @Id
    protected int club_id;
}
