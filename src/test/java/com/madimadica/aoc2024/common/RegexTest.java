package com.madimadica.aoc2024.common;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @Test
    void findNums() {
        assertEquals(List.of(12345L, 54321L), Regex.findNums("12345 54321"));
        assertEquals(List.of(12345L, 54321L), Regex.findNums("12345: 54321"));
        assertEquals(List.of(12345L, 54321L), Regex.findNums("12345 - 54321"));
        assertEquals(List.of(12345L, 54321L), Regex.findNums(" 12345 - 54321"));
        assertEquals(List.of(12345L, 54321L), Regex.findNums(" 12345 - 54321   "));
        assertEquals(List.of(12345L, -54321L), Regex.findNums(" 12345 -54321   "));
        assertEquals(List.of(), Regex.findNums(""));
        assertEquals(List.of(12345L), Regex.findNums("12345"));
    }
}
