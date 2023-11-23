package br.com.AprenderMais.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AprenderMais.data.dto.StudentDTO;
import br.com.AprenderMais.exceptions.ResourceNotFoundException;
import br.com.AprenderMais.mapper.DozerMapperConvert;
import br.com.AprenderMais.model.Student;
import br.com.AprenderMais.repositories.StudentRepository;

@Service
public class StudentService {
	
	private Logger logger = Logger.getLogger(StudentService.class.getName());
	
	@Autowired
	StudentRepository repositoryStudent;
	
	public List<StudentDTO> findAllStudents(){
		
		logger.info("Finding all students!");
		
		return DozerMapperConvert.parseListObjects(repositoryStudent.findAll(), StudentDTO.class);
	}
	
	public StudentDTO findByIdStudent(Long id) {
		logger.info("Finding one student!");
		
		var entity = repositoryStudent.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapperConvert.parseObject(entity, StudentDTO.class);
	}
	
	public StudentDTO createStudent(StudentDTO student) {
		logger.info("Creating one student!");
		
		var entity = DozerMapperConvert.parseObject(student, Student.class);
		var dto = DozerMapperConvert.parseObject(repositoryStudent.save(entity), StudentDTO.class);
		
		return dto;
	}
	
	public StudentDTO updateStudent(StudentDTO student) {
		
		logger.info("Updating one student");
			
		var entity = repositoryStudent.findById(student.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(student.getFirstName());
		entity.setLastName(student.getLastName());
		entity.setGender(student.getGender());
		
		var dto = DozerMapperConvert.parseObject(repositoryStudent.save(entity), StudentDTO.class);
		return dto;
	}
	
	public void deleteStudent(Long id) {
		logger.info("Deleting one student");
		
		var entity = repositoryStudent.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repositoryStudent.delete(entity);
	}
}
