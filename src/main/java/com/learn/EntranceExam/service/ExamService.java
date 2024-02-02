package com.learn.EntranceExam.service;


import com.learn.EntranceExam.dao.ExamDao;
import com.learn.EntranceExam.dao.QuestionDao;
import com.learn.EntranceExam.model.Exam;
import com.learn.EntranceExam.model.Question;
import com.learn.EntranceExam.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {


    @Autowired
    ExamDao examdao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int nOfQuestion, String topic) {

        List<Question> exam_questions = questionDao.getRandomQuestionsByCategory(category,nOfQuestion);
        Exam exam = new Exam();
        exam.setExam_questions(exam_questions);
        exam.setTitle(topic);
        examdao.save(exam);
        return new ResponseEntity<>("Exam "+topic+" is created!",HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getExamQuestionsByExamId(int examId){

             Optional<Exam> exam =   examdao.findById(examId);
             List<Question> examQuestions = exam.get().getExam_questions();
             List<QuestionWrapper> questionsWithoutAnswer = new ArrayList<>();
             QuestionWrapper qw = null;
             for(Question q : examQuestions){
                 qw = new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption_1(),q.getOption_2(),q.getOption_3(),q.getOption_4());
                 questionsWithoutAnswer.add(qw);
             }
            return new ResponseEntity<>(questionsWithoutAnswer,HttpStatus.OK);
    }
}
