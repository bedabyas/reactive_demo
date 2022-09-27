package com.ms.react.demos.controller;

import com.ms.react.demos.domain.Course;
import com.ms.react.demos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "api/courses",produces = MediaType.TEXT_EVENT_STREAM_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping()
    public Flux<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping(path="/hi" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(){
        return "Hello";
    }

}
