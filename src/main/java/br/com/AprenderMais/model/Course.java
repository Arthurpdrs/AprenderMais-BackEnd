package br.com.AprenderMais.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID courseId;
    private String courseName;
    private String endingDate;
    private String description;
    private Professor professor;
    private Boolean AutorizacaoCurso; //verificar se deve ser um atributo ou um método - By Arthur on 02/11/2023
    private String areaCurso; // entender melhor qual a função disso - By Arthur on 02/11/2023
    private List<Student> registeredStudents;



    public Course(String courseName, String endingDate, String description, Professor professor, String areaCurso) {
        this.courseId = UUID.randomUUID();
        this.courseName = courseName;
        this.endingDate = endingDate;
        this.description = description;
        this.professor = professor;
        this.areaCurso = areaCurso;
        this.registeredStudents = new ArrayList<>();
    }

    public UUID getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(){
        this.courseName = courseName;
    }

    public String getEndingDate(){
        return this.endingDate;
    }
    public void setEndintDate(){
        this.endingDate = endingDate;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(){
        this.description = description;
    }
    public Professor getProfessor(){
        return Professor.professor;
    }
    public void setProfessor(){
        Professor.professor = professor;
    }
     public String getAreaCurso() {
        return areaCurso;
    }
    public void setAreaCurso(){
        this.areaCurso = areaCurso;
    }

}
