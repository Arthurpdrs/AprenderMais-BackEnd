package br.com.AprenderMais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.AprenderMais.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByName(String name);
}
