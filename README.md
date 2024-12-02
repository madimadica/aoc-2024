# Advent of Code 2024 - Java
A collection of my Java 22 solutions to [Advent of Code 2024](https://adventofcode.com/2024).

Solution packages can be found in [`src/main/java/com/madimadica/aoc2024/`](https://github.com/madimadica/aoc-2024/tree/main/src/main/java/com/madimadica/aoc2024)

## Quick Links
* [Day 1](https://github.com/madimadica/aoc-2024/blob/main/src/main/java/com/madimadica/aoc2024/day1/Day1.java)

## Misc Info
### Input Files
Input file data is stored in the `test/resources` directory as `day<num>_part<num>.txt`, so `day1_part2.txt` for example.

### Running Inputs
Solutions are invoked reflectively by calling `TestRunner.run(DayX.class);`. This internally runs `TestRunner.runPart1(...)` and `TestRunner.runPart2(...)`, which can be run separately with JUnit. 
