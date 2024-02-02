package com.learn.EntranceExam.service;

import com.learn.EntranceExam.Question;
import com.learn.EntranceExam.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions(){

        List<Question> questions_list =  (questionDao.findAll());
        for(Question q : questions_list){
            System.out.println(q.getId()+" "+q.getQuestion_title()+" "+q.getRight_answer());
        }
        return questions_list;
    }

    public List<Question> getAllQuestions(String catagory){

        List<Question> catagorized_questions = questionDao.findByCategory(catagory);
        return catagorized_questions;
    }

    public String addQuestion(Question question) {

        questionDao.save(question);
        return "true";
    }

    public String deleteQuestionById(int id) {

        questionDao.deleteById(id);
        return "deleted";
    }
}
