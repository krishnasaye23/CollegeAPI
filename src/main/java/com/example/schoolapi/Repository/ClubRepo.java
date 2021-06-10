package com.example.schoolapi.Repository;

import com.example.schoolapi.Entity.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClubRepo extends JpaRepository<ClubEntity,Integer> {
    List<ClubEntity> findAll();
    ClubEntity deleteById(int club_id);
    ClubEntity findById(int club_id);
    List<ClubEntity> getClubsOrderedAscending();
}
