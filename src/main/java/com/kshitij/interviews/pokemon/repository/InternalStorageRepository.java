package com.kshitij.interviews.pokemon.repository;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InternalStorageRepository implements DataRepository {
    private ConcurrentHashMap<String,String> dataStore= new ConcurrentHashMap<>();

    @Override
    public String addCharacter(String character, String description) {
        return dataStore.put(character.toLowerCase(),description);
    }

    @Override
    public String getDescription(String character) throws NoDataFoundException {
        if (dataStore.containsKey(character.toLowerCase())){
            return dataStore.get(character.toLowerCase());
        }
        throw new NoDataFoundException();
    }
}
