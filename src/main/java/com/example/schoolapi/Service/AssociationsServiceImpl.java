package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Dept_Association;
import com.example.schoolapi.Repository.AssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationsServImpl implements AssociationsServ{
    @Autowired
    private AssociationRepo associationRepo;
    @Override
    public List<Dept_Association> getAssociation() {
        return associationRepo.findAll();
    }
    @Override
    public Dept_Association getAssociationbyid(int asc_id) {
        Dept_Association opt=associationRepo.findById(asc_id);
        return opt;
    }
    @Override
    public Dept_Association addAssociation(Dept_Association dept_association){
        associationRepo.save(dept_association);
        return dept_association;
    }
    @Override
    public Dept_Association updateAssociation(Dept_Association dept_association){
        associationRepo.save(dept_association);
        return dept_association;
    }
    @Override
    public Dept_Association delrecord(int asc_id) {
        Dept_Association g=associationRepo.deleteById(asc_id);
        return g;
    }
}
