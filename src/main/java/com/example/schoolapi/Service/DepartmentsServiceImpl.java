package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.DepartmentEntity;
import com.example.schoolapi.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public List<DepartmentEntity> getDepartments() {
        return departmentRepo.findAll();
    }
    @Override
    public DepartmentEntity getDepartmentbyid(int dept_id) {
        DepartmentEntity opt=departmentRepo.findById(dept_id);
        return opt;
    }
    @Override
    public DepartmentEntity addDepartments(DepartmentEntity department){
        departmentRepo.save(department);
        return department;
    }
    @Override
    public DepartmentEntity updateDepartments(DepartmentEntity department){
        departmentRepo.save(department);
        return department;
    }
    @Override
    public DepartmentEntity delrecord(int dept_id) {
        DepartmentEntity g=departmentRepo.deleteById(dept_id);
        return g;
    }
}
