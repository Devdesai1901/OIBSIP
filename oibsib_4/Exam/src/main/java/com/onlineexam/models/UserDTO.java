package com.onlineexam.models;

import java.time.LocalDate;

public class UserDTO extends User {
	private LocalDate examdate;
	private String status;
	private String result;
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
		return "UserDTO [examdate=" + examdate + ", status=" + status + ", result=" + result + "]";
	}
	
	
}
