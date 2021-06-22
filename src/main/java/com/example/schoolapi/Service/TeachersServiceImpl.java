package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.ClubEntity;
import com.example.schoolapi.Entity.TeacherEntity;
import com.example.schoolapi.Model.Clubs;
import com.example.schoolapi.Model.Dept_Associations;
import com.example.schoolapi.Model.Teachers;
import com.example.schoolapi.Repository.TeacherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Teachers> getTeachers() {

        return teacherRepo.findAll().stream().map(teacherEntity -> modelMapper.map(teacherEntity,Teachers.class))
                .collect(Collectors.toList());
    }
    @Override
    public Teachers addTeachers(Teachers teachers){
        TeacherEntity dep=modelMapper.map(teachers,TeacherEntity.class);
        teacherRepo.save(dep);
        Teachers deps=modelMapper.map(dep,Teachers.class);
        return deps;
    }
    @Override
    public Teachers updateTeachers(Teachers teachers){
        TeacherEntity dep=modelMapper.map(teachers,TeacherEntity.class);
        teacherRepo.save(dep);
        Teachers deps=modelMapper.map(dep,Teachers.class);
        return deps;
    }
    @Override
    public Teachers delrecord(int teacher_id) {
        TeacherEntity g=teacherRepo.deleteById(teacher_id);
        return modelMapper.map(g,Teachers.class);

    }
    @Override
    public Teachers getTeacherbyid(int teacher_id) {
        TeacherEntity teacherEntity= teacherRepo.findById(teacher_id);
        Teachers dep=modelMapper.map(teacherEntity,Teachers.class);
        return dep;
    }

}
