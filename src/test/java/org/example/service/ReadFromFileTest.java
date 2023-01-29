package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadFromFileTest {

    @Test
    void readFromFile() {
        assertDoesNotThrow(()->{
            ReadFromFile.readFromFile();
        });
    }
}