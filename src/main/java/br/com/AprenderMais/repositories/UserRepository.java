package br.com.AprenderMais.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.AprenderMais.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByName(String name);


    @Query(value="SELECT * FROM user WHERE name = ?1", nativeQuery = true)
    Optional<User> findByNameUser(String name);
}
