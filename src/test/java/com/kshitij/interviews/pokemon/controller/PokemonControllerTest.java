package com.kshitij.interviews.pokemon.controller;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;
import com.kshitij.interviews.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PokemonController.class)
class PokemonControllerTest {

    @MockBean
    private PokemonService pokemonService;

    @Autowired
    private MockMvc mockMvc;

    private final String CHARACTER_NAME= "pikachu";
    private final String defaultMessage="I don't hath't aught for thee";
    @Test
    public void test_endPointToGetExists() throws Exception {
        given(pokemonService.getDescription(CHARACTER_NAME)).willReturn(defaultMessage);
        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/pokemon/%s",CHARACTER_NAME)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(CHARACTER_NAME))
                .andExpect(jsonPath("description").value(defaultMessage));
    }
    @Test
    public void test_contractMaintainedWhenNoDataFound() throws Exception {
        given(pokemonService.getDescription(CHARACTER_NAME)).willThrow(new NoDataFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/pokemon/%s",CHARACTER_NAME)))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("name").doesNotExist())
                .andExpect(jsonPath("description").doesNotExist());
    }





}