package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Departments;

import java.util.List;

public interface DepartmentsService {
    List<Departments> getDepartments();
    Departments getDepartmentbyid(int dept_id);
    Departments addDepartments(Departments department);
    Departments updateDepartments(Departments department);
    String delrecord(int dept_id);
}
