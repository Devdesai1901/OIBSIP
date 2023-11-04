package com.onlineexam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineexam.models.Question;
import com.onlineexam.models.Subject;
import com.onlineexam.services.ExamService;
import com.onlineexam.services.QuestionService;
import com.onlineexam.services.SubjectService;
import com.onlineexam.services.UserService;

@Controller
public class AdminController {
	
	@Autowired UserService uservice;
	@Autowired QuestionService qservice;
	@Autowired HttpSession session;
	@Autowired ExamService eservice;
	@Autowired SubjectService sservice;

	@GetMapping("/dashboard")
	public String home(Model model) {
		model.addAttribute("totalques", qservice.allQuestions().size());
		model.addAttribute("totalusers", uservice.allUsers().size());
		model.addAttribute("totalclear", eservice.clearCount());
		model.addAttribute("totalfail", eservice.failureCount());
		return "dashboard";
	}
	
	@GetMapping("/addques")
	public String add_question(Model model) {
		model.addAttribute("subs", sservice.allSubjects());
		return "addquestion";
	}
	
	@GetMapping("/subjects")
	public String subjects(Model model) {
		model.addAttribute("list",sservice.allSubjects());
		return "subjects";
	}
	
	@PostMapping("/subjects")
	public String saveSubject(Subject sub) {
		sservice.saveSubject(sub);
		return "redirect:/subjects";
	}
	
	@GetMapping("/questions/{id}")
	public String allquestion(@PathVariable("id") int id, Model model) {
		Subject sub=sservice.getSubjectById(id);
		model.addAttribute("sub", sub);
		model.addAttribute("list", qservice.allSubjectQuestions(sub));
		return "questions";
	}
	
	@GetMapping("/delsub/{id}")
	public String delsubs(@PathVariable("id") int id) {
		sservice.deleteSubject(id);
		return "redirect:/subjects";
	}
	
	@GetMapping("/delques/{subid}/{id}")
	public String delquestions(@PathVariable("subid") int subid,@PathVariable("id") int id) {
		qservice.deleteQuestion(id);
		return "redirect:/questions/"+subid;
	}
	
	@PostMapping("/addques")
	public String save_question(Question q,RedirectAttributes ra) {
		System.out.println(q);
		qservice.saveQuestion(q);
		ra.addFlashAttribute("msg", "Question added successfully..!!");
		return "redirect:/questions/"+q.getSubject().getId();
	}
	
	@GetMapping("/users")
	public String allusers(Model model) {
		model.addAttribute("list", uservice.allUsers());
		return "users";
	}
	
	@GetMapping("/report")
	public String examreport(Model model,String userid) {
		model.addAttribute("user", uservice.findByUserid(userid));
		model.addAttribute("correct", eservice.correctCount(userid));
		model.addAttribute("incorrect", eservice.incorrectCount(userid));
		model.addAttribute("list", eservice.getQuestions(userid));
		return "examreport";
	}
	
}
