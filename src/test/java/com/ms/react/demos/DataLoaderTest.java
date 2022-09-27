package com.ms.react.demos;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.react.demos.domain.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;


import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class DataLoaderTest {


    //private String jsonSource = "{\"title\":\"new book\"}";

    @Test
    public void parse() throws IOException {
        getJson("classpath:MOCK_DATA.json");
        //assertEquals(node.get("title").asText(), "new book");
    }


    public void fromJson() throws IOException {
        /*JsonNode node = DataLoader.parse(jsonSource);
        Fruit pojo = DataLoader.fromJason(node, Fruit.class);
        System.out.println("Pojo title " + pojo.title);*/
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

