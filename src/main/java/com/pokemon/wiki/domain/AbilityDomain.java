package com.pokemon.wiki.domain;


import javax.persistence.*;

@Entity
public class AbilityDomain {

    @Override
    public String toString() {
        return "AbilityDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", abilitiesDomain=" + abilitiesDomain +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String url;

    @OneToOne
    @JoinColumn(name = "abilitiesDomianAbility_fk")
    private AbilitiesDomain abilitiesDomain;

    public AbilityDomain() {

    }


}
