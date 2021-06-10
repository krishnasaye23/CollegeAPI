package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.StudentsDetailEntity;

import java.util.List;

public interface StudentDetailsService {
    List<StudentsDetailEntity> getStudentDetails();
    StudentsDetailEntity getStudentDetailsbyid(int student_id);
    StudentsDetailEntity addStudentDetails(StudentsDetailEntity studentsDetails);
    StudentsDetailEntity updateStudentDetails(StudentsDetailEntity studentsDetails);
}
