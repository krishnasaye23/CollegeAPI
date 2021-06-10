package com.example.schoolapi.Repository;

import com.example.schoolapi.Entity.Dept_AssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepo extends JpaRepository<Dept_AssociationEntity,Integer> {
    List<Dept_AssociationEntity> findAll();
    Dept_AssociationEntity deleteById(int asc_id);
    Dept_AssociationEntity findById(int asc_id);
}
