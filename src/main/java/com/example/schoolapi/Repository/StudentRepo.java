package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Students,Integer> {
    List<Students> findAll();
    Students deleteById(int student_id);
    Students findById(int student_id);
}
