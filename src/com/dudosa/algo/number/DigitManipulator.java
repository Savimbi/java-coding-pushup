package com.dudosa.strings.numbers;

public class DigitManipulator {

    public static void main(String[] args) {
        extractDigits(123);
    }
    static void extractDigits(final int startValue){
        int remainingValue = startValue;
        while (remainingValue > 0){
            final  int digit = remainingValue % 10;
            System.out.println(digit+ " ");
            remainingValue = remainingValue /10;
        }
        System.out.println();
    }
}
