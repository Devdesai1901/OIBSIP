package com.onlineexam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineexam.models.Login;
import com.onlineexam.models.User;
import com.onlineexam.services.SubjectService;
import com.onlineexam.services.UserService;

@Controller
public class HomeController {
	
	@Autowired UserService uservice;
	@Autowired SubjectService sservice;
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/")
	public String validate(Login login,RedirectAttributes ra) {
		session.invalidate();
		User user=uservice.validateUser(login);
		if(user==null) {
			ra.addFlashAttribute("error", "Invalid username or password..!!");
			return "redirect:/";
		}
		else {
			session.setAttribute("user", user);
			if(user.getRole().equals("Admin"))
				return "redirect:/dashboard";
			else {
				return "redirect:/instructions";
			}
		}
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("list", sservice.allSubjects());
		return "register";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
