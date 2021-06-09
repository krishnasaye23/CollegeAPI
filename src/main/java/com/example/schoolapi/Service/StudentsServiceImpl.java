package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Students;
import com.example.schoolapi.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Students> getStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Students getStudentbyid(int student_id) throws Exception{
        Optional<Students> opt= Optional.ofNullable(studentRepo.findById(student_id));
        if(!opt.isPresent())
            throw new Exception("Student not found with the given id "+student_id);
        return opt.get();
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
    public Students delrecord(int student_id) throws Exception{
        Optional<Students> g= Optional.ofNullable(studentRepo.deleteById(student_id));
        if(!g.isPresent())
            throw new Exception("Student not found with the given id "+student_id);
        return g.get();
    }

    @Override
    public List<Students> getBoys(String gender) throws Exception {
        Optional<List<Students>> opt= Optional.ofNullable(studentRepo.getBoys(gender));
        if(!opt.isPresent())
            throw new Exception("There are no boys in the record now");
        return opt.get();
    }
}
