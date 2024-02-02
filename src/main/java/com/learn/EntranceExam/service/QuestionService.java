package com.learn.EntranceExam.service;

import com.learn.EntranceExam.Question;
import com.learn.EntranceExam.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions(){

        try {
            List<Question> questions_list =  (questionDao.findAll());
            return new ResponseEntity<>(questions_list, HttpStatus.OK);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Question>> getAllQuestions(String catagory){

        try {
            List<Question> catagorized_questions = questionDao.findByCategory(catagory);
            return new ResponseEntity<>(catagorized_questions, HttpStatus.OK);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String>  addQuestion(Question question) {

        try {
            questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<String> deleteQuestionById(int id) {

        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("deleted",HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
