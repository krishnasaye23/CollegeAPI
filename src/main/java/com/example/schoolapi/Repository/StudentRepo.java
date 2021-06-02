package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Students;
import com.example.schoolapi.Service.StudentsServ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Students,Integer> {

}
