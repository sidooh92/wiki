package com.pokemon.wiki;

import com.pokemon.wiki.dto.PokemonDto;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

public class WikiApplicationTests {

	@Test
	public void contextLoads() {
		CloseableHttpClient httpClient
				= HttpClients.custom()
				.setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory
				= new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);

	PokemonDto pokemonDto = new RestTemplate(requestFactory).getForObject("https://pokeapi.co/api/v2/pokemon/1", PokemonDto.class);
		System.out.println(pokemonDto);
	}
}

