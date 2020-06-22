package com.kshitij.interviews.pokemon.service;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;
import com.kshitij.interviews.pokemon.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PokemonService {

    private final String defaultMessage="I don't hath't aught for thee";

    private DataRepository dataRepository;

    public PokemonService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
    @Cacheable(cacheNames = "characterDescription",key = "{#characterName.toLowerCase()}")
    public String getDescription(String characterName) {
        try{
            return dataRepository.getDescription(characterName);
        }catch (NoDataFoundException noDataFoundException){
            return defaultMessage;
        }
    }
}
