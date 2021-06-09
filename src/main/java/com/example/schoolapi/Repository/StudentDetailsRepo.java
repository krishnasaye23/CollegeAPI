package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.StudentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentsDetails,Integer> {
    List<StudentsDetails> findAll();
    StudentsDetails findById(int student_id);
}
