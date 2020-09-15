package com.twu.refactoring;

public class getTimePara {
    private int start;
    private int end;
    private String stringIndexOutOfBoundsException;
    private String numberFormatException;
    private int min;
    private int max;
    private String illegalArgumentException;

    public getTimePara(int start, int end, String stringIndexOutOfBoundsException, String numberFormatException, int min, int max, String illegalArgumentException) {
        this.start = start;
        this.end = end;
        this.stringIndexOutOfBoundsException = stringIndexOutOfBoundsException;
        this.numberFormatException = numberFormatException;
        this.min = min;
        this.max = max;
        this.illegalArgumentException = illegalArgumentException;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }


    public String getStringIndexOutOfBoundsException() {
        return stringIndexOutOfBoundsException;
    }


    public String getNumberFormatException() {
        return numberFormatException;
    }


    public int getMin() {
        return min;
    }


    public int getMax() {
        return max;
    }


    public String getIllegalArgumentException() {
        return illegalArgumentException;
    }


}
