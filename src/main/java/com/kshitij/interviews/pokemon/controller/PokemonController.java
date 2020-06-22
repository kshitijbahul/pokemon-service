package com.kshitij.interviews.pokemon.controller;

import com.kshitij.interviews.pokemon.dtos.CharacterResponse;
import com.kshitij.interviews.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("/{character}")
    private ResponseEntity getCharacterDescription(@PathVariable String character){
        return ResponseEntity.ok(CharacterResponse.builder().name(character).description(pokemonService.getDescription(character)).build());
    }

}
