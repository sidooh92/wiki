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

    public AbilitiesDomain getAbilitiesDomain() {
        return abilitiesDomain;
    }

    public void setAbilitiesDomain(AbilitiesDomain abilitiesDomain) {
        this.abilitiesDomain = abilitiesDomain;
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
