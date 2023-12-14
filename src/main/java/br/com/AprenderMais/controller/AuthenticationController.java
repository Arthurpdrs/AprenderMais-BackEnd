package br.com.AprenderMais.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.AprenderMais.data.dto.AuthenticationDTO;
import br.com.AprenderMais.data.dto.RegisterDTO;
import br.com.AprenderMais.data.dto.UserCreateDTO;
import br.com.AprenderMais.data.dto.UserDTO;
import br.com.AprenderMais.exceptions.RequiredObjectIsNullException;
import br.com.AprenderMais.mapper.DozerMapperConvert;
import br.com.AprenderMais.model.User;
import br.com.AprenderMais.model.UserType;
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
	public ResponseEntity login(@RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.userName(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreateDTO data) {
		 System.out.println("Dados recebidos: " + data.getName() + "- "+ data.getPassword() +"- "+ data.getRole());
        Optional<User> isAlreadyCreated = repository.findByNameUser(data.getName());
        if(isAlreadyCreated.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("");
        }else{
			UserType userType = UserType.fromString(data.getRole());
            String encryptoPassword = new BCryptPasswordEncoder().encode(data.getPassword());
            User newUser = new User(data.getName(),encryptoPassword,userType);
            repository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
	}
}
