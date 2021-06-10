package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.ClubEntity;
import com.example.schoolapi.Repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubRepo clubRepo;
    @Override
    public List<ClubEntity> getClubs() {
        return clubRepo.findAll();
    }
    @Override
    public ClubEntity getClubsbyid(int club_id) {
        ClubEntity opt=clubRepo.findById(club_id);
        return opt;
    }
    @Override
    public ClubEntity addClubs(ClubEntity clubs){
        clubRepo.save(clubs);
        return clubs;
    }
    @Override
    public ClubEntity updateClubs(ClubEntity clubs){
        clubRepo.save(clubs);
        return clubs;
    }
    @Override
    public ClubEntity delrecord(int club_id) {
        ClubEntity g=clubRepo.deleteById(club_id);
        return g;
    }

    @Override
    public List<ClubEntity> getClubsOrderedAscending() {
        return clubRepo.getClubsOrderedAscending();
    }
}
