package com.example.HeroBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @InjectMocks
    HeroService heroService;
    @Mock
    HeroRepository heroRepository;

    @Test
    public void postHeroServiceTest() {
        //object being passed
        HeroDto heroDto = new HeroDto("img", "Clark", "superman", 6.1, 180, "heat vision", 160, 250, "Flight", 200, 20, "Man of steel", "alien from destroyed planet");
        HeroEntity heroEntity = new HeroEntity(heroDto.getImage(), heroDto.getName(), heroDto.getHeroName(), heroDto.getHeight(), heroDto.getWeight(), heroDto.getSpecialPower(), heroDto.getIntelligence(), heroDto.getStrength(), heroDto.getPower(), heroDto.getSpeed(), heroDto.getAgility(), heroDto.getDescription(), heroDto.getStory());
        when(heroRepository.save(any())).thenReturn(heroEntity);
        //service call/. saves object and returns saved object
        HeroDto response = heroService.postHero(heroDto);
        //compare saved(service call) object with heroDTO
        assertEquals(heroDto, response);
    }

    @Test
    public void getHeroServiceTest() {
        //Setup
        HeroDto heroDto = new HeroDto("img", "Bruce", "batman", 6.2, 180, "money", 160, 100, "gadgets", 10, 15, "Dark Knight", "lost parents in an alley way");
        List<HeroEntity> heroEntity = new ArrayList<>();
        heroEntity.add(new HeroEntity(heroDto.getImage(), heroDto.getName(), heroDto.getHeroName(), heroDto.getHeight(), heroDto.getWeight(), heroDto.getSpecialPower(), heroDto.getIntelligence(), heroDto.getStrength(), heroDto.getPower(), heroDto.getSpeed(), heroDto.getAgility(), heroDto.getDescription(), heroDto.getStory()));
        when(heroRepository.findAll()).thenReturn(heroEntity);
        //Exercise
        List<HeroDto> response = heroService.getAll();
        //Assertion
        List<HeroDto> expected = new ArrayList<>();
        expected.add(heroDto);
        assertEquals(expected, response);
    }

    @Test
    public void getSpecificHeroServiceTest() {
        //HeroDto heroDto = new HeroDto("img","Bruce","batman",6.2,180,"money",160,100,"gadgets",10,15,"Dark Knight","lost parents in an alley way");
        //Setup
        HeroEntity heroEntity = new HeroEntity();
        //heroEntity.add(new HeroEntity(heroDto.getImage(),heroDto.getName(),heroDto.getHeroName(),heroDto.getHeight(),heroDto.getWeight(),heroDto.getSpecialPower(),heroDto.getIntelligence(),heroDto.getStrength(),heroDto.getPower(),heroDto.getSpeed(),heroDto.getAgility(),heroDto.getDescription(),heroDto.getStory()));
        when(heroRepository.findByName("Bruce")).thenReturn(heroEntity);
        //Exercise
        HeroDto response = heroService.getSpecificHero("Bruce");
        //Assert
        HeroDto expected = new HeroDto();
        assertEquals(expected, response);
    }

    @Test
    public void getSpecificHeroFailServiceTest() {
        //Setup
        when(heroRepository.findByName("Bruce")).thenReturn(null);
        //Exercise
        HeroDto response = heroService.getSpecificHero("Bruce");
        //Assert
        assertEquals(null, response);
    }

}
