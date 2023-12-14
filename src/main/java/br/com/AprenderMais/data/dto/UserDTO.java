package br.com.AprenderMais.data.dto;

import java.io.Serializable;

import br.com.AprenderMais.model.Admin;
import br.com.AprenderMais.model.Professor;
import br.com.AprenderMais.model.Student;
import br.com.AprenderMais.model.User;
import br.com.AprenderMais.model.UserType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserDTO implements Serializable{
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private String telephone;
	private UserType role;	

	public UserDTO(String name, String password, UserType role){
		this.name = name;
		this.password = password;
		this.role = role;
	}
}
