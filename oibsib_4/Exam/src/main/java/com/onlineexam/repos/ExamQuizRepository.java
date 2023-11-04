package com.onlineexam.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineexam.models.ExamQuiz;
import com.onlineexam.models.User;

@Repository
public interface ExamQuizRepository  extends JpaRepository<ExamQuiz, Integer>{
	List<ExamQuiz> findByUser(User user);
	ExamQuiz findByUserAndId(User user,int id);
}
