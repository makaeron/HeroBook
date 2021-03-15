package com.example.HeroBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Provider;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @InjectMocks
    HeroService heroService;
    @Mock
    HeroRepository heroRepository;

    @Test
    public void postHeroServiceTest(){
        heroService.postHero();


    }

}
