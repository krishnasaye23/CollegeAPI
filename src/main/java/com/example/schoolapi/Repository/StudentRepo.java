package com.example.schoolapi.Repository;

import com.example.schoolapi.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
    List<StudentEntity> findAll();
    StudentEntity deleteById(int student_id);
    StudentEntity findById(int student_id);
    List<StudentEntity> getBoysOrGirls(String gender);
    List<StudentEntity> getStudentsByBatch(int batch);
}
