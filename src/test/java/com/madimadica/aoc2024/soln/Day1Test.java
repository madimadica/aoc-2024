package com.madimadica.aoc2024.soln;

import com.madimadica.aoc2024.TestRunner;
import com.madimadica.aoc2024.common.input.AdventOfCodeInput;
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
    void part2_example() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""";
        var day1 = new Day1();
        Assertions.assertEquals(31L, day1.part2(AdventOfCodeInput.of(input)));
    }

    @Test
    void part2() {
        TestRunner.runPart2(Day1.class);
    }
}