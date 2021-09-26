package com.dudosa.strings.numbers;

import java.util.Arrays;

public class BinarSearch {
    public static void main(String[] args) {
        int[] arr= {32,5,6,2,7,3,9,0,5};
        Arrays.sort(arr);
        System.out.println("Is 1 included? "+binarySearch(6,arr ));
    }

    public static boolean binarySearch(int x, int[] sortedNumber){
        int end = sortedNumber.length -1;
        int start = 0;

        while (start <= end){
            int mid = (start+end)/2 + start;
            System.out.println(mid);
            if (sortedNumber[mid] == x) return true;
            else if (sortedNumber[mid] > x) end = mid -1;
            else start = mid +1;
        }
        return false;
    }
}
