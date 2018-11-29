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

                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String url;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "abilitiesDomianAbility_fk")
    private AbilitiesDomain abilitiesDomain;

    public AbilityDomain() {

    }


}
