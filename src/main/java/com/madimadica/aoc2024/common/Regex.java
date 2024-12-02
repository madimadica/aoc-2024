package com.madimadica.aoc2024.common;

import java.util.regex.Pattern;

public abstract class Regex {
    private Regex() {}

    public static final Pattern EOL = Pattern.compile("\\R");
    public static final Pattern WHITESPACES = Pattern.compile("\\s+");
}
