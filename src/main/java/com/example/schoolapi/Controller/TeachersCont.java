package com.example.schoolapi.Controller;


import com.example.schoolapi.Model.Teachers;
import com.example.schoolapi.Service.TeachersServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherCont {
    @Autowired
    private TeachersServImpl teachersImpl;
    @GetMapping("/teachers")
    public ResponseEntity<List<Teachers>> getTeachers(){
        List<Teachers> mo=teachersImpl.getTeachers();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @PostMapping("/teachers/addteachers")
    public ResponseEntity<Teachers> addTeachers(@RequestBody Teachers teachers) {
        Teachers response=teachersImpl.addTeachers(teachers);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
