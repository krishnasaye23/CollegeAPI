package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Clubs;
import com.example.schoolapi.Service.ClubsServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClubsCont {
    @Autowired
    private ClubsServImpl clubsImpl;
    @GetMapping("/clubs")
    public ResponseEntity<List<Clubs>> getClub(){
        List<Clubs> mo=clubsImpl.getClubs();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/clubs/{club_id}")
    public ResponseEntity<Clubs> getbyid(@PathVariable int club_id){
        Clubs response=clubsImpl.getClubsbyid(club_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/clubs/asc")
    public ResponseEntity<List<Clubs>> getClubAsc(){
        List<Clubs> mo=clubsImpl.getClubsOrderedAscending();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @PostMapping("/clubs")
    public ResponseEntity<Clubs> addClub(@Valid @RequestBody Clubs clubs) {
        Clubs response=clubsImpl.addClubs(clubs);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/clubs")
    public ResponseEntity<Clubs> updateClub(@Valid @RequestBody Clubs clubs){
       Clubs response = clubsImpl.updateClubs(clubs);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("clubs")
    public ResponseEntity<Clubs> delrecord(@RequestParam("club_id") int club_id){
        Clubs response = clubsImpl.delrecord(club_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}
