package br.com.AprenderMais.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 80)
	private String email;
	@Column(nullable = false, length = 16)
	private String password;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, length = 11)
	private String telephone;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;
	@Transient
	private Admin admin;
	@Transient
	private Professor professor;
	@Transient
	private Student student;
	
	
	public User(String email, String password, String name, String telephone, UserType userType) {
		
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
	
	public User() {}	
	

}
