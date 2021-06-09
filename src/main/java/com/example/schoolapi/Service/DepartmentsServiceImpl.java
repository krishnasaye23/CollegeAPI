package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Department;
import com.example.schoolapi.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentsServImpl implements DepartmentsServ {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }
    @Override
    public Department getDepartmentbyid(int dept_id) {
        Department opt=departmentRepo.findById(dept_id);
        return opt;
    }
    @Override
    public Department addDepartments(Department department){
        departmentRepo.save(department);
        return department;
    }
    @Override
    public Department updateDepartments(Department department){
        departmentRepo.save(department);
        return department;
    }
    @Override
    public Department delrecord(int dept_id) {
        Department g=departmentRepo.deleteById(dept_id);
        return g;
    }
}
