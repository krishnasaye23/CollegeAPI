package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,String> {
}
