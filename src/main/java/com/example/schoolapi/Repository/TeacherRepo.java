package com.example.schoolapi.Repository;

import com.example.schoolapi.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherEntity,Integer> {
    List<TeacherEntity> findAll();
    TeacherEntity deleteById(int teacher_id);
    TeacherEntity findById(int teacher_id);
}
