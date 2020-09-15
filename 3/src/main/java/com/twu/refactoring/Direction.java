package com.twu.refactoring;

import java.util.HashMap;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }


    public Direction turnRight() {
        HashMap<Character, Character> rightMap = new HashMap<>();
        rightMap.put('N', 'E');
        rightMap.put('S', 'W');
        rightMap.put('E', 'N');
        rightMap.put('W', 'S');
        return getDirection(rightMap);
    }

    public Direction turnLeft() {
        HashMap<Character, Character> leftMap = new HashMap<>();
        leftMap.put('N', 'W');
        leftMap.put('S', 'E');
        leftMap.put('E', 'N');
        leftMap.put('W', 'S');
        return getDirection(leftMap);
    }

    private Direction getDirection(HashMap<Character, Character> map) {
        if (map.containsKey(direction)) {
            return new Direction(map.get(direction));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
