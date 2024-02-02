package com.learn.EntranceExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntranceExamApplication {

	public static void main(String[] args) {

		SpringApplication.run(EntranceExamApplication.class, args);
		System.out.println("Hellow world!");
		Question q = new Question();
		System.out.println(q.getId()+" "+q.getCategory());
	}


}
