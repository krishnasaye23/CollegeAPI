package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.Dept_AssociationEntity;
import com.example.schoolapi.Repository.AssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationsServiceImpl implements AssociationsService {
    @Autowired
    private AssociationRepo associationRepo;
    @Override
    public List<Dept_AssociationEntity> getAssociation() {
        return associationRepo.findAll();
    }
    @Override
    public Dept_AssociationEntity getAssociationbyid(int asc_id) {
        Dept_AssociationEntity opt=associationRepo.findById(asc_id);
        return opt;
    }
    @Override
    public Dept_AssociationEntity addAssociation(Dept_AssociationEntity dept_association){
        associationRepo.save(dept_association);
        return dept_association;
    }
    @Override
    public Dept_AssociationEntity updateAssociation(Dept_AssociationEntity dept_association){
        associationRepo.save(dept_association);
        return dept_association;
    }
    @Override
    public Dept_AssociationEntity delrecord(int asc_id) {
        Dept_AssociationEntity g=associationRepo.deleteById(asc_id);
        return g;
    }
}
