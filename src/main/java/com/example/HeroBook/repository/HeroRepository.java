package com.example.HeroBook.repository;

import com.example.HeroBook.models.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long>{

        HeroEntity findByName(String name);

}
