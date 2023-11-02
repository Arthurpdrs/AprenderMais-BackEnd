package br.com.AprenderMais.model;


public class User {
	
	private String email;
	private String password;
	private String name;
	private String telephone;
	private Admin admin;
	private Professor professor;
	private Student student;
	
	
	public User(String email, String password, String name, String telephone, UserType userType) {
		
		this.email = email;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		
		switch (userType) {
        case STUDENT:
            this.student = new Student();
            break;
        case PROFESSOR:
            this.professor = new Professor();
            this.student = new Student();
            break;
        case ADMIN:
            this.admin = new Admin();
            break;
		}
	}
	
	public User() {}	
	

}
