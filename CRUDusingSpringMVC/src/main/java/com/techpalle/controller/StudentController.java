package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.DataAccessObject;
import com.techpalle.model.Admin;
import com.techpalle.model.Student;

@Controller
public class StudentController {
	
	@RequestMapping("login")
    public ModelAndView getLogin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPwd");
		Admin a1 = new Admin(e,p);
		boolean flag = DataAccessObject.login(a1);
		if(flag == true) {
			mv.setViewName("admin.jsp");
			return mv;
		}
		else {
			mv.addObject("invalid","invalid credential");
			mv.setViewName("index.jsp");
			return mv;
		}
		
	}
	@RequestMapping(value="crud",params="reg")
	public ModelAndView getToRegistration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		return mv;
		
	}
	
	@RequestMapping("reg")
	public ModelAndView doRegister(HttpServletRequest request) {
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPwd");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		
		Student s = new Student(n,e,p,m);
		
		//JDBC connection
		DataAccessObject.insert(s);
		ModelAndView mv = new ModelAndView();
		mv.addObject("res","student details addedd successfully");
		mv.setViewName("register.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="crud",params="show")
	public ModelAndView getAllStudDetails() {
		ArrayList<Student> al = DataAccessObject.getAllStudentDetails(); 
		ModelAndView mv = new ModelAndView();
		mv.addObject("stud",al);
		mv.setViewName("display.jsp");
		
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView displayEditForm(int id) {
		ModelAndView mv = new ModelAndView();
		//retrieve the data from db
		Student s = DataAccessObject.getStudentById(id);
		//then redirect user to edit form(registration page)
		mv.addObject("student",s);
		mv.setViewName("register.jsp");
		
		return mv;
		
	}
	
	@RequestMapping("update")
	public ModelAndView updateUser(HttpServletRequest request) {
		//read new values
		int i = Integer.parseInt(request.getParameter("tbId"));
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPwd");
        long m = Long.parseLong(request.getParameter("tbMobile"));
        
        Student s = new Student(i,n,e,p,m);
		//update value in db
        DataAccessObject.update(s);
		//redirect user to display.jsp with updated values
        // here we need to call getAllStudDetails() method bcz we need to display updated values not only just redirecting
        ArrayList<Student> al = DataAccessObject.getAllStudentDetails(); 
		ModelAndView mv = new ModelAndView();
		mv.addObject("stud",al);
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteStudentUsingID(int id) {
		ModelAndView mv = new ModelAndView();
		DataAccessObject.deleteStudent(id);
		ArrayList<Student> al = DataAccessObject.getAllStudentDetails(); 
		mv.addObject("stud",al);
		mv.setViewName("display.jsp");
		
		return mv;
	}
}
