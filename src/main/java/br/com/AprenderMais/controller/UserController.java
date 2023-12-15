package br.com.AprenderMais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.AprenderMais.data.dto.ProfessorDTO;
import br.com.AprenderMais.data.dto.UserDTO;
import br.com.AprenderMais.services.ProfessorService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessorDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessorDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessorDTO create(@RequestBody ProfessorDTO user) {
		return service.create(user);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessorDTO update(@RequestBody ProfessorDTO user) {
		return service.update(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
    
}
