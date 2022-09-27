package com.ms.react.demos.repository;

import com.ms.react.demos.domain.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CourseDao {

    void saveAll(List<Course> courses);

    Flux<Course> findAll();
    Mono<Course> findById(UUID id);
    Flux<Course> findByTitleContains();
}
