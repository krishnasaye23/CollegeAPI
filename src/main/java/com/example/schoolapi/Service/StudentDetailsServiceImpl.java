package com.example.schoolapi.Service;

import com.example.schoolapi.Model.StudentsDetails;
import com.example.schoolapi.Repository.StudentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {
    @Autowired
    private StudentDetailsRepo studentDetailsRepo;
    @Override
    public List<StudentsDetails> getStudentDetails() {
        return studentDetailsRepo.findAll();
    }
    @Override
    public StudentsDetails getStudentDetailsbyid(int student_id) {
        StudentsDetails opt=studentDetailsRepo.findById(student_id);
        return opt;
    }
    @Override
    public StudentsDetails addStudentDetails(StudentsDetails studentsDetails){
        studentDetailsRepo.save(studentsDetails);
        return studentsDetails;
    }
    @Override
    public StudentsDetails updateStudentDetails(StudentsDetails studentsDetails){
        studentDetailsRepo.save(studentsDetails);
        return studentsDetails;
    }
}
