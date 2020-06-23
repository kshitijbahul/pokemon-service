package com.kshitij.interviews.pokemon.repository;

import com.kshitij.interviews.pokemon.exceptions.NoDataFoundException;

/**
 * Abstraction for the Data Repository
 */
public interface DataRepository {
    String addCharacter(String character, String description);
    String getDescription(String character) throws NoDataFoundException;
}
