package com.madimadica.aoc2024;

import com.madimadica.aoc2024.common.AdventOfCodeDay;
import com.madimadica.aoc2024.common.input.AdventOfCodeInput;


public class TestRunner {
    private static String readResource(String name) {
        try (var stream = TestRunner.class.getResourceAsStream(name)) {
            return new String(stream.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void run(Class<? extends AdventOfCodeDay> day) {
        runPart1(day);
        runPart2(day);
    }

    public static void runPart1(Class<? extends AdventOfCodeDay> day) {
        int dayNumber = Integer.parseInt(day.getSimpleName().substring(3));
        String fileFormat = "/day%d.txt";
        AdventOfCodeInput part1 = AdventOfCodeInput.of(readResource(fileFormat.formatted(dayNumber)));
        try {
            var noArgsConstructor = day.getDeclaredConstructor();
            AdventOfCodeDay instance = noArgsConstructor.newInstance();
            Object result = instance.part1(part1);
            System.out.printf("Day %d Part 1: %s%n", dayNumber, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runPart2(Class<? extends AdventOfCodeDay> day) {
        int dayNumber = Integer.parseInt(day.getSimpleName().substring(3));
        String fileFormat = "/day%d.txt";
        AdventOfCodeInput part2 = AdventOfCodeInput.of(readResource(fileFormat.formatted(dayNumber)));
        try {
            var noArgsConstructor = day.getDeclaredConstructor();
            AdventOfCodeDay instance = noArgsConstructor.newInstance();
            Object result = instance.part2(part2);
            System.out.printf("Day %d Part 2: %s%n", dayNumber, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
