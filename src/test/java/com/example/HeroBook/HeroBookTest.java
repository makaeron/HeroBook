package com.example.HeroBook;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class HeroBookTest {
    //When I view all the heros
    //Then I can see names of all heros
    @Autowired
    MockMvc mockmvc;

    @Test
    public void postHerosTest() throws Exception {
        HeroDto heroDto = new HeroDto("img","Clark","superman",6.1,180,"heat vision",160,250,"Flight",200,20,"Man of steel","alien from destroyed planet");
        ObjectMapper objectMapper = new ObjectMapper();
     mockmvc.perform(post("/hero")
             .content(objectMapper.writeValueAsString(heroDto))
             .contentType(MediaType.APPLICATION_JSON)
     ).andExpect(status().isOk())
     .andExpect(jsonPath("name").value("Clark"));
    }

    @Test
    public void getHeroTest() throws Exception {
        // Call controller
        // that will call service
        HeroDto heroDto = new HeroDto("img","Bruce","batman",6.2,180,"money",160,100,"gadgets",10,15,"Dark Knight","lost parents in an alley way");
        ObjectMapper objectMapper = new ObjectMapper();
        // Service will call database
        // Will return the get
        mockmvc.perform(post("/hero")
                .content(objectMapper.writeValueAsString(heroDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Bruce"));
        mockmvc.perform(get("/hero")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].name").value("Clark"));
    }
}
