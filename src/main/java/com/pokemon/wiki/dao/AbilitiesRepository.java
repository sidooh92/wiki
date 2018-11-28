package com.pokemon.wiki.dao;


import com.pokemon.wiki.domain.AbilitiesDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitiesRepository extends JpaRepository<AbilitiesDomain, Long> {
}
