package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karuna");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	
//	Save Student
	public Student saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	
//	record get by id
	public Student getById(int id) {
		 return entityManager.find(Student.class,id);
		
	}
//	update Record
	public Student updateStudentbyId(Student student) {
		if(student!=null) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
		else {
			return null;
		}
		}
//	Get All Student
	
	public List<Student> getAllStudents(){
		String sql= "select s from Student s";
		 Query query= entityManager.createQuery(sql);
	List<Student> students= query.getResultList();
	return students;
	}
//	Delete Record
	public Student deleteStudent(Student student) {
		if(student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return student;
			
		}
		else {
			return null;
		}
	}
	
	
}
