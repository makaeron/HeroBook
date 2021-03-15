package com.example.HeroBook;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class HeroEntity {
    String name;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;


}
