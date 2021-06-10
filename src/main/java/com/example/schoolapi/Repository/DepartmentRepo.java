package com.example.schoolapi.Repository;

import com.example.schoolapi.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity,Integer> {
    List<DepartmentEntity> findAll();
    DepartmentEntity deleteById(int dept_id);
    DepartmentEntity findById(int dept_id);
}
