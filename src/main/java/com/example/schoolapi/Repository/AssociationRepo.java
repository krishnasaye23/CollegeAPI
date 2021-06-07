package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Dept_Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepo extends JpaRepository<Dept_Association,Integer> {
    List<Dept_Association> findAll();
    Dept_Association deleteById(int asc_id);
    Dept_Association findById(int asc_id);
}
