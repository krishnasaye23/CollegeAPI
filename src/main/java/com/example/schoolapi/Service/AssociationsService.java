package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.Dept_AssociationEntity;

import java.util.List;

public interface AssociationsService {
    List<Dept_AssociationEntity> getAssociation();
    Dept_AssociationEntity getAssociationbyid(int asc_id);
    Dept_AssociationEntity addAssociation(Dept_AssociationEntity dept_association);
    Dept_AssociationEntity updateAssociation(Dept_AssociationEntity dept_association);
    Dept_AssociationEntity delrecord(int asc_id);
}
