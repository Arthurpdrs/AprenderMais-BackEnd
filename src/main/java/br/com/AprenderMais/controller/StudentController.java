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

import br.com.AprenderMais.data.dto.StudentDTO;
import br.com.AprenderMais.services.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDTO> findAllStudents(){
		return service.findAllStudents();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDTO findByIdStudent(@PathVariable(value = "id") Long id) {
		return service.findByIdStudent(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDTO createStudent(@RequestBody StudentDTO student) {
		return service.createStudent(student);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDTO updateStudent(@RequestBody StudentDTO student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}
}
