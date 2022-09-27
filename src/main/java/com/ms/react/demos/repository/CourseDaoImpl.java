package com.ms.react.demos.repository;

import com.ms.react.demos.domain.Course;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class CourseDaoImpl implements CourseDao{

    private List<Course> courses=new ArrayList<>();

    @Override
    public void saveAll(List<Course> courses) {
        this.courses.addAll(courses);
    }


    @Override
    public Flux<Course> findAll(){
         return Flux.fromIterable(courses);
    }

    @Override
    public Mono<Course> findById(UUID id) {
        return null;
    }

    @Override
    public Flux<Course> findByTitleContains() {
        return null;
    }
}
