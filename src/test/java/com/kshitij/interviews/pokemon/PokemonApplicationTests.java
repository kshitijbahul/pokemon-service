package com.kshitij.interviews.pokemon;

import com.kshitij.interviews.pokemon.dtos.CharacterResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class PokemonApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void testIfAPokemonIsReachable() {
		//CharacterResponse.builder();
		ResponseEntity<CharacterResponse> response=testRestTemplate.getForEntity("/pokemon/pikachu",CharacterResponse.class);
		Assertions.assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
	}

}