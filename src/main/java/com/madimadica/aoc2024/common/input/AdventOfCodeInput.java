package com.madimadica.aoc2024.common.input;

import com.madimadica.aoc2024.common.MappingStrategy;
import com.madimadica.aoc2024.common.Regex;

import java.util.List;

public record AdventOfCodeInput(
        String rawInput
) {

    public static AdventOfCodeInput of(String raw) {
        return new AdventOfCodeInput(raw);
    }

    public List<String> lines() {
        return List.of(Regex.EOL.split(rawInput));
    }

    public <T> List<T> mapLines(MappingStrategy<T> mappingStrategy) {
        return lines().stream().map(mappingStrategy::map).toList();
    }
}
