package com.onlineexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.models.Subject;
import com.onlineexam.repos.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired private SubjectRepository repo;
	
	public void saveSubject(Subject q) {
		repo.save(q);
	}
	
	public List<Subject> allSubjects() {
		return repo.findAll();
	}
	
	public Subject getSubjectById(int id) {
		return repo.findById(id).orElse(null);
	}

	public void deleteSubject(int id) {
		repo.deleteById(id);
	}
}
