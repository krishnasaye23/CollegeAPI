package com.example.schoolapi.Controller;

import com.example.schoolapi.Entity.DepartmentEntity;
import com.example.schoolapi.Service.DepartmentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentsServiceImpl departmentsImpl;
    @GetMapping("/department")
    public ResponseEntity<Object> getDepartment(){
        try {
            List<DepartmentEntity> mo = departmentsImpl.getDepartments();
            return new ResponseEntity<>(mo, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No records found",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/department/{dept_id}")
    public ResponseEntity<Object> getbyid(@PathVariable int dept_id){
        try {
            DepartmentEntity response = departmentsImpl.getDepartmentbyid(dept_id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Department not found with the id "+dept_id,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/department")
    public ResponseEntity<DepartmentEntity> addDepartment(@Valid @RequestBody DepartmentEntity department) {
        DepartmentEntity response=departmentsImpl.addDepartments(department);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/department")
    public ResponseEntity<DepartmentEntity> updateDepartment(@Valid @RequestBody DepartmentEntity department){
        DepartmentEntity response = departmentsImpl.updateDepartments(department);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("department")
    public ResponseEntity<Object> delrecord(@RequestParam("dept_id") int dept_id){
        try {
            DepartmentEntity response = departmentsImpl.delrecord(dept_id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Department not found with the id "+dept_id,HttpStatus.BAD_REQUEST);
        }
    }
}
