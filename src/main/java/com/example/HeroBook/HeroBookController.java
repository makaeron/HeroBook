package com.example.HeroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroBookController {

    @Autowired
    HeroService heroService;

    @PostMapping("/hero")
    public HeroDto addHero(@RequestBody HeroDto heroDto) {
        return heroService.postHero(heroDto);


    }

    @GetMapping("/hero")
    public List<HeroDto> getHero() {
        return heroService.getAll();
    }

    @GetMapping("/hero/{name}")
    public Object getSpecificHero(@PathVariable String name) {
        HeroDto dto = heroService.getSpecificHero(name);
        return (dto == null) ? "Hero not found" : dto;

        //@RequestVarible if ? used
    }

}
