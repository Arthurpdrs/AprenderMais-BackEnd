package br.com.AprenderMais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.AprenderMais.data.dto.AuthenticationDTO;
import br.com.AprenderMais.data.dto.RegisterDTO;
import br.com.AprenderMais.data.dto.UserDTO;
import br.com.AprenderMais.exceptions.RequiredObjectIsNullException;
import br.com.AprenderMais.mapper.DozerMapperConvert;
import br.com.AprenderMais.model.User;
import br.com.AprenderMais.repositories.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.userName(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/register")
	public UserDTO register(@RequestBody @Valid RegisterDTO data) {
		if(this.repository.findByName(data.name()) != null) return null;
	
		//String encryptoPassword = new BCryptPasswordEncoder().encode(data.password());
		UserDTO newUser = new UserDTO(data.name(), data.password(), data.role());

		var entity = DozerMapperConvert.parseObject(newUser, User.class);
		var dto = DozerMapperConvert.parseObject(repository.save(entity), UserDTO.class);

		return dto;
	}

}
