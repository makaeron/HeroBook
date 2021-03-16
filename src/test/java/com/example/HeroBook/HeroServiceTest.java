package com.example.HeroBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Provider;

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
    public void postHeroServiceTest(){

        //object being passed
        HeroDto heroDto = new HeroDto("superman");
        HeroEntity heroEntity = new HeroEntity(heroDto.getName());
        when(heroRepository.save(any())).thenReturn(heroEntity);

        //service call/. saves object and returns saved object
        HeroDto response= heroService.postHero(heroDto);
        //compare saved(service call) object with heroDTO
        assertEquals(heroDto,response);
    }

}
