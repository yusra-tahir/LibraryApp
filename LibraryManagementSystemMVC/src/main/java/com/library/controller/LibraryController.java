package com.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.Employee;
import com.library.service.EmployeeLibraryService;

@Controller
public class LibraryController {

	@Autowired
	private EmployeeLibraryService employeeLibraryService;

	// **** LANDING CONTROLLER **** //

	@RequestMapping("/")
	public ModelAndView welcomePageController() {
		return new ModelAndView("Homepage");
	}

	// **** LOGIN CONTROLLER **** //

	@RequestMapping("/loginPage")
	public ModelAndView loginPageController() {
		return new ModelAndView("loginPage", "employee", new Employee());
	}

	@RequestMapping("/login")
	public ModelAndView loginController(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		Employee emp = employeeLibraryService.login(email, password);

		if (emp != null) {
			modelAndView.addObject("employee", emp);
			session.setAttribute("employee", emp);
			modelAndView.setViewName("Dashboard");

		} else {
			modelAndView.addObject("message", "Incorrect Email/Password, Try Again!");
			modelAndView.addObject("employee", new Employee());
			modelAndView.setViewName("LoginPage");
		}

		return modelAndView;
	}

}
