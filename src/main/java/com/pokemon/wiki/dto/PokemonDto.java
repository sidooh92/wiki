package com.pokemon.wiki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDto {

    private String name;
    @JsonProperty(value = "base_experience")
    private int baseExperience;
    private int order;
    private SpeciesDto species;
    private List<AbilitiesDto> abilities;


    public PokemonDto() {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public SpeciesDto getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesDto species) {
        this.species = species;
    }

    public List<AbilitiesDto> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitiesDto> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "PokemonDto{" +
                "name='" + name + '\'' +
                ", baseExperience=" + baseExperience +
                ", order=" + order +
                ", species=" + species +
                ", abilities=" + abilities +
                '}';
    }
}
