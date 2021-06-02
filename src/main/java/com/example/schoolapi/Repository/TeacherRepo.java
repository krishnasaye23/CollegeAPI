package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teachers,Integer> {
}
