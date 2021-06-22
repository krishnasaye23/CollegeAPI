package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getStudents();
    Students getStudentbyid(int student_id);
    Students addStudents(Students students);
    Students updateStudents(Students students);
    Students delrecord(int student_id);
    List<Students> getBoysOrGirls(String gender);
    List<Students> getStudentsByBatch(int batch);
}
