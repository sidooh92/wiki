package com.pokemon.wiki.services;

import com.pokemon.wiki.domain.AbilitiesDomain;
import com.pokemon.wiki.domain.AbilityDomain;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.domain.SpeciesDomain;
import com.pokemon.wiki.dto.AbilitiesDto;
import com.pokemon.wiki.dto.AbilityDto;
import com.pokemon.wiki.dto.PokemonDto;
import com.pokemon.wiki.dto.SpeciesDto;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Override
    public PokemonDto getPokemonFromApi(int id) {
        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        PokemonDto pokemonDto = new RestTemplate(requestFactory)
                .getForObject("https://pokeapi.co/api/v2/pokemon/"+id, PokemonDto.class);
        return pokemonDto;
    }

    @Override
    public PokemonDomain convertPokemon(PokemonDto pokemonDto) {
        SpeciesDomain speciesParsedFromDto = new SpeciesDomain();
        SpeciesDto speciesDto = pokemonDto.getSpecies();
        speciesParsedFromDto.setName(speciesDto.getName());
        speciesParsedFromDto.setUrl(speciesDto.getUrl());

        PokemonDomain pokemonParsedFromDto = new PokemonDomain();
        pokemonParsedFromDto.setName(pokemonDto.getName());

        List<AbilitiesDomain> abilitiesDomainList =  new ArrayList<>();
        List<AbilitiesDto> abilitiesDtoList = pokemonDto.getAbilities();
        for(AbilitiesDto abilitiesDto : abilitiesDtoList) {
            AbilitiesDomain abilitiesDomain = new AbilitiesDomain();
            abilitiesDomain.setPokemonDomainAbilities(pokemonParsedFromDto);
            abilitiesDomain.setHidden(abilitiesDto.isHidden());
            abilitiesDomain.setSlot(abilitiesDto.getSlot());

            AbilityDomain abilityDomain = new AbilityDomain();
            abilitiesDomain.setAbility(abilityDomain);
            abilityDomain.setAbilitiesDomain(abilitiesDomain);

            AbilityDto abilityDto = abilitiesDto.getAbility();
            abilityDomain.setName(abilityDto.getName());
            abilityDomain.setUrl(abilityDto.getUrl());
        }

        pokemonParsedFromDto.setAbilities(abilitiesDomainList);
        pokemonParsedFromDto.setSpecies(speciesParsedFromDto);
        speciesParsedFromDto.setPokemonDomain(pokemonParsedFromDto);
        return pokemonParsedFromDto;

    }
}
