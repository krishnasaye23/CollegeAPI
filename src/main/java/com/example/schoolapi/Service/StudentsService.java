package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getStudents() throws Exception;
    Students getStudentbyid(int student_id) throws Exception;
    Students addStudents(Students students);
    Students updateStudents(Students students);
    Students delrecord(int student_id) throws Exception;
    List<Students> getBoys(String gender) throws Exception;
}
