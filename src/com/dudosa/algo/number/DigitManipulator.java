package com.dudosa.strings.numbers.number;

import java.util.ArrayList;
import java.util.List;

public class DigitManipulator {

    public static void main(String[] args) {
//        extractDigits(123);
        System.out.println(findPrimes(25));
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
    static List<Integer> findProperDivisors(final int value){
        final List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= value/2; i++){
            if(value % i == 0){
                divisors.add(i);
            }
        }
        return  divisors;
    }
     static boolean isPrime(final int potentialP){
        for(int i = 2; i <= potentialP /2; i++){
            if(potentialP % i == 0) return false;
        }
        return true;
     }

     static List<Integer> findPrimes(final int limit){
        var primes = new ArrayList<Integer>();

        for(int i = 2; i < limit; i++){
            if(isPrime(i)) primes.add(i);
        }
         return primes;
     }
}


