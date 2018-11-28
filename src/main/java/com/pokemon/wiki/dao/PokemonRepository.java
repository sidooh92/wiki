package com.pokemon.wiki.dao;


import com.pokemon.wiki.domain.PokemonDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonDomain, Long> {
}
