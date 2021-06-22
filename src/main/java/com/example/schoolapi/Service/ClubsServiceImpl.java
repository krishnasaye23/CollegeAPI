package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.ClubEntity;
import com.example.schoolapi.Model.Clubs;
import com.example.schoolapi.Model.Dept_Associations;
import com.example.schoolapi.Repository.ClubRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubRepo clubRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Clubs> getClubs() {

        return clubRepo.findAll().stream().map(clubEntity -> modelMapper.map(clubEntity, Clubs.class))
                .collect(Collectors.toList());
    }
    @Override
    public Clubs getClubsbyid(int club_id) {
        ClubEntity clubEntity= clubRepo.findById(club_id);
        Clubs dep=modelMapper.map(clubEntity,Clubs.class);
        return dep;
    }
    @Override
    public Clubs addClubs(Clubs clubs){
        ClubEntity dep=modelMapper.map(clubs,ClubEntity.class);
        clubRepo.save(dep);
        Clubs deps=modelMapper.map(dep,Clubs.class);
        return deps;
    }
    @Override
    public Clubs updateClubs(Clubs clubs){
        ClubEntity dep=modelMapper.map(clubs,ClubEntity.class);
        clubRepo.save(dep);
        Clubs deps=modelMapper.map(dep,Clubs.class);
        return deps;
    }
    @Override
    public Clubs delrecord(int club_id) {
        ClubEntity g=clubRepo.deleteById(club_id);
        Clubs deps=modelMapper.map(g,Clubs.class);
        return deps;
    }

    @Override
    public List<Clubs> getClubsOrderedAscending() {

        return clubRepo.getClubsOrderedAscending().stream().map(clubEntity -> modelMapper.map(clubEntity, Clubs.class))
                .collect(Collectors.toList());
    }
}
