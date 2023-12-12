package br.com.AprenderMais.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	@Column(nullable = false, length = 80)
	private String email;
	@Column(nullable = false, length = 16)
	private String password;
	@Column(nullable = false, length = 100)
	@Size(min = 3, max = 100, message = "Usuário não pode conter menos de 3 caracteres")
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

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}
	
	
	
	
	

}
