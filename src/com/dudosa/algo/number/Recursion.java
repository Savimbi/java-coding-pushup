package com.dudosa.strings.numbers.number;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(isPalindromeV2(new int[]{2,2,3,2,1}));
    }
    static boolean isPalindrome(int[] value){
        return isPalindrome(value,0,value.length - 1);
    }
    static boolean isPalindrome(int[] values, int left, int right){
        if(left >= right)
            return true;
        if(values[left] == values[right]){
           return isPalindrome(values, left + 1, right - 1);
        }
        return false;
    }

    static boolean isPalindromeV2(int[] values){
        int rightIdx = values.length-1;
        int leftIdx = 0;
        boolean sameValue = true;
        while (leftIdx < rightIdx && sameValue){
            sameValue = values[leftIdx] == values[rightIdx];
            leftIdx ++;
            rightIdx --;
        }
        return leftIdx >= rightIdx;
    }
}
