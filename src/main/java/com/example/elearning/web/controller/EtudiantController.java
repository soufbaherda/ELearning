package com.example.elearning.web.controller;

import com.example.elearning.VO.ResponseTemplateVO;
import com.example.elearning.model.Connexion;
import com.example.elearning.model.Etudiant;
import com.example.elearning.model.EtudiantCourses;
import com.example.elearning.web.Service.EtudiantService;
import com.example.elearning.web.dao.EtudiantCoursesDao;
import com.example.elearning.web.dao.EtudiantDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class EtudiantController {
    private final EtudiantDao etudiantDao;
    public EtudiantController(EtudiantDao etudiantDao, EtudiantService userService, EtudiantCoursesDao etudiantCoursesDao) {
        this.etudiantDao = etudiantDao;
        this.userService = userService;
        this.etudiantCoursesDao = etudiantCoursesDao;
    }
    public final EtudiantService userService;

    @CrossOrigin
    @GetMapping("/users")
    public List<Etudiant> getUsers(){
        return etudiantDao.findAll();
    }

    @CrossOrigin
    @GetMapping("/users/{id}")
    public Optional<Etudiant> getUserWithId(@PathVariable("id") Long id){
        return etudiantDao.findById(id);
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

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithCourses( @PathVariable("id") Long userId){
        return userService.getUserWithCourses(userId);
    }

    private final EtudiantCoursesDao etudiantCoursesDao;

    @CrossOrigin
    @GetMapping("/{id}/courses")
    public List<Integer> getEtudiantsWithCourse(@PathVariable("id") Long id){
        return etudiantCoursesDao.getEtudiantCoursesById(id);
    }
    @CrossOrigin
    @GetMapping("/{id}/users")
    public int getNumUser(@PathVariable("id") int id){
        //return userService.getCoursesWithUser(id);
        return etudiantCoursesDao.getNumetudiant(id);
    }

    @CrossOrigin
    @GetMapping("/{id}/usersCours")
    public ResponseTemplateVO getCoursesEtudiants(@PathVariable("id") int id){
        return userService.getCoursesWithUser(id);
    }
    @CrossOrigin
    @PostMapping("/users/{id}")
    public void addBook(@RequestBody EtudiantCourses etdCours){
        etudiantCoursesDao.save(etdCours);
    }


    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id ){
        etudiantDao.deleteById(id);
    }
    @PutMapping("/update")
    public String upDateCompte(@RequestBody Etudiant etudiant){
        etudiantDao.save(etudiant);
        return etudiant.getRole();
    }
}
