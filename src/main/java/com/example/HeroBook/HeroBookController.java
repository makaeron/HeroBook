package com.example.HeroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroBookController {

    @Autowired
    HeroService heroService;
    @PostMapping("/hero")
    public HeroDto addHero(@RequestBody HeroDto heroDto){
        return heroService.postHero(heroDto);
    }

}
