package com.madimadica.aoc2024.soln;

import com.madimadica.aoc2024.common.AdventOfCodeDay;
import com.madimadica.aoc2024.common.input.AdventOfCodeInput;


public class Day4 implements AdventOfCodeDay {
    @Override
    public Object part1(AdventOfCodeInput input) {
        var lines = input.lines();
        final int xMax = lines.size();
        final int yMax = lines.getFirst().length();
        char[][] grid = new char[xMax][yMax];
        for (int i = 0; i < lines.size(); ++i) {
            grid[i] = lines.get(i).toCharArray();
        }

        int count = 0;

        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; ++y) {
                count += findXmasPart1A(grid, x, y);
            }
        }
        return count;
    }

    private int findXmasPart1A(char[][] grid, int x, int y) {
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
                {1, 1},
                {-1, 1},
                {-1, -1},
                {1, -1}
        };
        int count = 0;
        for (int[] direction : directions) {
            if (findXmasPart1B(grid, x, y, direction[0], direction[1])) {
                count++;
            }
        }
        return count;
    }

    private boolean findXmasPart1B(char[][] grid, int x, int y, int xDir, int yDir) {
        // Walk in the direction to check
        int xPos = x;
        int yPos = y;
        int index = 0;
        while (!oob(grid, xPos, yPos)) {
            char c = grid[xPos][yPos];
            switch (index) {
                case 0 -> {
                    if (c != 'X') {
                        return false;
                    }
                }
                case 1 -> {
                    if (c != 'M') {
                        return false;
                    }
                }
                case 2 -> {
                    if (c != 'A') {
                        return false;
                    }
                }
                case 3 -> {
                    return c == 'S';
                }
            }
            xPos += xDir;
            yPos += yDir;
            index++;
        }
        return false;
    }

    private boolean oob(char[][] grid, int x, int y) {
        return (x < 0 || y < 0) || (x >= grid.length) || (y >= grid[x].length);
    }


    @Override
    public Object part2(AdventOfCodeInput input) {
        var lines = input.lines();
        final int xMax = lines.size();
        final int yMax = lines.getFirst().length();
        char[][] grid = new char[xMax][yMax];
        for (int i = 0; i < lines.size(); ++i) {
            grid[i] = lines.get(i).toCharArray();
        }

        int count = 0;

        for (int x = 1; x < xMax - 1; x++) {
            for (int y = 1; y < yMax - 1; ++y) {
                if (findXmasPart2(grid, x, y)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean findXmasPart2(char[][] grid, int x, int y) {
        return grid[x][y] == 'A'
                && isMS(grid[x - 1][y - 1], grid[x + 1][y + 1])
                && isMS(grid[x - 1][y + 1], grid[x + 1][y - 1]);
    }

    private boolean isMS(char a, char b) {
        return (a == 'M' && b == 'S') || (a == 'S' && b =='M');
    }

}
