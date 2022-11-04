package com.example.elearning.web.dao;

import com.example.elearning.model.Course;
import com.example.elearning.model.EtudiantCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudiantCoursesDao extends JpaRepository<EtudiantCourses, Long> {

    @Query("SELECT e.idCourses FROM  EtudiantCourses e WHERE e.id =:id")
    List<Integer> getEtudiantCoursesById(Long id);


}
