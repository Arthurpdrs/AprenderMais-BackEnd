package br.com.AprenderMais.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AprenderMais.data.dto.ClassroomDTO;
import br.com.AprenderMais.exceptions.ResourceNotFoundException;
import br.com.AprenderMais.mapper.DozerMapperConvert;
import br.com.AprenderMais.model.Classroom;
import br.com.AprenderMais.repositories.ClassroomRepository;

@Service
public class ClassroomService {

	private Logger logger = Logger.getLogger(ClassroomService.class.getName());
	
	@Autowired
	ClassroomRepository courseRepository;
	
	public List<ClassroomDTO> findAll(){
		
		logger.info("Finding all users!");
		
		return DozerMapperConvert.parseListObjects(courseRepository.findAll(), ClassroomDTO.class);
	}
	
	public ClassroomDTO findById(Long id) {
		logger.info("Finding one user!");
		
		var entity = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapperConvert.parseObject(entity, ClassroomDTO.class);
	}
	
	public ClassroomDTO create(ClassroomDTO course) {
		logger.info("Creating one user!");
		

		var entity = DozerMapperConvert.parseObject(course, Classroom.class);
		var dto = DozerMapperConvert.parseObject(courseRepository.save(entity), ClassroomDTO.class);
		
		return dto;
	}
	
	public ClassroomDTO update(ClassroomDTO classroom) {
		
		logger.info("Updating one user");
			
		var entity = courseRepository.findById(classroom.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setAreaClassroom(classroom.getAreaClassroom());
		entity.setDescription(classroom.getDescription());
		entity.setName(classroom.getName());
		entity.setUrl(classroom.getUrl());
		
		var dto = DozerMapperConvert.parseObject(courseRepository.save(entity), ClassroomDTO.class);
		return dto;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one user");
		
		var entity = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		courseRepository.delete(entity);
	}
}
