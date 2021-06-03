package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Students;
import com.example.schoolapi.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public class StudentsServImpl implements StudentsServ {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Students> getStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Students getStudentbyid(int student_id) {
        Students opt=studentRepo.findById(student_id);
        return opt;
    }
    @Override
    public Students addStudents(Students students){
        studentRepo.save(students);
        return students;
    }
    @Override
    public Students updateStudents(Students students){
        studentRepo.save(students);
        return students;
    }
    @Override
    public Students delrecord(int student_id) {
        Students g=studentRepo.deleteById(student_id);
        return g;
    }
}
