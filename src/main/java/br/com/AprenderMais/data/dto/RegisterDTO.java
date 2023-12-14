package br.com.AprenderMais.data.dto;

import br.com.AprenderMais.model.UserType;

public record RegisterDTO(String name, String password, UserType role) {

}