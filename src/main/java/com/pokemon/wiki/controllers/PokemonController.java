package com.pokemon.wiki.controllers;


import com.pokemon.wiki.dao.PokemonRepository;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.dto.PokemonDto;
import com.pokemon.wiki.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController {

    private PokemonRepository pokemonRepository;
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository, PokemonService pokemonService) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public PokemonDomain returnPokemonById
            (@RequestParam(value = "id") Long id) {
        //1 krok sprawdzenie w bazie czy nie ma takiego pokemona
        Optional<PokemonDomain> byId = pokemonRepository.findById(id);

        //2 krok jezeli byId istnieje to zwroc uzytkownikowi, jezeli nie istnieje
        //najpierw zapisz bo bazy i nastepnie zwroc
        if (byId.isPresent()) {
            return byId.get();
        } else {
            PokemonDto pokemonFromApi = pokemonService.getPokemonFromApi(Math.toIntExact(id));
            PokemonDomain pokemonDomain = pokemonService.convertPokemon(pokemonFromApi);
            PokemonDomain save = pokemonRepository.save(pokemonDomain);
            return save;
        }


    }

    @RequestMapping("/pokemonAll")
    public List<PokemonDomain> returnAllPokemons() {
        return pokemonRepository.findAll();
    }


}
