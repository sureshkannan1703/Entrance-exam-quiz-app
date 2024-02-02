package com.learn.EntranceExam.controller;

import com.learn.EntranceExam.model.Question;
import com.learn.EntranceExam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category_name}")
    public ResponseEntity<List<Question>> getQuestionsByCatagory(@PathVariable("category_name") String category){
            return questionService.getAllQuestions(category);
    }

    @PostMapping("addquestion")
    public ResponseEntity<String>  addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("deletequestion/{question_id}")
    public ResponseEntity<String>  deleteQuestionById(@PathVariable("question_id") int id){
        return questionService.deleteQuestionById(id);
    }
}
