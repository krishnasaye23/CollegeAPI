package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    List<Department> findAll();
    Department deleteById(int dept_id);
    Department findById(int dept_id);
}
