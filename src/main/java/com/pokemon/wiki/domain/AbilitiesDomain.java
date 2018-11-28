package com.pokemon.wiki.domain;

import javax.persistence.*;

@Entity
public class AbilitiesDomain {

    @Override
    public String toString() {
        return "AbilitiesDomain{" +
                "id=" + id +
                ", slot=" + slot +
                ", isHidden=" + isHidden +
                ", ability=" + ability +
                ", pokemonDomainAbilities=" + pokemonDomainAbilities +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int slot;

    private boolean isHidden;

    @OneToOne(mappedBy = "abilitiesDomain")
    private AbilityDomain ability;


    @ManyToOne
    @JoinColumn(name = "pokemonDomain_fk")
    private PokemonDomain pokemonDomainAbilities;

    public AbilitiesDomain() {
    }

    public AbilitiesDomain(int id, int slot, boolean isHidden, AbilityDomain ability, PokemonDomain pokemonDomainAbilities) {
        this.id = id;
        this.slot = slot;
        this.isHidden = isHidden;
        this.ability = ability;
        this.pokemonDomainAbilities = pokemonDomainAbilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public AbilityDomain getAbility() {
        return ability;
    }

    public void setAbility(AbilityDomain ability) {
        this.ability = ability;
    }

    public PokemonDomain getPokemonDomainAbilities() {
        return pokemonDomainAbilities;
    }

    public void setPokemonDomainAbilities(PokemonDomain pokemonDomainAbilities) {
        this.pokemonDomainAbilities = pokemonDomainAbilities;
    }
}
