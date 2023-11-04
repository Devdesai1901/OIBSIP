package com.onlineexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineexam.models.ExamQuiz;
import com.onlineexam.models.Question;
import com.onlineexam.models.User;
import com.onlineexam.services.ExamService;
import com.onlineexam.services.QuestionService;
import com.onlineexam.services.SubjectService;
import com.onlineexam.services.UserService;

@Controller
public class UserController {

	@Autowired HttpSession session;
	
	@Autowired ExamService eservice;
	@Autowired QuestionService qservice;
	@Autowired UserService uservice;

	
	@PostMapping("/register")
	public String regprocess(Model model,User user,RedirectAttributes ra) {
		System.out.println(user);
		if(!uservice.checkAvailablity(user.getUserid())) {
			uservice.saveUser(user);
			eservice.createExam(user.getUserid());
			ra.addFlashAttribute("msg", "User registered successfully..!!");
			return "redirect:/";
		}else {
			ra.addFlashAttribute("error", "Userid not available..!!");
			model.addAttribute("user", user);
			return "register";
		}
		
	}
	
	@GetMapping("/instructions")
	public String instructions(RedirectAttributes ra) {
		String userid=((User)session.getAttribute("user")).getUserid();
		System.out.println(userid);
		if(eservice.checkExam(userid)) {;
			return "instructions";
		}else {
			//ra.addFlashAttribute("error", "Exam already submitted");
			return "redirect:/myreport";
		}
	}
	
	@GetMapping("/Start")
	public String startexam(Model model) {
		if(session.getAttribute("user")!=null) {
			String userid=((User)session.getAttribute("user")).getUserid();
			int total=eservice.totalQuiz(userid);
			List<ExamQuiz> questions=eservice.getQuestions(userid);
			session.setAttribute("total", total);
			
			if(session.getAttribute("id")==null) {
				model.addAttribute("first", true);
				session.setAttribute("id", 1);
			}
			int id=(int)session.getAttribute("id");		
			ExamQuiz eq=questions.get(id-1);
			System.out.println(eq);
			//model.addAttribute("ex", eq);
			if(eq==null) {			
				session.invalidate();
				return "redirect:/";
			}else {
				model.addAttribute("ex", eq);
				return "examquiz";
			}
		}
		return "redirect:/";
	}
	
	@PostMapping("/Start")
	public String examclick(Model model,String next,String prev,String finish,ExamQuiz eq,RedirectAttributes ra) {
		if(session.getAttribute("id")!=null) {
		String userid=((User)session.getAttribute("user")).getUserid();
		model.addAttribute("first", false);
		int qid=(int)session.getAttribute("id");
		if(next!=null) {
			qid++;
			session.setAttribute("id", qid);
		}else if(prev!=null) {
			qid--;
			session.setAttribute("id", qid);
		}else {
			eservice.updateExamQuiz(eq);
			eservice.submitExam(userid);
			ra.addFlashAttribute("msg", "Exam submitted successfully..!!");
			session.removeAttribute("id");
			return "redirect:/myreport";
		}
		eservice.updateExamQuiz(eq);
		
		List<ExamQuiz> questions=eservice.getQuestions(userid);
		ExamQuiz exq=questions.get(qid-1);
		System.out.println(exq);
		model.addAttribute("ex", exq);
		return "examquiz";
		}
		return "redirect:/";
	}
	
	@GetMapping("/myreport")
	public String examreport(Model model) {
		if(session.getAttribute("user")!=null) {
		String userid=((User)session.getAttribute("user")).getUserid();
		model.addAttribute("user", uservice.findByUserid(userid));
		model.addAttribute("correct", eservice.correctCount(userid));
		model.addAttribute("incorrect", eservice.incorrectCount(userid));
		model.addAttribute("list", eservice.getQuestions(userid));
		return "myreport";
		}else {
			return "redirect:/";
		}
	}
}
