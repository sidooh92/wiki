package com.pokemon.wiki.services;


import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.dto.PokemonDto;

public interface PokemonService {
    PokemonDto getPokemonFromApi(int id);
    PokemonDomain convertPokemon(PokemonDto pokemonDto);


}
