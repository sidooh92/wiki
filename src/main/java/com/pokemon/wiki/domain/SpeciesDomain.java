package com.pokemon.wiki.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class SpeciesDomain {
    @Override
    public String toString() {
        return "SpeciesDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String url;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "pokemonDomain_id")
    @JsonBackReference
    private PokemonDomain pokemonDomain;


    public SpeciesDomain() {

    }

    public SpeciesDomain(String name, String url) {
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PokemonDomain getPokemonDomain() {
        return pokemonDomain;
    }

    public void setPokemonDomain(PokemonDomain pokemonDomain) {
        this.pokemonDomain = pokemonDomain;
    }
}
