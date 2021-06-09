package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Dept_Association;

import java.util.List;

public interface AssociationsService {
    List<Dept_Association> getAssociation();
    Dept_Association getAssociationbyid(int asc_id);
    Dept_Association addAssociation(Dept_Association dept_association);
    Dept_Association updateAssociation(Dept_Association dept_association);
    Dept_Association delrecord(int asc_id);
}
