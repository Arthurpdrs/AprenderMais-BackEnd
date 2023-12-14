package br.com.AprenderMais.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	    return httpSecurity
	            .csrf(csrf -> csrf.disable())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
	            		.requestMatchers(HttpMethod.POST, "api/auth/login").permitAll()
	            		.requestMatchers(HttpMethod.POST, "api/auth/register").permitAll()
	                    .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN") //Permite que usuários com a função "ADMIN" façam requisições POST em todos os endpoints sob "/api/".
	                    .requestMatchers(HttpMethod.POST, "/api/course").hasRole("PROFESSOR") // Permite que usuários com a função "PROFESSOR" adicionem cursos
	                    .requestMatchers(HttpMethod.DELETE, "/api/course").hasRole("PROFESSOR") // Permite que usuários com a função "PROFESSOR" removam cursos.
	                    .requestMatchers(HttpMethod.DELETE, "/api/course/student").hasRole("PROFESSOR") // Permite que usuários com a função "PROFESSOR" removam estudantes de seus cursos.
	                    .requestMatchers(HttpMethod.GET, "/api/course/students").hasRole("PROFESSOR") // Permite que usuários com a função "PROFESSOR" busquem alunos matriculados nos seus cursos.
	                    .requestMatchers(HttpMethod.POST, "/api/course/enroll").hasRole("STUDENT") // Permite que usuários com a função "STUDENT" entrem em cursos.
	                    .requestMatchers(HttpMethod.GET, "/api/courses").hasRole("STUDENT") // Permite que usuários com a função "STUDENT" busquem cursos.
	                    .requestMatchers(HttpMethod.GET, "/api/professors").hasRole("STUDENT") // Permite que usuários com a função "STUDENT" busquem professores.
	            )
	            .build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}