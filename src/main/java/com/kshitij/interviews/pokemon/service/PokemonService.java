package com.kshitij.interviews.pokemon.service;

import com.kshitij.interviews.pokemon.repository.DataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PokemonService {

    private DataRepository dataRepository;

    public String getDescription(String characterName) {
        return dataRepository.getDescription(characterName);
    }
}
