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
    /**
     * The service used to find the description for a pokemon character.
     * It caches the result using the lower cased character name as the key
     * If the repository throws an error the service returns a default message
     * @param characterName The character for whom the description is needed
     * @return A CharacterResponse entity wrapped in ResponseEntity
     */
    @Cacheable(cacheNames = "characterDescription",key = "{#characterName.toLowerCase()}")
    public String getDescription(String characterName) {
        try{
            log.debug("Calling the repository to get description for :: {}",characterName);
            return dataRepository.getDescription(characterName);
        }catch (NoDataFoundException noDataFoundException){
            log.debug("The repository doesn't have the character {}",characterName);
            return defaultMessage;
        }catch (Exception exception){
            log.error("The repository has thrown an error for character {} Error is :: {}",characterName,exception.getMessage());
            return defaultMessage;
        }
    }
}
