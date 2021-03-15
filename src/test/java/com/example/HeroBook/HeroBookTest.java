package com.example.HeroBook;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeroBookTest {
    //When I view all the heros
    //Then I can see names of all heros
    @Autowired
    MockMvc mockmvc;

    @Test
    public void postHerosTest() throws Exception {
        HeroDto heroDto = new HeroDto("Tim");
        ObjectMapper objectMapper = new ObjectMapper();
     mockmvc.perform(post("/hero")
             .content(objectMapper.writeValueAsString(heroDto))
             .contentType(MediaType.APPLICATION_JSON)
     ).andExpect(status().isOk());
    }
}
