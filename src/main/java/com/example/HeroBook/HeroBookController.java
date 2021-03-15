package com.example.HeroBook;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroBookController {

    @PostMapping("/hero")
    public void addHero(){

    }

}
