package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Department;
import com.example.schoolapi.Service.DepartmentsServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentCont {
    @Autowired
    private DepartmentsServImpl departmentsImpl;
    @GetMapping("/department")
    public ResponseEntity<List<Department>> getDepartment(){
        List<Department> mo=departmentsImpl.getDepartments();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/department/{dept_id}")
    public ResponseEntity<Department> getbyid(@PathVariable int dept_id){
        Department response=departmentsImpl.getDepartmentbyid(dept_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/department")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        Department response=departmentsImpl.addDepartments(department);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/department")
    public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department){
        Department response = departmentsImpl.updateDepartments(department);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("department")
    public ResponseEntity<Department> delrecord(@RequestParam("dept_id") int dept_id){
        Department response = departmentsImpl.delrecord(dept_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
