package com.pokemon.wiki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilitiesDto {
    private int slot;

    @JsonProperty(value = "is_hidden")
    private boolean isHidden;

    private AbilityDto ability;

    public AbilitiesDto() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "AbilitiesDto{" +
                "slot=" + slot +
                ", isHidden=" + isHidden +
                ", ability=" + ability +
                '}';
    }
}
