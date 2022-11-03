package com.example.elearning.web.controller;

import com.example.elearning.model.Connexion;
import com.example.elearning.model.Etudiant;
import com.example.elearning.web.dao.EtudiantDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    private final EtudiantDao etudiantDao;
    public EtudiantController(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }
    @CrossOrigin
    @GetMapping("/verify/{email}")
    public String verifymail(@PathVariable String email) {
        List<Etudiant> Netudiant = etudiantDao.findAll();
        for(Etudiant x:Netudiant){
            if(x.getEmail().equals(email)) return"{\"exist\":\"true\"}";
        }
        return"{\"exist\":\"false\"}";
    }

    @CrossOrigin
    @PostMapping(value = "/register", consumes = {"application/json"})
    public String creerCompte(@RequestBody Etudiant etudiant){
        etudiantDao.save(etudiant);
        return etudiant.getEmail();
    }

    @CrossOrigin
    @PostMapping("/login")
    public Connexion getConnexion(@RequestBody Etudiant etudiant){
        List<Etudiant> Netudiant= etudiantDao.findAll();
        for(Etudiant x:Netudiant){
            if(etudiant.equals(x)) return new Connexion(x.getId(),"true",x.getName(),x.getRole());
        }
        return new Connexion(-1,"false","","");
    }

}
