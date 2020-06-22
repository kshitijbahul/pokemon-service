package com.kshitij.interviews.pokemon.dtos;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;


class CharacterResponseTest {

    private final String CHARACTER= "pikachu";
    @Test
    public void testBuilder(){
        CharacterResponse characterResponse = CharacterResponse.builder().name(CHARACTER).description("Somee Desc").build();
        Assert.notNull(characterResponse.getName()," Name is null ");
        Assert.notNull(characterResponse.getDescription()," Name is null ");
        assertThat(characterResponse.getName()).isEqualToIgnoringCase(CHARACTER);
        assertThat(characterResponse.getDescription()).isEqualToIgnoringCase("Somee Desc");
    }

}