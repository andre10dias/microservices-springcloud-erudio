package com.github.andre10dias.microservices_springcloud_erudio.math;

public class SimpleMath {
    private SimpleMath() {
        /* This utility class should not be instantiated */
    }

    public static Double sum(Double numberOne, Double numberTwo) {
        return  numberOne + numberTwo;
    }

    public static Double sub(Double numberOne, Double numberTwo) {
        return  numberOne - numberTwo;
    }

    public static Double mul(Double numberOne, Double numberTwo) {
        return  numberOne * numberTwo;
    }

    public static Double div(Double numberOne, Double numberTwo) {
        return  numberOne / numberTwo;
    }

    public static Double ave(Double numberOne, Double numberTwo) {
        return sum(numberOne, numberTwo) / 2;
    }

    public static Double sqr(Double number) {
        return Math.sqrt(number);
    }

}
