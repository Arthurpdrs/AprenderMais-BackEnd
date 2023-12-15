package br.com.AprenderMais.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AprenderMais.data.dto.ProfessorDTO;
import br.com.AprenderMais.data.dto.UserDTO;
import br.com.AprenderMais.exceptions.ResourceNotFoundException;
import br.com.AprenderMais.mapper.DozerMapperConvert;
import br.com.AprenderMais.model.Professor;
import br.com.AprenderMais.repositories.ProfessorRepository;
import br.com.AprenderMais.repositories.UserRepository;

@Service
public class ProfessorService {
	
	private Logger logger = Logger.getLogger(ProfessorService.class.getName());
	
	@Autowired
	ProfessorRepository professorRepository;
	
	public List<ProfessorDTO> findAll(){
		
		logger.info("Finding all users!");
		
		return DozerMapperConvert.parseListObjects(professorRepository.findAll(), ProfessorDTO.class);
	}
	
	public ProfessorDTO findById(Long id) {
		logger.info("Finding one user!");
		
		var entity = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapperConvert.parseObject(entity, ProfessorDTO.class);
	}
	
	public ProfessorDTO create(ProfessorDTO professor) {
		logger.info("Creating one user!");
		
		var entity = DozerMapperConvert.parseObject(professor, Professor.class);
		var dto = DozerMapperConvert.parseObject(professorRepository.save(entity), ProfessorDTO.class);
		
		return dto;
	}
	
	public ProfessorDTO update(ProfessorDTO professor) {
		
		logger.info("Updating one user");
			
		var entity = professorRepository.findById(professor.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setOccupationArea(professor.getOccupationArea());
		entity.setFormationDegree(professor.getFormationDegree());
		entity.setBiography(professor.getBiography());
		
		var dto = DozerMapperConvert.parseObject(professorRepository.save(entity), ProfessorDTO.class);
		return dto;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one user");
		
		var entity = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		professorRepository.delete(entity);
	}
}
