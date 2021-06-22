package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.DepartmentEntity;
import com.example.schoolapi.Model.Departments;
import com.example.schoolapi.Repository.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Departments> getDepartments() {

        return departmentRepo.findAll().stream().map(departmentEntity -> modelMapper.map(departmentEntity,Departments.class))
                .collect(Collectors.toList());
    }
    @Override
    public Departments getDepartmentbyid(int dept_id) {
        DepartmentEntity departmentEntity= departmentRepo.findById(dept_id);
        Departments dep=modelMapper.map(departmentEntity,Departments.class);
        return dep;

    }
    @Override
    public Departments addDepartments(Departments department){
        DepartmentEntity dep=modelMapper.map(department,DepartmentEntity.class);
        departmentRepo.save(dep);
        Departments deps=modelMapper.map(dep,Departments.class);
        return deps;
        /*DepartmentEntity departmentEntity=new DepartmentEntity();
        departmentEntity.setDept_id(department.getDept_id());
        departmentRepo.save(departmentEntity);
        return department;*/
    }
    @Override
    public Departments updateDepartments(Departments department){
        DepartmentEntity dep=modelMapper.map(department,DepartmentEntity.class);
        departmentRepo.save(dep);
        Departments deps=modelMapper.map(dep,Departments.class);
        return deps;
    }
    @Override
    public String delrecord(int dept_id) {
        if(departmentRepo.findById(dept_id)!=null) {
            departmentRepo.deleteById(dept_id);
            return "Deleted successfully";
        }
        else
            return "Record not found with the id";
    }
}
