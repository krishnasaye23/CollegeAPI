package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Teachers;
import com.example.schoolapi.Service.TeachersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeachersController {
    @Autowired
    private TeachersServiceImpl teachersImpl;
    @GetMapping("/teachers")
    public ResponseEntity<Object> getTeachers(){
        try {
            List<Teachers> mo = teachersImpl.getTeachers();
            return new ResponseEntity<>(mo, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No records found",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/teachers/{teacher_id}")
    public ResponseEntity<Object> getbyid(@PathVariable int teacher_id){
        try {
            Teachers response = teachersImpl.getTeacherbyid(teacher_id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Teacher not found with the id "+teacher_id,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/teachers")
    public ResponseEntity<Teachers> addTeachers(@Valid @RequestBody Teachers teachers) {
        Teachers response=teachersImpl.addTeachers(teachers);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/teachers")
    public ResponseEntity<Teachers> updateTeachers(@Valid @RequestBody Teachers teachers) {
        Teachers response=teachersImpl.updateTeachers(teachers);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @DeleteMapping("teachers")
    public ResponseEntity<Object> delrecord(@RequestParam("teacher_id") int teacher_id){
        try {
            Teachers response = teachersImpl.delrecord(teacher_id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Teacher not found with the id"+teacher_id,HttpStatus.BAD_REQUEST);
        }
    }
}
