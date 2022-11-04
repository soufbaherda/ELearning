package com.example.elearning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Course {
        @Id
        //@GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String name;
        private String university;
        private String difficultyLevel;
        private String link;
        private String About;
        private String img;


    }

