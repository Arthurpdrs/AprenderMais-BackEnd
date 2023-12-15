package br.com.AprenderMais.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.AprenderMais.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    
}
