package com.thefear.calculator.logic;

public class CalculatorImp implements Calculator {

    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {
            case ADD:
                return argOne + argTwo;
            case SUB:
                return argOne - argTwo;
            case MULT:
                return argOne * argTwo;
            case DIV:
                return argOne / argTwo;
            case EXPON:
                return argOne * argOne;
            case SQRT:
                return Math.sqrt(argOne);
        }
        return 0.0;
    }
}
