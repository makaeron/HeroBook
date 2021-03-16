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
        HeroDto heroDto = new HeroDto("superman");
        HeroEntity heroEntity = new HeroEntity(heroDto.getName());
        when(heroRepository.save(any())).thenReturn(heroEntity);
        //service call/. saves object and returns saved object
        HeroDto response = heroService.postHero(heroDto);
        //compare saved(service call) object with heroDTO
        assertEquals(heroDto, response);
    }

    @Test
    public void getHeroServiceTest() {
        List<HeroEntity> heroEntity = new ArrayList<>();
        heroEntity.add(new HeroEntity("batman"));
        when(heroRepository.findAll()).thenReturn(heroEntity);

        List<HeroDto> response = heroService.getAll();

        List<HeroDto> expected = new ArrayList<>();
        expected.add(new HeroDto("batman"));
        assertEquals(expected, response);
    }

}
