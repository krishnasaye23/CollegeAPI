package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.StudentsDetailEntity;
import com.example.schoolapi.Repository.StudentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {
    @Autowired
    private StudentDetailsRepo studentDetailsRepo;
    @Override
    public List<StudentsDetailEntity> getStudentDetails() {
        return studentDetailsRepo.findAll();
    }
    @Override
    public StudentsDetailEntity getStudentDetailsbyid(int student_id) {
        StudentsDetailEntity opt=studentDetailsRepo.findById(student_id);
        return opt;
    }
    @Override
    public StudentsDetailEntity addStudentDetails(StudentsDetailEntity studentsDetails){
        studentDetailsRepo.save(studentsDetails);
        return studentsDetails;
    }
    @Override
    public StudentsDetailEntity updateStudentDetails(StudentsDetailEntity studentsDetails){
        studentDetailsRepo.save(studentsDetails);
        return studentsDetails;
    }
}
