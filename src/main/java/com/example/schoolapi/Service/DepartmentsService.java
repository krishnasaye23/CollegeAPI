package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.DepartmentEntity;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentEntity> getDepartments();
    DepartmentEntity getDepartmentbyid(int dept_id);
    DepartmentEntity addDepartments(DepartmentEntity department);
    DepartmentEntity updateDepartments(DepartmentEntity department);
    DepartmentEntity delrecord(int dept_id);
}
