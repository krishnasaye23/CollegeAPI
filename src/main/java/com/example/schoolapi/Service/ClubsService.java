package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.ClubEntity;
import java.util.List;

public interface ClubsService {
    List<ClubEntity> getClubs();
    ClubEntity getClubsbyid(int club_id);
    ClubEntity addClubs(ClubEntity clubs);
    ClubEntity updateClubs(ClubEntity clubs);
    ClubEntity delrecord(int club_id);
    List<ClubEntity> getClubsOrderedAscending();
}
