package com.example.elearning.VO;

import com.example.elearning.model.Course;
import com.example.elearning.model.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Etudiant etudiant;
    private List<Course> courses = new ArrayList<Course>();

    public void setCourse(Course course) {
        this.courses.add(course);
    }

}

