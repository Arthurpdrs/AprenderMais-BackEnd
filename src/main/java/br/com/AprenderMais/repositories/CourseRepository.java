package br.com.AprenderMais.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.AprenderMais.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
