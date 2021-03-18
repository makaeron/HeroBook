package com.example.HeroBook.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
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

    public HeroEntity(String image, String name, String heroName, double height, double weight, String specialPower, double intelligence, double strength, String power, double speed, double agility, String description, String story) {
        this.image = image;
        this.name = name;
        this.heroName = heroName;
        this.height = height;
        this.weight = weight;
        this.specialPower = specialPower;
        this.intelligence = intelligence;
        this.strength = strength;
        this.power = power;
        this.speed = speed;
        this.agility = agility;
        this.description = description;
        this.story = story;
    }
}
