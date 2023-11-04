package com.onlineexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.models.Question;
import com.onlineexam.models.Subject;
import com.onlineexam.repos.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired private QuestionRepository repo;
	
	
	public void saveQuestion(Question q) {
		repo.save(q);
	}
	
	public List<Question> allQuestions() {
		return repo.findAll();
	}
	
	public List<Question> allSubjectQuestions(Subject sub) {
		return repo.findBySubject(sub);
	}
	
	public Question getQuestionById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteQuestion(int id) {
		repo.deleteById(id);
	}

}
