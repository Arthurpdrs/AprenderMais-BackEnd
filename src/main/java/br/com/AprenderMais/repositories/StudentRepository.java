package br.com.AprenderMais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.AprenderMais.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
