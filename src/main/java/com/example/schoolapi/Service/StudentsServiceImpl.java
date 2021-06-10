package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.StudentEntity;
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
    public List<StudentEntity> getStudents() {
        return studentRepo.findAll();
    }
    @Override
    public StudentEntity getStudentbyid(int student_id) throws Exception{
        Optional<StudentEntity> opt= Optional.ofNullable(studentRepo.findById(student_id));
        if(!opt.isPresent())
            throw new Exception("Student not found with the given id "+student_id);
        return opt.get();
    }
    @Override
    public StudentEntity addStudents(StudentEntity students){
        studentRepo.save(students);
        return students;
    }
    @Override
    public StudentEntity updateStudents(StudentEntity students){
        studentRepo.save(students);
        return students;
    }
    @Override
    public StudentEntity delrecord(int student_id) throws Exception{
        Optional<StudentEntity> g= Optional.ofNullable(studentRepo.deleteById(student_id));
        if(!g.isPresent())
            throw new Exception("Student not found with the given id "+student_id);
        return g.get();
    }

    @Override
    public List<StudentEntity> getBoys(String gender) throws Exception {
        Optional<List<StudentEntity>> opt= Optional.ofNullable(studentRepo.getBoys(gender));
        if(!opt.isPresent())
            throw new Exception("There are no boys in the record now");
        return opt.get();
    }
    @Override
    public List<StudentEntity> getStudentsByBatch(int batch) throws Exception{
        Optional<List<StudentEntity>> opt=Optional.ofNullable(studentRepo.getStudentsByBatch(batch));
        if(!opt.isPresent())
            throw new Exception("Students not found in the batch "+batch);
        return opt.get();
    }
}
