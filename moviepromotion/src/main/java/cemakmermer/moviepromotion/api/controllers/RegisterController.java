package cemakmermer.moviepromotion.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cemakmermer.moviepromotion.dataAccess.abstrack.UserDao;
import cemakmermer.moviepromotion.entity.concrate.User;

@Controller
public class RegisterController 

{
	@Autowired
	private UserDao userDao;
	@GetMapping("/register")
	public String showSingUpForm(Model model){
		model.addAttribute("user",new User());
		return "signup_form";
	
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPassword= encoder.encode(user.getPassword());
		user.setPassword(encoderPassword);
		userDao.save(user);
		return "register_success";
	}
}
