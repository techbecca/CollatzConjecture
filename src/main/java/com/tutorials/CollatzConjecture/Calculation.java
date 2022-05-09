package com.tutorials.CollatzConjecture;

public class Calculation {
    private final long id;
    private final long input;
    private final long result;

    public Calculation(long id, long input, long result) {
        this.id = id;
        this.input = input;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public long getInput() {
        return input;
    }

    public long getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "input=" + input +
                ", result=" + result +
                '}';
    }
}
