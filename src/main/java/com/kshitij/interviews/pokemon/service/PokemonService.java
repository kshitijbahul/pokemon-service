package com.kshitij.interviews.pokemon.service;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;
import com.kshitij.interviews.pokemon.repository.DataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PokemonService {

    private final String defaultMessage="I don't hath't aught for thee";

    private DataRepository dataRepository;

    public PokemonService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public String getDescription(String characterName) {
        try{
            return dataRepository.getDescription(characterName);
        }catch (NoDataFoundException noDataFoundException){
            return defaultMessage;
        }

    }
}
