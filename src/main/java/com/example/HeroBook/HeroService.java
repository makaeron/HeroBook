package com.example.HeroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    public HeroDto postHero(HeroDto hero) {
        HeroEntity saveEntity = new HeroEntity(hero.getName());
        HeroEntity saved = heroRepository.save(saveEntity);
        return new HeroDto(saved.getName());
    }

    public List<HeroDto> getAll() {
        List<HeroEntity> heroEntityList = heroRepository.findAll();
        return heroEntityList.stream().map(heroEntity -> new HeroDto(heroEntity.getName())).collect(Collectors.toList());
    }
}
