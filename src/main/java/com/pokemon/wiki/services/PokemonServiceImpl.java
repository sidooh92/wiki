package com.pokemon.wiki.services;

import com.pokemon.wiki.domain.AbilitiesDomain;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.domain.SpeciesDomain;
import com.pokemon.wiki.dto.AbilitiesDto;
import com.pokemon.wiki.dto.PokemonDto;
import com.pokemon.wiki.dto.SpeciesDto;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
                .getForObject("https://pokeapi.co/api/v2/pokemon/1", PokemonDto.class);
        return pokemonDto;
    }

    @Override
    public PokemonDomain convertPokemon(PokemonDto pokemonDto) {
        SpeciesDomain speciesParsedFromDto = new SpeciesDomain();
        SpeciesDto speciesDto = pokemonDto.getSpecies();
        speciesParsedFromDto.setName(speciesDto.getName());
        speciesParsedFromDto.setUrl(speciesDto.getUrl());


        AbilitiesDomain abilitiesParsedFromDto =  new AbilitiesDomain();
        List<AbilitiesDto> abilitiesDto = pokemonDto.getAbilities();
        //.....


        PokemonDomain pokemonParsedFromDto = new PokemonDomain();
        pokemonParsedFromDto.setName(pokemonDto.getName());
        pokemonParsedFromDto.setSpecies(speciesParsedFromDto);

        return pokemonParsedFromDto;

    }
}
