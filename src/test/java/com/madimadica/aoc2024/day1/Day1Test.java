package com.madimadica.aoc2024.day1;

import com.madimadica.aoc2024.TestRunner;
import com.madimadica.aoc2024.common.AdventOfCodeInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day1Test {

    @Test
    void part1_example() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""";
        var day1 = new Day1();
        Assertions.assertEquals(11L, day1.part1(AdventOfCodeInput.of(input)));
    }

    @Test
    void part1() {
        TestRunner.runPart1(Day1.class);
    }

    @Test
    void part2() {
    }
}