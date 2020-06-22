package com.kshitij.interviews.pokemon.controller;

import com.kshitij.interviews.pokemon.dtos.CharacterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @GetMapping("/{character}")
    private ResponseEntity getCharacterDescription(@PathVariable String character){
        return ResponseEntity.ok("");
    }
}
