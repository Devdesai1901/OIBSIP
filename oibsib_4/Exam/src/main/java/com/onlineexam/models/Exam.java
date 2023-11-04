package com.onlineexam.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	private LocalDate examdate;
	private String status;
	private String result;
	
	public Exam() {
		this.examdate=LocalDate.now();
		this.status="Scheduled";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getExamdate() {
		return examdate;
	}
	public void setExamdate(LocalDate examdate) {
		this.examdate = examdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", userid=" + user + ", examdate=" + examdate + ", status=" + status + ", result="
				+ result + "]";
	}
	
	
}
