package com.example.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.example.login.dao.LoginDao;
import com.example.login.dto.UserDto;

@Controller
public class LoginController {

	@Autowired
	LoginDao loginDao;
	
	@GetMapping("/signup")
	public String signuppage() {
		return "signup";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("signup_re")
	public String signup_re() {
		return "signup_re";
	}
	
	@GetMapping("login_fail")
	public String login_fail() {
		return "login_fail";
	}
	@PostMapping("/signup")
	public String signup(HttpServletRequest request)
	{
		UserDto userdto=new UserDto();
		userdto.setId(request.getParameter("id"));
		userdto.setPw(request.getParameter("pw"));
		
		if(loginDao.idCheck(userdto.getId()))
			return "redirect:/signup_re";
		else
			{
			loginDao.signUp(userdto.getId(), userdto.getPw());
			return "redirect:/login";
			}
	}
	
	@GetMapping("/login")
	public String loginpage(HttpSession session) {
		if(session.getAttribute("id")!=null)
			return "redirect:/login_fail";
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,HttpSession session)
	{
		
		if(loginDao.idCheck(request.getParameter("id")))
		{
			if(loginDao.pwCheck(request.getParameter("id")).equals(request.getParameter("pw")))
			{
				session.setAttribute("id", request.getParameter("id"));
				return "redirect:/main";
			}
			return "redirect:/login";
		}
		else
			{
			return "redirect:/login";
			}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session)throws IOException{
		session.invalidate();
		return "redirect:/login";
	}
	
}
