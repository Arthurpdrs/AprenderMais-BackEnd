package br.com.AprenderMais.services;

import br.com.AprenderMais.data.dto.CourseDTO;
import br.com.AprenderMais.model.Course;
import br.com.AprenderMais.model.Professor;
import br.com.AprenderMais.repositories.CourseRepository;
import br.com.AprenderMais.repositories.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseService{

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CourseRepository CourseRepository;

    public Course create(CourseDTO courseDTO){
        Professor professor = professorRepository.findById(courseDTO.getProfessorId()).orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));

        Course newCourse = new Course(
            courseDTO.getCourseName(),
            courseDTO.getEndingDate(),
            courseDTO.getDescription(),
            professor,
            courseDTO.getAreaCurso()
        );
        

       return CourseRepository.save(newCourse);
    }
}