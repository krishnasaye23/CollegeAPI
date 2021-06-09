package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Teachers;

import java.util.List;

public interface TeachersService {
    List<Teachers> getTeachers();
    Teachers getTeacherbyid(int teacher_id);
    Teachers addTeachers(Teachers teachers);
    Teachers updateTeachers(Teachers teachers);
    Teachers delrecord(int teacher_id);
}
