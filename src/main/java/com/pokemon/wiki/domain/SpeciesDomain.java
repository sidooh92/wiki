package com.pokemon.wiki.domain;


import javax.persistence.*;

@Entity
public class SpeciesDomain {
    @Override
    public String toString() {
        return "SpeciesDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pokemonDomain=" + pokemonDomain +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String url;

    @OneToOne
    @JoinColumn(name = "pokemonDomain_id")
    private PokemonDomain pokemonDomain;


    public SpeciesDomain() {

    }

    public SpeciesDomain(int id, String name, String url, PokemonDomain pokemonDomain) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pokemonDomain = pokemonDomain;
    }

    public int getId() {
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
