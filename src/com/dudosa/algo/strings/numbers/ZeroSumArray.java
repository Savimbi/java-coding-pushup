package com.dudosa.strings.numbers.strings.numbers;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumArray {
    //O(n) space | O(n) time
    public boolean sumZero(int[] numbers){
        Set<Integer> numSet = new HashSet<>();
        int sum = 0;
        for (int number: numbers ) {
            if (number == 0){
                return true;
            }
            sum += number;
            if (sum == 0 || numSet.contains(sum)){
                return true;
            }
            numSet.add(sum);
        }
        return  false;

    }
}
