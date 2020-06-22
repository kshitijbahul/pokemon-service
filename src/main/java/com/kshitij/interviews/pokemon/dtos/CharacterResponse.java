package com.kshitij.interviews.pokemon.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CharacterResponse {
    private String name;
    private String description;
}
