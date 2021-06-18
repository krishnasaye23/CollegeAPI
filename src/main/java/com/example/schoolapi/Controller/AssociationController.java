package com.example.schoolapi.Controller;

import com.example.schoolapi.Entity.Dept_AssociationEntity;
import com.example.schoolapi.Service.AssociationsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Gets all the associations from the repository")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "SUCCESS",response = Dept_AssociationEntity.class),
            @ApiResponse(code= 401,message = "UNAUTHORIZED"),
            @ApiResponse(code = 403,message = "FORBIDDEN"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<List<Dept_AssociationEntity>> getAssociation(){
        List<Dept_AssociationEntity> mo=associationsImpl.getAssociation();
        return new ResponseEntity<>(mo, HttpStatus.OK);
    }
    @GetMapping("/association/{asc_id}")
    @ApiOperation(value = "Gets the associations by id",
            notes = "Enter an id to get the specific records of that association",
            response = Dept_AssociationEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "SUCCESS",response = Dept_AssociationEntity.class),
            @ApiResponse(code= 401,message = "UNAUTHORIZED"),
            @ApiResponse(code = 403,message = "FORBIDDEN"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Dept_AssociationEntity> getbyid(@Valid @PathVariable int asc_id){
        Dept_AssociationEntity response=associationsImpl.getAssociationbyid(asc_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/association")
    public ResponseEntity<Dept_AssociationEntity> addAssociation(@Valid @RequestBody Dept_AssociationEntity dept_association) {
        Dept_AssociationEntity response=associationsImpl.addAssociation(dept_association);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/association")
    @ApiOperation(value = "Updates the association with given new records")
    public ResponseEntity<Dept_AssociationEntity> updateAssociation(@Valid @RequestBody Dept_AssociationEntity dept_association){
        Dept_AssociationEntity response = associationsImpl.updateAssociation(dept_association);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/association")
    @ApiOperation(value = "Deletes the association by its id",
                  notes = "Provide an id to delete the specific association with the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "SUCCESS",response = Dept_AssociationEntity.class),
            @ApiResponse(code= 401,message = "UNAUTHORIZED"),
            @ApiResponse(code = 403,message = "FORBIDDEN"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Dept_AssociationEntity> delrecord(@RequestParam("asc_id") int asc_id){
        Dept_AssociationEntity response = associationsImpl.delrecord(asc_id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
