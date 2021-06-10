package com.example.schoolapi.Controller;

import com.example.schoolapi.Entity.Dept_AssociationEntity;
import com.example.schoolapi.Service.AssociationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AssociationController {
    @Autowired
    private AssociationsServiceImpl associationsImpl;
    @GetMapping("/association")
    public ResponseEntity<List<Dept_AssociationEntity>> getAssociation(){
        List<Dept_AssociationEntity> mo=associationsImpl.getAssociation();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/association/{asc_id}")
    public ResponseEntity<Dept_AssociationEntity> getbyid(@PathVariable int asc_id){
        Dept_AssociationEntity response=associationsImpl.getAssociationbyid(asc_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/association")
    public ResponseEntity<Dept_AssociationEntity> addAssociation(@Valid @RequestBody Dept_AssociationEntity dept_association) {
        Dept_AssociationEntity response=associationsImpl.addAssociation(dept_association);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/association")
    public ResponseEntity<Dept_AssociationEntity> updateAssociation(@Valid @RequestBody Dept_AssociationEntity dept_association){
        Dept_AssociationEntity response = associationsImpl.updateAssociation(dept_association);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("association")
    public ResponseEntity<Dept_AssociationEntity> delrecord(@RequestParam("asc_id") int asc_id){
        Dept_AssociationEntity response = associationsImpl.delrecord(asc_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
