package com.onlineexam.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.models.Exam;
import com.onlineexam.models.ExamQuiz;
import com.onlineexam.models.Question;
import com.onlineexam.models.User;
import com.onlineexam.repos.ExamQuizRepository;
import com.onlineexam.repos.ExamRepository;

@Service
public class ExamService {

	@Autowired private ExamRepository repo;
	@Autowired private ExamQuizRepository eqrepo;
	@Autowired private UserService uservice;
	@Autowired private QuestionService qservice;
	
	public Integer clearCount() {
		return repo.findByResult("Pass").size();
	}
	
	public Integer failureCount() {
		return repo.findByResult("Fail").size();
	}
	
	public void createExam(String userid) {
		User user=uservice.findByUserid(userid);
		List<Question> listall=qservice.allSubjectQuestions(user.getSubject());
		Collections.shuffle(listall);
		for(Question q : listall) {
			ExamQuiz eq=new ExamQuiz();
			eq.setQuestion(q);
			eq.setUser(user);
			eqrepo.save(eq);
		}
		
		Exam ex=new Exam();
		ex.setUser(user);
		repo.save(ex);
	}
	
	public void updateExamQuiz(ExamQuiz eq) {
		System.out.println(eq);
		ExamQuiz exq=eqrepo.findById(eq.getId()).get();
		exq.setTime(eq.getTime());
		exq.setUans(eq.getUans());
		eqrepo.save(exq);
	}
	
	public void submitExam(String userid) {
		List<ExamQuiz> elist=getQuestions(userid);
		int total=elist.size();
		int correct=0;
		for(ExamQuiz eq : elist) {
			if(eq.getUans()!=null && eq.getUans().equals(eq.getQuestion().getCans()))
				correct++;
		}
		String result=(correct*100/total)>=40 ? "Pass" : "Fail";
		Exam exam=repo.findByUser(uservice.findByUserid(userid)).get();
		exam.setStatus("Completed");
		exam.setResult(result);
		repo.save(exam);
	}
	
	public boolean checkExam(String userid) {
		Exam exam=repo.findByUser(uservice.findByUserid(userid)).orElse(null);
		if(exam!=null && exam.getStatus().equals("Scheduled")) return true;
		return false;
	}
	
	public int totalQuiz(String userid) {
		return eqrepo.findByUser(uservice.findByUserid(userid)).size();
	}
	
	public int correctCount(String userid) {
		List<ExamQuiz> elist=getQuestions(userid);
		int total=elist.size();
		int correct=0;
		for(ExamQuiz eq : elist) {
			if(eq.getUans()!=null && eq.getUans().equals(eq.getQuestion().getCans()))
				correct++;
		}
		return correct;
	}
	
	public int incorrectCount(String userid) {
		List<ExamQuiz> elist=getQuestions(userid);
		int total=elist.size();
		int correct=0;
		for(ExamQuiz eq : elist) {
			if(eq.getUans()!=null && eq.getUans().equals(eq.getQuestion().getCans()))
				correct++;
		}
		return total-correct;
	}
	
	public List<ExamQuiz> getQuestions(String userid){
		return eqrepo.findByUser(uservice.findByUserid(userid));
	}
	
	public List<Integer> getQuestionsIds(String userid){		
		return getQuestions(userid).stream().map(x->x.getQuestion().getId()).collect(Collectors.toList());
	}
	
	public ExamQuiz getExamquizById(int id,String userid){		
		return eqrepo.findByUserAndId(uservice.findByUserid(userid), id);
	}
	
}
