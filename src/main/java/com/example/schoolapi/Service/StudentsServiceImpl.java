package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.StudentEntity;
import com.example.schoolapi.Model.Students;
import com.example.schoolapi.Repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Students> getStudents() {

        return studentRepo.findAll().stream().map(studentEntity -> modelMapper.map(studentEntity,Students.class))
                .collect(Collectors.toList());
    }
    @Override
    public Students getStudentbyid(int student_id) {

        StudentEntity studentEntity= studentRepo.findById(student_id);
        Students dep=modelMapper.map(studentEntity,Students.class);
        return dep;
    }
    @Override
    public Students addStudents(Students students){
        StudentEntity dep=modelMapper.map(students,StudentEntity.class);
        studentRepo.save(dep);
        Students deps=modelMapper.map(dep,Students.class);
        return deps;
    }
    @Override
    public Students updateStudents(Students students){
        StudentEntity dep=modelMapper.map(students,StudentEntity.class);
        studentRepo.save(dep);
        Students deps=modelMapper.map(dep,Students.class);
        return deps;
    }
    @Override
    public Students delrecord(int student_id) {
        StudentEntity g=studentRepo.deleteById(student_id);
        Students deps=modelMapper.map(g,Students.class);
        return deps;
    }

    @Override
    public List<Students> getBoysOrGirls(String gender)  {

        return studentRepo.getBoysOrGirls(gender).stream().map(studentEntity -> modelMapper.map(studentEntity, Students.class))
                          .collect(Collectors.toList());

    }
    @Override
    public List<Students> getStudentsByBatch(int batch) {
        return studentRepo.getStudentsByBatch(batch).stream().map(studentEntity -> modelMapper.map(studentEntity, Students.class))
                .collect(Collectors.toList());
    }
}
