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
        HeroEntity saveEntity = new HeroEntity(hero.getImage(),hero.getName(),hero.getHeroName(),hero.getHeight(),hero.getWeight(),hero.getSpecialPower(),hero.getIntelligence(),hero.getStrength(),hero.getPower(),hero.getSpeed(),hero.getAgility(),hero.getDescription(),hero.getStory());
        HeroEntity saved = heroRepository.save(saveEntity);
        return new HeroDto(saved.getImage(),saved.getName(),saved.getHeroName(),saved.getHeight(),saved.getWeight(),saved.getSpecialPower(),saved.getIntelligence(),saved.getStrength(),saved.getPower(),saved.getSpeed(),saved.getAgility(),saved.getDescription(),saved.getStory());
    }

    public List<HeroDto> getAll() {
        List<HeroEntity> heroEntityList = heroRepository.findAll();
        return heroEntityList.stream().map(heroEntity ->
                new HeroDto(heroEntity.getImage(),heroEntity.getName(),heroEntity.getHeroName(),heroEntity.getHeight(),heroEntity.getWeight(),heroEntity.getSpecialPower(),heroEntity.getIntelligence(),heroEntity.getStrength(),heroEntity.getPower(),heroEntity.getSpeed(),heroEntity.getAgility(),heroEntity.getDescription(),heroEntity.getStory()))
                .collect(Collectors.toList());
    }
}
