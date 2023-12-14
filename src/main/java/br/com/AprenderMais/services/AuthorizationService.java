package br.com.AprenderMais.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.AprenderMais.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

   private Logger logger = Logger.getLogger(AuthorizationService.class.getName());

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name " + username + "!" );
        return repository.findByName(username);
    }
}
