package br.com.AprenderMais.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AprenderMais.data.dto.UserDTO;
import br.com.AprenderMais.exceptions.ResourceNotFoundException;
import br.com.AprenderMais.mapper.DozerMapperConvert;
import br.com.AprenderMais.model.User;
import br.com.AprenderMais.repositories.UserRepository;

@Service
public class UserService {
	
	private Logger logger = Logger.getLogger(UserService.class.getName());
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserDTO> findAll(){
		
		logger.info("Finding all users!");
		
		return DozerMapperConvert.parseListObjects(userRepository.findAll(), UserDTO.class);
	}
	
	public UserDTO findById(Long id) {
		logger.info("Finding one user!");
		
		var entity = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapperConvert.parseObject(entity, UserDTO.class);
	}
	
	public UserDTO create(UserDTO user) {
		logger.info("Creating one user!");
		
		var entity = DozerMapperConvert.parseObject(user, User.class);
		var dto = DozerMapperConvert.parseObject(userRepository.save(entity), UserDTO.class);
		
		return dto;
	}
	
	public UserDTO update(UserDTO user) {
		
		logger.info("Updating one user");
			
		var entity = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setName(user.getName());
		entity.setTelephone(user.getTelephone());
		//VERIFICAR A POSSIBLIDADE DE ALTERAR A SENHA AQUI.
		
		var dto = DozerMapperConvert.parseObject(userRepository.save(entity), UserDTO.class);
		return dto;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one user");
		
		var entity = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		userRepository.delete(entity);
	}
}
