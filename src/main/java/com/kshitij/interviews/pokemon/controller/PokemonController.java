package com.kshitij.interviews.pokemon.controller;

import com.kshitij.interviews.pokemon.dtos.CharacterResponse;
import com.kshitij.interviews.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("/{character}")
    private ResponseEntity<CharacterResponse> getCharacterDescription(@PathVariable String character){
        return ResponseEntity.ok(CharacterResponse.builder().name(character).description(pokemonService.getDescription(character)).build());
    }

    @ExceptionHandler
    private ResponseEntity handleServiceException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
