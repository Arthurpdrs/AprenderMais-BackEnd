package br.com.AprenderMais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AprenderMais.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
