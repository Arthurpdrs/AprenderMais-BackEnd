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

import br.com.AprenderMais.data.dto.ClassroomDTO;
import br.com.AprenderMais.services.ClassroomService;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {
	
	@Autowired
	private ClassroomService service;
	
	@GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<ClassroomDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClassroomDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClassroomDTO create(@RequestBody ClassroomDTO user) {
		return service.create(user);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClassroomDTO update(@RequestBody ClassroomDTO user) {
		return service.update(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}  
}
