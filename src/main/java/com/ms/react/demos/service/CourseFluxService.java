package com.ms.react.demos.service;

import com.ms.react.demos.domain.Course;
import com.ms.react.demos.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CourseFluxService  implements CourseService{
    @Autowired
    private CourseDao courseDao;

    @Override
    public Flux<Course> getAllCourse() {
        return courseDao.findAll();
    }
}
