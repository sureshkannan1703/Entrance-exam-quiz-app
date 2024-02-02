package com.learn.EntranceExam.controller;

import com.learn.EntranceExam.model.Question;
import com.learn.EntranceExam.model.QuestionWrapper;
import com.learn.EntranceExam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("create")
    public ResponseEntity<String> createExam(@RequestParam String category, @RequestParam int nOfQuestion, @RequestParam String topic){

        return examService.createQuiz(category, nOfQuestion, topic);
    }

    @GetMapping ("getexambyid/{exam_id}")
    public ResponseEntity<List<QuestionWrapper>> getExamQuestionsByExamId(@PathVariable("exam_id") int examId){

        return examService.getExamQuestionsByExamId(examId);
    }


}
