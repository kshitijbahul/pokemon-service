package com.kshitij.interviews.pokemon.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class InternalStorageRepositoryTest {

    private DataRepository dataRepository;
    final String CHARACTER_NAME= "pikachu";

    @BeforeEach
    public void setDataRepository(){
        dataRepository= new InternalStorageRepository();
    }
    @Test
    void testAddingWoks() {
        String description= "Test Description";
        dataRepository.addCharacter(CHARACTER_NAME,description);
        Assertions.assertThat(dataRepository.getDescription(CHARACTER_NAME)).isEqualToIgnoringCase(description);
    }
    @Test
    void testAddingWorksCaseIndependent() {
        String description= "Test Description";
        dataRepository.addCharacter(CHARACTER_NAME,description);
        Assertions.assertThat(dataRepository.getDescription(CHARACTER_NAME.toLowerCase())).isEqualToIgnoringCase(description);
    }


}