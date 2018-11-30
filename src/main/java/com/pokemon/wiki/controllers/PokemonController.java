package com.pokemon.wiki.controllers;


import com.pokemon.wiki.dao.PokemonRepository;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.domain.SpeciesDomain;
import com.pokemon.wiki.dto.PokemonDto;
import com.pokemon.wiki.exceptions.EmptyPokemonException;
import com.pokemon.wiki.exceptions.PokemonDoNotExistException;
import com.pokemon.wiki.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findPokemonName")
    public PokemonDomain byName(@RequestParam(value = "name") String name) {

        //todo find using name in db and return

        return null;
    }

    @GetMapping("/countPokemon")
    public int countPokemon() {

        //todo count pokemon in db

        return 0;
    }

    @DeleteMapping("/countPokemon/{id}")
    public void deletePokemon(@PathVariable("id") Long id) throws PokemonDoNotExistException {
        Optional<PokemonDomain> byId = pokemonRepository.findById(id);
        if(!byId.isPresent()) throw new PokemonDoNotExistException();
        byId.ifPresent(p -> pokemonRepository.delete(p));


    }

    @GetMapping("/pokemon")
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

    @GetMapping("/pokemonAll")
    public List<PokemonDomain> returnAllPokemons() {
        return pokemonRepository.findAll();
    }



    @GetMapping("/addPokemonBody")
    public int addNewPokemonByBody() throws EmptyPokemonException {

        throw new EmptyPokemonException();

        //return pokemon id after save to db
       // return 0;
    }

    @PostMapping("/addPokemonUrl")
    public ResponseEntity<Integer> addNewPokemon(@RequestParam(value = "name") String pokemonName,
                      @RequestParam(value = "speciesName") String speciesName,
                      @RequestParam(value = "speciesUrl") String url) {

        PokemonDomain newPokemon = new PokemonDomain();
        SpeciesDomain species = new SpeciesDomain();
        species.setName(speciesName);
        species.setUrl(url);
        species.setPokemonDomain(newPokemon);

        newPokemon.setName(pokemonName);
        newPokemon.setSpecies(species);

        PokemonDomain save = pokemonRepository.save(newPokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(Math.toIntExact(save.getId()));

    }


}
