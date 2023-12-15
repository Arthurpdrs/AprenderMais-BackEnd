package br.com.AprenderMais.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.AprenderMais.data.dto.AuthenticationDTO;
import br.com.AprenderMais.data.dto.LoginResponseDTO;
import br.com.AprenderMais.data.dto.UserCreateDTO;
import br.com.AprenderMais.infra.security.TokenService;
import br.com.AprenderMais.model.User;
import br.com.AprenderMais.model.UserType;
import br.com.AprenderMais.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.name(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((User) auth.getPrincipal());


		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreateDTO data) {
        Optional<User> isAlreadyCreated = userRepository.findByNameUser(data.getName());
        if(isAlreadyCreated.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("");
        }else{
			UserType userType = UserType.fromString(data.getRole());
            String encryptoPassword = new BCryptPasswordEncoder().encode(data.getPassword());
            User newUser = new User(data.getName(),encryptoPassword,userType);
            userRepository.save(newUser);
		
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
	}
}

