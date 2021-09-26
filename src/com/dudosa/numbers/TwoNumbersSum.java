package com.dudosa.strings.numbers;
import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for(int i = 0; i < array.length-1; i++){
            int firstNum = array[i];
            for(int j = i+ 1; j < array.length; j++){
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum){
                    return new int[]{firstNum, secondNum};
                }
            }
        }
        return new int[0];
    }
}