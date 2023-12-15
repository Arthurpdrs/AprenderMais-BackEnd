package br.com.AprenderMais.data.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClassroomDTO {
    
    private Long id;

    private String name;
    
    private String description;
    
    private String areaClassroom;

    private String url;

}
