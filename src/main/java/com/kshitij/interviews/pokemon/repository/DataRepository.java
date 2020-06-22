package com.kshitij.interviews.pokemon.repository;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;

public interface DataRepository {
    String addCharacter(String character, String description);
    String getDescription(String character) throws NoDataFoundException;
}
