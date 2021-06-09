package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Clubs;
import com.example.schoolapi.Repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubRepo clubRepo;
    @Override
    public List<Clubs> getClubs() {
        return clubRepo.findAll();
    }
    @Override
    public Clubs getClubsbyid(int club_id) {
        Clubs opt=clubRepo.findById(club_id);
        return opt;
    }
    @Override
    public Clubs addClubs(Clubs clubs){
        clubRepo.save(clubs);
        return clubs;
    }
    @Override
    public Clubs updateClubs(Clubs clubs){
        clubRepo.save(clubs);
        return clubs;
    }
    @Override
    public Clubs delrecord(int club_id) {
        Clubs g=clubRepo.deleteById(club_id);
        return g;
    }

    @Override
    public List<Clubs> getClubsOrderedAscending() {
        return clubRepo.getClubsOrderedAscending();
    }
}
