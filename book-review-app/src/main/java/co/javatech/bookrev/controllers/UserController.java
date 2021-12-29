package co.javatech.bookrev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.javatech.bookrev.entity.User;
import co.javatech.bookrev.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String viewRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<User> listUsers = userRepo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}	
	
}
