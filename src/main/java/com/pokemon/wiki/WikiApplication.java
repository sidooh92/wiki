package com.pokemon.wiki;

import com.pokemon.wiki.dao.PokemonRepository;
import com.pokemon.wiki.dao.SpeciesRepository;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.domain.SpeciesDomain;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.security.cert.X509Certificate;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class WikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikiApplication.class, args);
    }

    //todo
    //add swagger

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplateBuilder().build();
    }













    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    SpeciesRepository speciesRepository;

    @Bean
    public CommandLineRunner test() {
        return (args -> {
            SpeciesDomain speciesDomain = new SpeciesDomain("name TEStowe", "url twstowa");

            PokemonDomain pokemonDomain = new PokemonDomain();
            pokemonDomain.setName("TESTOWY POKEMON");
            speciesDomain.setPokemonDomain(pokemonDomain);
            pokemonDomain.setSpecies(speciesDomain);
            pokemonRepository.save(pokemonDomain);

            //select sql do sprawdzenia na bazie wyniku
            //SELECT * FROM SPECIES_DOMAIN join POKEMON_DOMAIN on POKEMON_DOMAIN.ID =  SPECIES_DOMAIN.POKEMON_DOMAIN_ID
        });
    }

}
