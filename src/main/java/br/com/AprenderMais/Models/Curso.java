package br.com.AprenderMais.Models;

import java.util.UUID;

public class Curso {
    private UUID idCurso;
    private String nomeCurso;
    private String dataEncerramento;
    private String descricaoCurso;
    private Professor professorResponsavel;
    private Boolean AutorizacaoCurso;
    private String areaCurso;
    private int alunosMatriculados;

    public UUID getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(UUID idCurso) {
        this.idCurso = idCurso;
    }
    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    public String getDataEncerramento() {
        return dataEncerramento;
    }
    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    public String getDescricaoCurso() {
        return descricaoCurso;
    }
    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }
    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }
    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }
    public Boolean getAutorizacaoCurso() {
        return AutorizacaoCurso;
    }
    public void setAutorizacaoCurso(Boolean autorizacaoCurso) {
        AutorizacaoCurso = autorizacaoCurso;
    }
    public String getAreaCurso() {
        return areaCurso;
    }
    public void setAreaCurso(String areaCurso) {
        this.areaCurso = areaCurso;
    }
    public int getAlunosMatriculados() {
        return alunosMatriculados;
    }
    public void setAlunosMatriculados(int alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}
