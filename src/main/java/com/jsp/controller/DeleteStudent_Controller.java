package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.StudentService;
@WebServlet("/DeleteStd")
public class DeleteStudent_Controller extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s_id = req.getParameter("id");
	int id = Integer.parseInt(s_id);
	
	StudentService studentService = new StudentService();
	studentService.delete(id);
	
	PrintWriter printWriter = resp.getWriter();
	printWriter.print("<html><head><body><h1>Student record is Deleted</h1></body></head></html");
	}
}
