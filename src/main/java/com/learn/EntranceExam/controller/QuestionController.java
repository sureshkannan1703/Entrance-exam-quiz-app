package com.learn.EntranceExam.controller;

import com.learn.EntranceExam.Question;
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
    public List<Question> getAllQuestion(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category_name}")
    public List<Question> getQuestionsByCatagory(@PathVariable("category_name") String category){

            return questionService.getAllQuestions(category);
    }

    @PostMapping("addquestion")
    public String addQuestion(@RequestBody Question question){

        questionService.addQuestion(question);
        return "success";
    }
}
