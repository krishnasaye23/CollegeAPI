package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.StudentEntity;

import java.util.List;

public interface StudentsService {
    List<StudentEntity> getStudents() throws Exception;
    StudentEntity getStudentbyid(int student_id) throws Exception;
    StudentEntity addStudents(StudentEntity students);
    StudentEntity updateStudents(StudentEntity students);
    StudentEntity delrecord(int student_id) throws Exception;
    List<StudentEntity> getBoys(String gender) throws Exception;
    List<StudentEntity> getStudentsByBatch(int batch) throws Exception;
}
