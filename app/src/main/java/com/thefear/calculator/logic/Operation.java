package com.thefear.calculator.logic;

public enum Operation {
    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/"),
    EXPON("^2"),
    SQRT("√"),
    EQUALS("=");

    private String name;

    Operation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
