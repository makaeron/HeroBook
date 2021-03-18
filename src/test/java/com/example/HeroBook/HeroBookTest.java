package com.example.HeroBook;



import com.example.HeroBook.models.HeroDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeroBookTest {
    //When I view all the heros
    //Then I can see names of all heros
    @Autowired
    MockMvc mockmvc;

    @Test
    @Order(1)
    public void postHerosTest() throws Exception {
        HeroDto heroDto = new HeroDto("img", "Clark", "superman", 6.1, 180, "heat vision", 160, 250, "Flight", 200, 20, "Man of steel", "alien from destroyed planet");
        ObjectMapper objectMapper = new ObjectMapper();
        mockmvc.perform(post("/hero")
                .content(objectMapper.writeValueAsString(heroDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Clark"))
                .andExpect(jsonPath("image").value("img"))
                .andExpect(jsonPath("heroName").value("superman"))
                .andExpect(jsonPath("height").value(6.1))
                .andExpect(jsonPath("weight").value(180))
                .andExpect(jsonPath("specialPower").value("heat vision"))
                .andExpect(jsonPath("intelligence").value(160))
                .andExpect(jsonPath("strength").value(250))
                .andExpect(jsonPath("power").value("Flight"))
                .andExpect(jsonPath("speed").value(200))
                .andExpect(jsonPath("agility").value(20))
                .andExpect(jsonPath("description").value("Man of steel"))
                .andExpect(jsonPath("story").value("alien from destroyed planet"));
    }

    @Test
    @Order(2)
    public void getHeroTest() throws Exception {
        // Call controller
        // that will call service
        HeroDto heroDto = new HeroDto("img", "Bruce", "batman", 6.2, 180, "money", 160, 100, "gadgets", 10, 15, "Dark Knight", "lost parents in an alley way");
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

    @Test
    @Order(3)
    public void getSpecificHeroDetails() throws Exception {
        mockmvc.perform(get("/hero/Clark")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Clark"));
    }

    @Test
    @Order(4)
    public void getInvalidSpecificHeroDetails() throws Exception {
        mockmvc.perform(get("/hero/Clark123")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string("Hero not found"));
    }

}
