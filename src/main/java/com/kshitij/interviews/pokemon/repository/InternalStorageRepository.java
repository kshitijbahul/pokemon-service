package com.kshitij.interviews.pokemon.repository;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * The Data Repository abstraction is backed with a ConcurrentHashMap for this example
 */
@Service
@Slf4j
public class InternalStorageRepository implements DataRepository {
    private ConcurrentHashMap<String,String> dataStore= new ConcurrentHashMap<>();

    /**
     * To add new character and their description to the data store
     * @param character
     * @param description
     * @return Returns the description added
     */
    @Override
    public String addCharacter(String character, String description) {
        log.debug("Adding character::{} with description::{}",character,description);
        return dataStore.put(character.toLowerCase(),description);
    }

    /**
     * Looking up data in the repository
     * @param character whose description is needed
     * @return A String containing the description for the character, if its found
     * @throws NoDataFoundException, if the character cannot be found
     */
    @Override
    public String getDescription(String character) throws NoDataFoundException {
        log.debug("Finding description for  character::{} ",character);
        if (dataStore.containsKey(character.toLowerCase())){
            log.debug("Found description for character::{} in the store",character);
            return dataStore.get(character.toLowerCase());
        }
        throw new NoDataFoundException();
    }
}
