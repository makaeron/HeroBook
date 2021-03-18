package com.example.HeroBook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ViliansBookTest {

    @Autowired
    MockMvc mockMvc;
    //When I view all the villains
    //Then I can see names of all villains

    @Test
    public void postVillainsTest() throws Exception {
        //Setup
        //Villain
        VillainDto villainDto = new VillainDto("Joker");
        VillainDto villainDto1 = new VillainDto("Chittah");
        VillainDto villainDto2 = new VillainDto("Alexter");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villainDto))
        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(jsonPath("name").value("Joker"));

        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villainDto1))
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
            .andExpect(jsonPath("name").value("Chittah"));

        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villainDto2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Alexter"));
        }

        @Test
    public void getVillainTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(get("/villains")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
            .andExpect(jsonPath("[0].name").value("Joker"));
        }


}
