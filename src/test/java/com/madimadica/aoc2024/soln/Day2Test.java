package com.madimadica.aoc2024.soln;

import com.madimadica.aoc2024.TestRunner;
import com.madimadica.aoc2024.common.input.AdventOfCodeInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day2Test {

    @Test
    void part1_example() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""";
        var day = new Day2();
        Assertions.assertEquals(2, day.part1(AdventOfCodeInput.of(input)));
    }

    @Test
    void part1() {
        TestRunner.runPart1(Day2.class);
    }


    @Test
    void part2_example() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""";
        var day = new Day2();
        Assertions.assertEquals(4, day.part2(AdventOfCodeInput.of(input)));
    }

    @Test
    void part2() {
        // 710 expected
        TestRunner.runPart2(Day2.class);
    }
}