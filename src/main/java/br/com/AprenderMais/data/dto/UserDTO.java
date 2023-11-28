package br.com.AprenderMais.data.dto;

import java.io.Serializable;

import br.com.AprenderMais.model.Admin;
import br.com.AprenderMais.model.Professor;
import br.com.AprenderMais.model.Student;
import br.com.AprenderMais.model.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


public class UserDTO implements Serializable{
	

	private Long id;
	private String email;
	private String password;
	private String name;
	private String telephone;
	private UserType userType;
	private Admin admin;
	private Professor professor;
	private Student student;
	
	public UserDTO(String email, String password, String name, String telephone, UserType userType) {
		
		this.email = email;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		
		switch (userType) {
        case STUDENT:
        	this.userType = userType;
            this.student = new Student();
            break;
        case PROFESSOR:
        	this.userType = userType;
            this.professor = new Professor();
            this.student = new Student();
            break;
        case ADMIN:
        	this.userType = userType;
            this.admin = new Admin();
            break;
		}
	}
	
	public UserDTO() {}	
	

}
