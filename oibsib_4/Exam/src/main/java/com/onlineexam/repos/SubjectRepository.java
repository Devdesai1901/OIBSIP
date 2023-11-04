package com.onlineexam.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineexam.models.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Integer>{

}
