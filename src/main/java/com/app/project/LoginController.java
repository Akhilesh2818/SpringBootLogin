package com.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	LoginDao repo;
	
	@RequestMapping("/")
	public String login() {
		System.out.println("In the add controller");	
		
		return "login";
		
	}
	@RequestMapping("/add")
	public String add(Login login) {
		System.out.println("In the add controller");	
		
		repo.save(login);
		return "login";
		
		
	}
	@RequestMapping("/get")
	public String get() {
		System.out.println("In the add controller");	
		
		return "display";
		
	}
	@RequestMapping("/displayDetails")
	public ModelAndView display(@RequestParam int age) {
		
		ModelAndView mv =new ModelAndView();
		Login login1=repo.findById(age).orElse(new Login());
	    System.out.println(login1.age+login1.name);
		mv.addObject("obj",login1);
		mv.setViewName("displayDetails");
		return mv;
		
	}

}
