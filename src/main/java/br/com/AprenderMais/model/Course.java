package br.com.AprenderMais.model;

import java.util.List;
import java.util.UUID;

public class Course {
    
	private UUID courseId;
    private String courseName;
    private String endingDate;
    private String description;
    private Professor professor;
    private Boolean AutorizacaoCurso; //verificar se deve ser um atributo ou um método - By Arthur on 02/11/2023
    private String areaCurso; // entender melhor qual a função disso - By Arthur on 02/11/2023
    private List<Student> registeredStudents;

    
}
