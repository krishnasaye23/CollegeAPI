package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClubRepo extends JpaRepository<Clubs,Integer> {
    List<Clubs> findAll();
    Clubs deleteById(int club_id);
    Clubs findById(int club_id);
}
