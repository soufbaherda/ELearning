package com.example.elearning.web.Service;

import com.example.elearning.VO.ResponseTemplateVO;
import com.example.elearning.model.Course;
import com.example.elearning.model.Etudiant;
import com.example.elearning.web.dao.CourseDao;
import com.example.elearning.web.dao.EtudiantCoursesDao;
import com.example.elearning.web.dao.EtudiantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    private final EtudiantDao etudiantDao;
    @Autowired
    private RestTemplate restTemplate;

    public EtudiantService(EtudiantDao etudiantDao, EtudiantCoursesDao etudiantCoursesDao, CourseDao courseDao) {
        this.etudiantDao = etudiantDao;
        this.etudiantCoursesDao = etudiantCoursesDao;
        this.courseDao = courseDao;
    }


    private final EtudiantCoursesDao etudiantCoursesDao;
    private final CourseDao courseDao;

    public ResponseTemplateVO getUserWithCourses(Long userId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Etudiant> user = etudiantDao.findById(userId);
        List<Integer> etd_cours = etudiantCoursesDao.getEtudiantCoursesById(user.get().getId());

        for(int i=0; i<etd_cours.toArray().length; i++){
            Course course =
                    restTemplate.getForObject("http://localhost:8080/cours/" + etd_cours.get(i), Course.class);
            vo.setCourse(course);
        }
        vo.setEtudiant(user.get());
//        Course course =
//                restTemplate.getForObject("http://localhost:8080/cours/" + user.get().getCoursesId(), Course.class);
//        vo.setEtudiant(user.get());
//        vo.setCours(List.of(course));

        return vo;
    }
    public ResponseTemplateVO getCoursesWithUser(int courseId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Course> course = courseDao.findById(courseId);
        List<Integer> etd_cours = etudiantCoursesDao.getCourseEtudiantsByIdCourses(course.get().getId());

        for(int i=0; i<etd_cours.toArray().length; i++){
            Etudiant etudiant =  restTemplate.getForObject("http://localhost:8081/users/" + etd_cours.get(i), Etudiant.class);
            vo.setEtudiant(etudiant);
        }
        vo.setCourse(course.get());
        return vo;
    }
}
