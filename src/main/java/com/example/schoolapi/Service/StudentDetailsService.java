package com.example.schoolapi.Service;

import com.example.schoolapi.Model.StudentsDetails;

import java.util.List;

public interface StudentDetailsService {
    List<StudentsDetails> getStudentDetails();
    StudentsDetails getStudentDetailsbyid(int student_id);
    StudentsDetails addStudentDetails(StudentsDetails studentsDetails);
    StudentsDetails updateStudentDetails(StudentsDetails studentsDetails);
}
