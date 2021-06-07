package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Dept_Association;
import com.example.schoolapi.Service.AssociationsServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AssociationCont {
    @Autowired
    private AssociationsServImpl associationsImpl;
    @GetMapping("/association")
    public ResponseEntity<List<Dept_Association>> getAssociation(){
        List<Dept_Association> mo=associationsImpl.getAssociation();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/association/{asc_id}")
    public ResponseEntity<Dept_Association> getbyid(@PathVariable int asc_id){
        Dept_Association response=associationsImpl.getAssociationbyid(asc_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/association/add")
    public ResponseEntity<Dept_Association> addAssociation(@Valid @RequestBody Dept_Association dept_association) {
        Dept_Association response=associationsImpl.addAssociation(dept_association);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/association/add")
    public ResponseEntity<Dept_Association> updateAssociation(@Valid @RequestBody Dept_Association dept_association){
        Dept_Association response = associationsImpl.updateAssociation(dept_association);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("association/delete")
    public ResponseEntity<Dept_Association> delrecord(@RequestParam("asc_id") int asc_id){
        Dept_Association response = associationsImpl.delrecord(asc_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
