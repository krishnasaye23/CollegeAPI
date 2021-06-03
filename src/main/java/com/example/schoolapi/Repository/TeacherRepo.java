package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teachers,Integer> {
    List<Teachers> findAll();
    Teachers deleteById(int teacher_id);
    Teachers findById(int teacher_id);
}
