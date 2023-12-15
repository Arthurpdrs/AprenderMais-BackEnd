package br.com.AprenderMais.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDTO {

    private String name;

    private String password;

    private String role;

    public UserCreateDTO(String name, String password, String role){
        this.name = name;
        this.password = password;
        this.role = role;
    }
    
}
