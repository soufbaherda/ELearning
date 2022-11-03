package com.example.elearning.web.dao;

import com.example.elearning.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant,Long> {
    Etudiant findById(long id);

    @Override
    List<Etudiant> findAll();

}
