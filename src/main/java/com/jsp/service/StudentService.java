
package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student getById(int id) {
		return studentDao.getById(id);
	}

	public Student updateStudentbyId(Student student, int id) {
		Student student2 = studentDao.getById(id);

		if (student.getName() != null) {
			student2.setName(student.getName());
		}
		if (student.getEmail() != null) {
			student2.setEmail(student.getEmail());
		}
		if (student2 != null) {
			return studentDao.updateStudentbyId(student2);
		} else
			return null;

	}

//	get All Students
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

//	Delete Student
	public Student delete(int id) {
		Student student = studentDao.getById(id);

		if (student != null) {
			return studentDao.deleteStudent(student);
		}
		return null;
	}
}