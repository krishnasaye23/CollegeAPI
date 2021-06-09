package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Clubs;
import java.util.List;

public interface ClubsServ {
    List<Clubs> getClubs();
    Clubs getClubsbyid(int club_id);
    Clubs addClubs(Clubs clubs);
    Clubs updateClubs(Clubs clubs);
    Clubs delrecord(int club_id);
    List<Clubs> getClubsOrderedAscending();
}
