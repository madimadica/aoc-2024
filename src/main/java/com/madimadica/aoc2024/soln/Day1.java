package com.madimadica.aoc2024.soln;

import com.madimadica.aoc2024.common.AdventOfCodeDay;
import com.madimadica.aoc2024.common.AdventOfCodeInput;
import com.madimadica.aoc2024.common.Counter;
import com.madimadica.aoc2024.common.Utils;

import java.util.List;

public class Day1 implements AdventOfCodeDay {

    private record LineData(int left, int right) {
        public static LineData of(String line) {
            var list = Utils.splitWhitespaceInt(line);
            return new LineData(
                    list.get(0),
                    list.get(1)
            );
        }
    }

    @Override
    public Object part1(AdventOfCodeInput input) {
        List<LineData> originalLineData = input.lines().stream().map(LineData::of).toList();
        List<Integer> sortedLhs = originalLineData.stream().map(LineData::left).sorted().toList();
        List<Integer> sortedRhs = originalLineData.stream().map(LineData::right).sorted().toList();

        final int lineCount = originalLineData.size();
        long totalDiff = 0;
        for (int i = 0; i < lineCount; ++i) {
            totalDiff += Math.abs(sortedLhs.get(i) - sortedRhs.get(i));
        }
        return totalDiff;
    }

    @Override
    public Object part2(AdventOfCodeInput input) {
        List<LineData> originalLineData = input.lines().stream().map(LineData::of).toList();
        List<Integer> lhs = originalLineData.stream().map(LineData::left).toList();
        Counter<Integer> rhsCounts = new Counter<>();
        originalLineData.stream()
                .map(LineData::right)
                .forEach(rhsCounts::increment);
        return lhs.stream()
                .map(num -> rhsCounts.get(num) * num)
                .reduce(0L, Long::sum);
    }
}
