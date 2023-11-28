package br.com.AprenderMais.data.dto;

import java.io.Serializable;

import br.com.AprenderMais.model.Admin;
import br.com.AprenderMais.model.Professor;
import br.com.AprenderMais.model.Student;
import br.com.AprenderMais.model.User;
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
	
	public UserDTO(User user) {
		
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.name = user.getName();
		this.telephone = user.getTelephone();
		
		switch (userType) {
        case STUDENT:
        	this.userType = user.getUserType();
            this.student = new Student();
            break;
        case PROFESSOR:
        	this.userType = user.getUserType();
            this.professor = new Professor();
            this.student = new Student();
            break;
        case ADMIN:
        	this.userType = user.getUserType();
            this.admin = new Admin();
            break;
		}
	}
	
	public UserDTO() {}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	

}
