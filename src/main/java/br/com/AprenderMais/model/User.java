package br.com.AprenderMais.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "user")
public class User implements Serializable, UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100, unique = true)
	@Size(min = 2, max = 100, message = "Usuário não pode conter menos de 3 caracteres")
	private String name;

	// @Email
	// @Column(nullable = false, length = 80)
	// private String email;

	@Column(nullable = false, length = 200)
	private String password;

	// @Column(nullable = false, length = 11)
	// private String telephone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserType role;

	public User(String name, String password, UserType role){
		this.name = name;
		this.password = password;
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserType.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_PROFESSOR"), new SimpleGrantedAuthority("ROLE_STUDENT"));
        else if(this.role == UserType.PROFESSOR) return List.of(new SimpleGrantedAuthority("ROLE_PROFESSOR"), new SimpleGrantedAuthority("ROLE_STUDENT"));
        else return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
    public String getPassword() {
        return this.password;
    }

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
}
