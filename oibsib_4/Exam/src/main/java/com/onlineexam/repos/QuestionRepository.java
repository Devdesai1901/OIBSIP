package com.onlineexam.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineexam.models.Question;
import com.onlineexam.models.Subject;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Integer>{
	List<Question> findBySubject(Subject sub);
}
