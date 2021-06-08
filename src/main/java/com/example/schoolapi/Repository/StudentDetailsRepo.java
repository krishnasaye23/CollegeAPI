package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.StudentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDetailsRepo extends JpaRepository<StudentsDetails,Integer> {
    List<StudentsDetails> findAll();
    StudentsDetails findById(int student_id);
}
