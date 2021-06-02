package com.dudosa.strings.numbers;

public class Fibonacci {

    int fibonacci(int k){
        if(k <= 1) return 1;
        return fibonacci(k - 2) + fibonacci(k - 1);
    }
}
