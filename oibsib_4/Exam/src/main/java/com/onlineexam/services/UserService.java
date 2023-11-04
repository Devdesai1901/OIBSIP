package com.onlineexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.models.Login;
import com.onlineexam.models.User;
import com.onlineexam.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired private UserRepository repo;
	
	public void saveUser(User user) {
		user.setRole("User");
		repo.save(user);
	}
	
	public List<User> allUsers() {
		return repo.findByRole("User");
	}
	
	public User validateUser(Login login) {
		User user=findByUserid(login.getUserid());
		System.out.println(user);
		if(user!=null && user.getPwd().equals(login.getPwd()))
			return user;
		return  null;
	}
	
	public boolean checkAvailablity(String userid) {
		return findByUserid(userid)!=null;
	}
	
	public User findByUserid(String userid) {
		return repo.findById(userid).orElse(null);
	}
	
	
}
