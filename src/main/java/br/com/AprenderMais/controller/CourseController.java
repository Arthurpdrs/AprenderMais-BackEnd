package br.com.AprenderMais.controller;

import br.com.AprenderMais.data.dto.CourseDTO;
import br.com.AprenderMais.model.Course;
import br.com.AprenderMais.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/course")
public class CourseController{

    @Autowired
    private CourseService courseService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> create(@RequestBody CourseDTO courseDTO){
        Course createdCourse = courseService.create(courseDTO);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }
}