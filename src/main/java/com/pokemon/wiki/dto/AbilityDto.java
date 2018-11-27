package com.pokemon.wiki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityDto {
    private String name;
    private String url;

    public AbilityDto() {

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

    @Override
    public String toString() {
        return "AbilityDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
