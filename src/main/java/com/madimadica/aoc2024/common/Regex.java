package com.madimadica.aoc2024.common;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public abstract class Regex {
    private Regex() {}

    public static final Pattern EOL = Pattern.compile("\\R");
    public static final Pattern WHITESPACES = Pattern.compile("\\s+");
    public static final Pattern INTEGERS = Pattern.compile("-?\\d+");


    public static List<Long> findNums(String s) {
        return Utils.allMatches(s, INTEGERS)
                .stream()
                .map(MatchResult::group)
                .map(Long::parseLong)
                .toList();
    }
}
