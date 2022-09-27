package com.ms.react.demos.service;

import com.ms.react.demos.domain.Course;
import reactor.core.publisher.Flux;

public interface CourseService {
    Flux<Course> getAllCourse();
}
