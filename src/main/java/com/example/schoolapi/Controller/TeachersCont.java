package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Teachers;
import com.example.schoolapi.Service.TeachersServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeachersCont {
    @Autowired
    private TeachersServImpl teachersImpl;
    @GetMapping("/teachers")
    public ResponseEntity<List<Teachers>> getTeachers(){
        List<Teachers> mo=teachersImpl.getTeachers();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/teachers/{teacher_id}")
    public ResponseEntity<Teachers> getbyid(@PathVariable int teacher_id){
        Teachers response=teachersImpl.getTeacherbyid(teacher_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/teachers/add")
    public ResponseEntity<Teachers> addTeachers(@Valid @RequestBody Teachers teachers) {
        Teachers response=teachersImpl.addTeachers(teachers);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/teachers/add")
    public ResponseEntity<Teachers> updateTeachers(@Valid @RequestBody Teachers teachers) {
        Teachers response=teachersImpl.updateTeachers(teachers);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @DeleteMapping("teachers/delete")
    public ResponseEntity<Teachers> delrecord(@RequestParam("teacher_id") int teacher_id){
        Teachers response = teachersImpl.delrecord(teacher_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}
