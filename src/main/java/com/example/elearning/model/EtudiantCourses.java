package com.example.elearning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.awt.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CompositeKey.class)
public class EtudiantCourses {
    @Id
    private Long id;
    @Id
    private int idCourses;
}
