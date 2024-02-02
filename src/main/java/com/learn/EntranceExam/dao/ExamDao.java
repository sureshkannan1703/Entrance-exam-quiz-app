package com.learn.EntranceExam.dao;


import com.learn.EntranceExam.model.Exam;
import com.learn.EntranceExam.model.Question;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDao extends JpaRepository<Exam, Integer> {
}
