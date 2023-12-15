package br.com.AprenderMais.data.dto;

import jakarta.validation.constraints.NotBlank;

public class ClassroomRequestDTO {

    @NotBlank
    private String name;
    
    @NotBlank
    private String description;

    @NotBlank
    private String areaClassroom;
    
    @NotBlank
    private String url;

}