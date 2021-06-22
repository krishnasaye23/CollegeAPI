package com.example.schoolapi.Service;

import com.example.schoolapi.Entity.StudentsDetailEntity;
import com.example.schoolapi.Model.StudentsDetails;
import com.example.schoolapi.Repository.StudentDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {
    @Autowired
    private StudentDetailsRepo studentDetailsRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StudentsDetails> getStudentDetails() {

        return studentDetailsRepo.findAll().stream().map(studentsDetailEntity -> modelMapper.map(studentsDetailEntity, StudentsDetails.class))
                .collect(Collectors.toList());
    }
    @Override
    public StudentsDetails getStudentDetailsbyid(int student_id) {
        StudentsDetailEntity studentsDetailEntity= studentDetailsRepo.findById(student_id);
        StudentsDetails dep=modelMapper.map(studentsDetailEntity,StudentsDetails.class);
        return dep;
    }
    @Override
    public StudentsDetails addStudentDetails(StudentsDetails studentsDetails){
        StudentsDetailEntity dep=modelMapper.map(studentsDetails,StudentsDetailEntity.class);
        studentDetailsRepo.save(dep);
        StudentsDetails deps=modelMapper.map(dep,StudentsDetails.class);
        return deps;
    }
    @Override
    public StudentsDetails updateStudentDetails(StudentsDetails studentsDetails){
        StudentsDetailEntity dep=modelMapper.map(studentsDetails,StudentsDetailEntity.class);
        studentDetailsRepo.save(dep);
        StudentsDetails deps=modelMapper.map(dep,StudentsDetails.class);
        return deps;
    }
}
