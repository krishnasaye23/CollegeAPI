package com.example.schoolapi.Controller;

import com.example.schoolapi.Entity.StudentEntity;
import com.example.schoolapi.Entity.StudentsDetailEntity;
import com.example.schoolapi.Service.StudentDetailsServiceImpl;
import com.example.schoolapi.Service.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    private StudentsServiceImpl studentsImpl;
    @Autowired
    private StudentDetailsServiceImpl studentDetailsImpl;
    @GetMapping("/students")
    public ResponseEntity<Object> getStudents(){
        try {
            List<StudentEntity> mo = studentsImpl.getStudents();
            return new ResponseEntity<>(mo, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No records found",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/students/{student_id}")
    public ResponseEntity<Object> getbyid(@Valid @PathVariable int student_id){
        StudentEntity response;
        try {
            response = studentsImpl.getStudentbyid(student_id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Student not found with the id "+student_id,HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/students/boys")
    public ResponseEntity<Object> getByGender(@Valid @RequestParam String gender) {
        List<StudentEntity> mo;
        try {
            mo = studentsImpl.getBoysOrGirls(gender);
            return new ResponseEntity<>(mo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("There are no students with the specified gender in the record now",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/students/batch")
    public ResponseEntity<Object> getByBatch(@Valid @RequestParam int batch) {
        List<StudentEntity> st;
        try{
            st=studentsImpl.getStudentsByBatch(batch);
            return new ResponseEntity<>(st,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No students found in batch "+batch,HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/students")
    public ResponseEntity<StudentEntity> addStudents(@Valid @RequestBody StudentEntity students) {
        StudentEntity response=studentsImpl.addStudents(students);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/students")
    public ResponseEntity<StudentEntity> updateStudents(@Valid @RequestBody StudentEntity students){
       StudentEntity response = studentsImpl.updateStudents(students);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/students")
    public ResponseEntity<Object> delrecord(@Valid @RequestParam("student_id") int student_id){
        StudentEntity response;
        try {
            response = studentsImpl.delrecord(student_id);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Student not found with the id "+student_id,HttpStatus.BAD_REQUEST);
        }

    }

    //API calls for StudentDetails service

    @GetMapping("/student_details")
    public ResponseEntity<Object> getStudentDetails(){
        try {
            List<StudentsDetailEntity> mo = studentDetailsImpl.getStudentDetails();
            return new ResponseEntity<>(mo, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No records found",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/student_details/{student_id}")
    public ResponseEntity<Object> getdetailsbyid(@Valid @PathVariable int student_id){
        try {
            StudentsDetailEntity response = studentDetailsImpl.getStudentDetailsbyid(student_id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Student details not found with the id"+student_id,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/student_details")
    public ResponseEntity<StudentsDetailEntity> addStudentDetails(@Valid @RequestBody StudentsDetailEntity studentsDetails) {
        StudentsDetailEntity response=studentDetailsImpl.addStudentDetails(studentsDetails);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/student_details")
    public ResponseEntity<StudentsDetailEntity> updateStudents(@Valid @RequestBody StudentsDetailEntity studentsDetails){
        StudentsDetailEntity response = studentDetailsImpl.updateStudentDetails(studentsDetails);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
