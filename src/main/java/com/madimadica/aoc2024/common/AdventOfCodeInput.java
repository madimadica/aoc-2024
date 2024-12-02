package com.madimadica.aoc2024.common;

import java.util.List;

public record AdventOfCodeInput(
        String rawData,
        List<String> lines
) {

    public static AdventOfCodeInput of(String raw) {
        return new AdventOfCodeInput(raw, List.of(Regex.EOL.split(raw)));
    }

}
