package com.example.HeroBook;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    public HeroDto postHero(HeroDto hero) {
        HeroEntity saveEntity = new HeroEntity(hero.getName());
        HeroEntity saved = heroRepository.save(saveEntity);
        return new HeroDto(saved.getName());
    }

    public List<HeroDto> getAll() {
        return null;
    }
}
