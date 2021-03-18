package com.example.HeroBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroDto {
    String image; 
    String name;
    String heroName;
    double height;
    double weight;
    String specialPower;
    double intelligence;
    double strength;
    String power;
    double speed;
    double agility;
    String description; 
    String story;


}
