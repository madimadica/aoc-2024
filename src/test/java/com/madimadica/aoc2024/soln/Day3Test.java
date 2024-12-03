package com.madimadica.aoc2024.soln;

import com.madimadica.aoc2024.TestRunner;
import com.madimadica.aoc2024.common.AdventOfCodeInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    @Test
    void part1() {
        TestRunner.runPart1(Day3.class);
    }

    @Test
    void part1_example() {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        var day = new Day3();
        Assertions.assertEquals(161, day.part1(AdventOfCodeInput.of(input)));
    }

    @Test
    void part2() {
        TestRunner.runPart2(Day3.class);
    }

    @Test
    void part2_example() {
        String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        var day = new Day3();
        Assertions.assertEquals(48, day.part2(AdventOfCodeInput.of(input)));
    }
}