package com.kshitij.interviews.pokemon.controller;

import com.kshitij.interviews.pokemon.dtos.CharacterResponse;
import com.kshitij.interviews.pokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pokemon")
@Slf4j
public class PokemonController {
    @Autowired
    PokemonService pokemonService;
    /**
     * Get Rest Endpoint to return the description for a pokemon character
     * @param character The character for whom the description is needed
     * @return A CharacterResponse entity wrapped in ResponseEntity
     */
    @GetMapping("/{character}")
    private ResponseEntity<CharacterResponse> getCharacterDescription(@PathVariable String character){
        log.debug("Description requested for {}",character);
        return ResponseEntity.ok(CharacterResponse.builder().name(character).description(pokemonService.getDescription(character)).build());
    }

    @ExceptionHandler
    private ResponseEntity handleServiceException(Exception e){
        log.error("Exception handler invoked Exception is :: {}",e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
