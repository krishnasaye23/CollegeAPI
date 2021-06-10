package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.TeacherEntity;
import com.example.schoolapi.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Override
    public List<TeacherEntity> getTeachers() {
        return teacherRepo.findAll();
    }
    @Override
    public TeacherEntity addTeachers(TeacherEntity teachers){
        teacherRepo.save(teachers);
        return teachers;
    }
    @Override
    public TeacherEntity updateTeachers(TeacherEntity teachers){
        teacherRepo.save(teachers);
        return teachers;
    }
    @Override
    public TeacherEntity delrecord(int teacher_id) {
        TeacherEntity g=teacherRepo.deleteById(teacher_id);
        return g;
    }
    @Override
    public TeacherEntity getTeacherbyid(int teacher_id) {
        TeacherEntity opt=teacherRepo.findById(teacher_id);
        return opt;
    }

}
