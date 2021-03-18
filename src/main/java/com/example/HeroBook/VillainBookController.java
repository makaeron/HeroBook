package com.example.HeroBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VillainBookController {

    @PostMapping("/villains")
    public VillainDto postVillain(@RequestBody VillainDto villainDto){
        return villainDto;
    }

    @GetMapping("/villains")
    public List<VillainDto> getVillain(){
        return new ArrayList<VillainDto>() ;
    }
}
