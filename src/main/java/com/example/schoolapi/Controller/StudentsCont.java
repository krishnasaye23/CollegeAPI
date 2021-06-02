package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Students;
import com.example.schoolapi.Service.StudentsServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsCont {
    @Autowired
    private StudentsServImpl studentsImpl;
    @GetMapping("/students")
    public ResponseEntity<List<Students>> getStudents(){
        List<Students> mo=studentsImpl.getStudents();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
}
