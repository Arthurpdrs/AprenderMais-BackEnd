package br.com.AprenderMais.data.dto;

public class CourseDTO {

    private String courseName;
    private String endingDate;
    private String description;
    private Long professorId;
    private String areaCurso;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEndingDate(){
        return this.endingDate;
    }
    public void setEndingDate(){
        this.endingDate = endingDate;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(){
        this.description = description;
    }
    public Long getProfessorId(){
        return this.professorId;
    }
    public String getAreaCurso(){
        return this.areaCurso;
    }
    public void setAreaCurso(){
        this.areaCurso = areaCurso;
    }
}
