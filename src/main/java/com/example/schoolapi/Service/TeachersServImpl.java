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
}
