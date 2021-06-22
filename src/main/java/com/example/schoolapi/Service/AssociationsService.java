package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Dept_Associations;

import java.util.List;

public interface AssociationsService {
    List<Dept_Associations> getAssociation();
    Dept_Associations getAssociationbyid(int asc_id);
    Dept_Associations addAssociation(Dept_Associations dept_association);
    Dept_Associations updateAssociation(Dept_Associations dept_association);
    Dept_Associations delrecord(int asc_id);
}
