package com.kshitij.interviews.pokemon.service;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;
import com.kshitij.interviews.pokemon.repository.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@TestPropertySource
class PokemonServiceTest {

    @Mock
    DataRepository dataRepository;


    private final String defaultMessage="I don't hath't aught for thee";

    PokemonService pokemonService;

    final String CHARACTER_NAME= "pikachu";
    @BeforeEach
    public void setupTestBench(){
        pokemonService = new PokemonService(dataRepository);
    }

    @Test
    public void testGettingAPokemon() throws NoDataFoundException {
        given(dataRepository.getDescription(CHARACTER_NAME)).willReturn("A description");

        String description = pokemonService.getDescription(CHARACTER_NAME);
        assert(description).equalsIgnoreCase("A description");
    }
    @Test
    public void testGettingDefaultDescription() {
        given(dataRepository.getDescription(CHARACTER_NAME)).willThrow(new NoDataFoundException());
        String description = pokemonService.getDescription(CHARACTER_NAME);
        assert(description).equalsIgnoreCase(defaultMessage);
    }
}