package com.madimadica.aoc2024.common;

import java.util.List;

public interface MappingStrategy<X> {
    X map(String s);

    public static final MappingStrategy<List<Long>> NUMBERS = s -> Utils.split(s, Regex.WHITESPACES).stream().map(Long::parseLong).toList();
}
