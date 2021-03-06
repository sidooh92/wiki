package com.pokemon.wiki.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PokemonDomain {
    @Override
    public String toString() {
        return "PokemonDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseExperience=" + baseExperience +
                ", orderPokemon=" + orderPokemon +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int baseExperience;
    private int orderPokemon;

    @JsonManagedReference
    @OneToOne(mappedBy = "pokemonDomain", cascade=CascadeType.ALL)
    private SpeciesDomain species;

    @OneToMany(mappedBy = "pokemonDomainAbilities", cascade=CascadeType.ALL)
    private List<AbilitiesDomain> abilities;


    public PokemonDomain() {
        abilities = new ArrayList<>();
    }

    public PokemonDomain(long id, String name, int baseExperience, int orderPokemon, SpeciesDomain species, List<AbilitiesDomain> abilities) {
        super();
        this.id = id;
        this.name = name;
        this.baseExperience = baseExperience;
        this.orderPokemon = orderPokemon;
        this.species = species;

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getOrderPokemon() {
        return orderPokemon;
    }

    public void setOrderPokemon(int orderPokemon) {
        this.orderPokemon = orderPokemon;
    }

    public SpeciesDomain getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesDomain species) {
        this.species = species;
    }

    public List<AbilitiesDomain> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitiesDomain> abilities) {
        this.abilities = abilities;
    }
}
