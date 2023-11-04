package com.onlineexam.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineexam.models.Exam;
import com.onlineexam.models.User;

@Repository
public interface ExamRepository  extends JpaRepository<Exam, Integer>{
	List<Exam> findByResult(String result);
	Optional<Exam> findByUser(User user);
}
