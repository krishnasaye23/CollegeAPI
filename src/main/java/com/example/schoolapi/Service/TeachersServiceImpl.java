package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Teachers;
import com.example.schoolapi.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeachersServImpl implements TeachersServ{
    @Autowired
    private TeacherRepo teacherRepo;
    @Override
    public List<Teachers> getTeachers() {
        return teacherRepo.findAll();
    }
    @Override
    public Teachers addTeachers(Teachers teachers){
        teacherRepo.save(teachers);
        return teachers;
    }
    @Override
    public Teachers updateTeachers(Teachers teachers){
        teacherRepo.save(teachers);
        return teachers;
    }
    @Override
    public Teachers delrecord(int teacher_id) {
        Teachers g=teacherRepo.deleteById(teacher_id);
        return g;
    }
    @Override
    public Teachers getTeacherbyid(int teacher_id) {
        Teachers opt=teacherRepo.findById(teacher_id);
        return opt;
    }

}
