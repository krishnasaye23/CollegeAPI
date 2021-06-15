package com.example.schoolapi;

import com.example.schoolapi.Entity.TeacherEntity;
import com.example.schoolapi.Repository.TeacherRepo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TeacherRepoTests {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private TeacherRepo teacherRepo;
    @Test
    @Rollback(value = false)
    @Order(1)
    public void testSaveNewTeacher() {

        testEntityManager.persist(new TeacherEntity(301,"Joseph"));
        TeacherEntity teacherEntity = teacherRepo.findById(301);
        assertThat(teacherEntity.getTeacher_id()).isEqualTo(301);
    }
    @Test
    @Rollback(false)
    @Order(4)
    public void testDeleteTeacher() {

       // TeacherEntity teacherEntity = teacherRepo.findById(301);
        teacherRepo.deleteById(301);
        TeacherEntity deletedProduct = teacherRepo.findById(301);
        assertThat(deletedProduct).isNull();
    }
    @Test
    @Rollback(false)
    @Order(2)
    public void testUpdateTeacher() {

        TeacherEntity teacherEntity = teacherRepo.findById(301);
        teacherEntity.setTeacher_name("Kyle");
        testEntityManager.persist(teacherEntity);
        teacherRepo.save(teacherEntity);
        TeacherEntity updatedTeacher = teacherRepo.findById(301);
        assertThat(updatedTeacher.getTeacher_name()).isEqualTo("Kyle");
    }
    @Test
    @Order(3)
    public void testListTeachers() {
        List<TeacherEntity> teachers = teacherRepo.findAll();
        assertThat(teachers).size().isGreaterThan(0);
    }

}
