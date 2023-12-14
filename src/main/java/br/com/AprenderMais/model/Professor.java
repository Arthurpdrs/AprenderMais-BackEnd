package br.com.AprenderMais.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long ID;
    public static Professor professor;
    @Column(nullable = false, length =50)
    private String occupationArea;
    @Column(nullable = false, length = 80)
    private String formationDegree;
    @Column(nullable = false, length = 500)
    private String biography;

    
    public Professor(String occupationArea, String formationDegree, String biography) {
        this.occupationArea = occupationArea;
        this.formationDegree = formationDegree;
        this.biography = biography;
    }

    public Professor() {
    }

    // Getters e Setters
    public String getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(String occupationArea) {
        this.occupationArea = occupationArea;
    }

    public String getFormationDegree() {
        return formationDegree;
    }

    public void setFormationDegree(String formationDegree) {
        this.formationDegree = formationDegree;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
