package br.com.AprenderMais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AprenderMais.model.User;

public interface UserRepository extends JpaRepository<User, Long>{}
