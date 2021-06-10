package com.example.schoolapi.Repository;

import com.example.schoolapi.Entity.StudentsDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentsDetailEntity,Integer> {
    List<StudentsDetailEntity> findAll();
    StudentsDetailEntity findById(int student_id);
}
