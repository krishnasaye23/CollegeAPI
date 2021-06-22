package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.Dept_AssociationEntity;
import com.example.schoolapi.Model.Departments;
import com.example.schoolapi.Model.Dept_Associations;
import com.example.schoolapi.Repository.AssociationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociationsServiceImpl implements AssociationsService {

    @Autowired
    private AssociationRepo associationRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Dept_Associations> getAssociation() {

        return associationRepo.findAll().stream().map(dept_associationEntity -> modelMapper.map(dept_associationEntity, Dept_Associations.class))
                .collect(Collectors.toList());
    }
    @Override
    public Dept_Associations getAssociationbyid(int asc_id) {
        Dept_AssociationEntity deptAssociationEntity= associationRepo.findById(asc_id);
        Dept_Associations dep=modelMapper.map(deptAssociationEntity,Dept_Associations.class);
        return dep;
    }
    @Override
    public Dept_Associations addAssociation(Dept_Associations dept_association){
        Dept_AssociationEntity dep=modelMapper.map(dept_association,Dept_AssociationEntity.class);
        associationRepo.save(dep);
        Dept_Associations deps=modelMapper.map(dep,Dept_Associations.class);
        return deps;
    }
    @Override
    public Dept_Associations updateAssociation(Dept_Associations dept_association){
        Dept_AssociationEntity dep=modelMapper.map(dept_association,Dept_AssociationEntity.class);
        associationRepo.save(dep);
        Dept_Associations deps=modelMapper.map(dep,Dept_Associations.class);
        return deps;
    }
    @Override
    public Dept_Associations delrecord(int asc_id) {
        Dept_AssociationEntity g=associationRepo.deleteById(asc_id);
        Dept_Associations deps=modelMapper.map(g,Dept_Associations.class);
        return deps;
    }
}
