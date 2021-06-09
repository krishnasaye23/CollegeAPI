package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Department;

import java.util.List;

public interface DepartmentsService {
    List<Department> getDepartments();
    Department getDepartmentbyid(int dept_id);
    Department addDepartments(Department department);
    Department updateDepartments(Department department);
    Department delrecord(int dept_id);
}
