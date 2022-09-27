package com.ms.react.demos.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.react.demos.domain.Course;
import com.ms.react.demos.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    private CourseDao courseDao;
    //private String jsonSource = "{\"title\":\"new book\"}";
    public void parse() {
        courseDao.saveAll(getJson("classpath:MOCK_DATA.json"));
    }


    public List<Course> getJson(String path) {
        List<Course> courses=new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(path);
            String content = new String(Files.readAllBytes(file.toPath()));
            ObjectMapper g = new ObjectMapper();
            courses=g.readValue(content, new TypeReference<List<Course>>(){});
        }catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

}
