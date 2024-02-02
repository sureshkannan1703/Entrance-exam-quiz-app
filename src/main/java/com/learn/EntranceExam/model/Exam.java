package com.learn.EntranceExam.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Exam {

    @Id
    int exam_id;

    String title;

    @ManyToMany
    List<Question> exam_questions;
}
