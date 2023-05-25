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
@WebServlet("/getById")
public class GetByIdController extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s_id = req.getParameter("id");
	int id = Integer.parseInt(s_id);
	
	StudentService studentService=new StudentService();
Student student=studentService.getById(id);

PrintWriter printWriter=resp.getWriter();
printWriter.print("<html><head><body><h3>ID:"+student.getId()+"</h3><>\n <h3>Name : "+student.getName()+"</h3>\n<h3>email: "+student.getEmail()+"</h3></body></head></html>");
}
}
