package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

@WebServlet("/save")
public class SaveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		Student student = new Student();
		student.setName(name);
		student.setEmail(email);

		StudentService studentService = new StudentService();
		Student s2 = studentService.saveStudent(student);

		PrintWriter printWriter = resp.getWriter();
		printWriter
				.write("<html><body><h1>" + "Student " + s2.getName() + " Added successfully" + "</h1> </body></html>");
	}
}
