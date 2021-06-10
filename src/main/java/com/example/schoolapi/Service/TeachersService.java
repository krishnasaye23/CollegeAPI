package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.TeacherEntity;

import java.util.List;

public interface TeachersService {
    List<TeacherEntity> getTeachers();
    TeacherEntity getTeacherbyid(int teacher_id);
    TeacherEntity addTeachers(TeacherEntity teachers);
    TeacherEntity updateTeachers(TeacherEntity teachers);
    TeacherEntity delrecord(int teacher_id);
}
