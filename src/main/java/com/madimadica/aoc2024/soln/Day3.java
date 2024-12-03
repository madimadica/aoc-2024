package com.madimadica.aoc2024.soln;

import com.madimadica.aoc2024.common.AdventOfCodeDay;
import com.madimadica.aoc2024.common.AdventOfCodeInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3 implements AdventOfCodeDay {
    @Override
    public Object part1(AdventOfCodeInput input) {
        var re = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        int total = 0;
        for (String line : input.lines()) {
            var matcher = re.matcher(line);
            while (matcher.find()) {
                String lhs = matcher.group(1);
                String rhs = matcher.group(2);
                total += Integer.parseInt(lhs) * Integer.parseInt(rhs);
            }
        }
        return total;
    }

    enum DataType {
        MUL,
        DO,
        DONT
    }

    record Data(int pos, DataType type, Integer a, Integer b) {}

    @Override
    public Object part2(AdventOfCodeInput input) {
        var reMul = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        var reDo = Pattern.compile("do\\(\\)");
        var reDont = Pattern.compile("don't\\(\\)");
        String allData = String.join("", input.lines());

        List<Data> dataset = new ArrayList<>();

        var matcher = reMul.matcher(allData);
        while (matcher.find()) {
            String lhs = matcher.group(1);
            String rhs = matcher.group(2);
            var startPos = matcher.start();
            dataset.add(new Data(startPos, DataType.MUL, Integer.parseInt(lhs), Integer.parseInt(rhs)));
        }


        var matcherDo = reDo.matcher(allData);
        while (matcherDo.find()) {
            var startPos = matcherDo.start();
            dataset.add(new Data(startPos, DataType.DO, null, null));
        }

        var matcherDont = reDont.matcher(allData);
        while (matcherDont.find()) {
            var startPos = matcherDont.start();
            dataset.add(new Data(startPos, DataType.DONT, null, null));
        }


        dataset.sort(Comparator.comparingInt(Data::pos));

        int total = 0;
        boolean enabled = true;
        for (var datapoint : dataset) {
            switch (datapoint.type) {
                case DO -> enabled = true;
                case DONT -> enabled = false;
                case MUL -> {
                    if (enabled) {
                        total += datapoint.a * datapoint.b;
                    }
                }
            }
        }
        return total;
    }
}
