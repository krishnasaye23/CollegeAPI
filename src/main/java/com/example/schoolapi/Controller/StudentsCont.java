package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Students;
import com.example.schoolapi.Model.StudentsDetails;
import com.example.schoolapi.Service.StudentDetailsServImpl;
import com.example.schoolapi.Service.StudentsServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentsCont {
    @Autowired
    private StudentsServImpl studentsImpl;
    @Autowired
    private StudentDetailsServImpl studentDetailsImpl;
    @GetMapping("/students")
    public ResponseEntity<List<Students>> getStudents(){
        List<Students> mo=studentsImpl.getStudents();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/students/{student_id}")
    public ResponseEntity<Students> getbyid(@PathVariable int student_id){
        Students response=studentsImpl.getStudentbyid(student_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/students/add")
    public ResponseEntity<Students> addStudents(@Valid @RequestBody Students students) {
        Students response=studentsImpl.addStudents(students);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/students/add")
    public ResponseEntity<Students> updateStudents(@Valid @RequestBody Students students){
       Students response = studentsImpl.updateStudents(students);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("students/delete")
    public ResponseEntity<Students> delrecord(@RequestParam("student_id") int student_id){
        Students response = studentsImpl.delrecord(student_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/student_details")
    public ResponseEntity<List<StudentsDetails>> getStudentDetails(){
        List<StudentsDetails> mo=studentDetailsImpl.getStudentDetails();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/student_details/{student_id}")
    public ResponseEntity<StudentsDetails> getdetailsbyid(@PathVariable int student_id){
        StudentsDetails response= studentDetailsImpl.getStudentDetailsbyid(student_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/student_details/add")
    public ResponseEntity<StudentsDetails> addStudentDetails(@Valid @RequestBody StudentsDetails studentsDetails) {
        StudentsDetails response=studentDetailsImpl.addStudentDetails(studentsDetails);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/student_details/add")
    public ResponseEntity<StudentsDetails> updateStudents(@Valid @RequestBody StudentsDetails studentsDetails){
        StudentsDetails response = studentDetailsImpl.updateStudentDetails(studentsDetails);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
