package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Clubs;
import com.example.schoolapi.Service.ClubsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClubsController {
    @Autowired
    private ClubsServiceImpl clubsImpl;
    @GetMapping("/clubs")
    public ResponseEntity<Object> getClub(){
        try {
            List<Clubs> mo = clubsImpl.getClubs();
            return new ResponseEntity<>(mo, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No records found",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/clubs/{club_id}")
    public ResponseEntity<Object> getbyid(@PathVariable int club_id){
        try {
            Clubs response = clubsImpl.getClubsbyid(club_id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Club not found with the id "+club_id,HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<Object> delrecord(@RequestParam("club_id") int club_id){
        try {
            Clubs response = clubsImpl.delrecord(club_id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Club not found with the id "+club_id,HttpStatus.BAD_REQUEST);
        }
    }

}
