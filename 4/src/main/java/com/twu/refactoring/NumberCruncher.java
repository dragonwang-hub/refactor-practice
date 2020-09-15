package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return evenOrOdd(0);
    }

    public int countOdd() {
        return evenOrOdd(1);
    }

    private int evenOrOdd(int i) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == i) count++;
        }
        return count;
    }
// 如何将condition提炼成变量呢？
    public int countPositive() {
        int count = 0;
        for (int number : numbers) {
            if (number >= 0) count++;
        }
        return count;
    }

    public int countNegative() {
        int count = 0;
        for (int number : numbers) {
            if (number < 0) count++;
        }
        return count;
    }
}
