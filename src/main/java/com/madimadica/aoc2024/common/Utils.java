package com.madimadica.aoc2024.common;

import java.util.List;
import java.util.regex.Pattern;

public class Utils {
    public static List<String> split(String input, Pattern regex) {
        return List.of(regex.split(input));
    }

    public static List<String> splitWhitespace(String input) {
        return split(input, Regex.WHITESPACES);
    }

    public static List<Integer> splitInt(String input, Pattern regex) {
        return split(input, regex).stream().map(Integer::parseInt).toList();
    }

    public static List<Integer> splitWhitespaceInt(String input) {
        return splitInt(input, Regex.WHITESPACES);
    }
}
