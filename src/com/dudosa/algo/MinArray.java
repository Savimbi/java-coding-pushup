package com.dudosa.strings.numbers;

import java.util.Arrays;

public class MinArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subArraySort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19})));
    }

    //O(n) time complexity | O(1) space
    static int[] subArraySort(int[] values){
        int minOutOfOrder=Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for(int i =0 ; i < values.length; i++){
            int currentNum = values[i];
            if(isOutOfOrder(i, currentNum, values)) {
                minOutOfOrder = Math.min(minOutOfOrder, currentNum);
                maxOutOfOrder = Math.max(maxOutOfOrder, currentNum);
            }
        }
        if(minOutOfOrder == Integer.MAX_VALUE){
            return  new int[]{-1,-1};
        }
        int subArrayLeftIdx = 0;
        while (minOutOfOrder >= values[subArrayLeftIdx])
        {
            subArrayLeftIdx ++;
        }
        int subArrayRightIdx = values.length -1;
        while (maxOutOfOrder <= values[subArrayRightIdx]){
            subArrayRightIdx--;
        }
        return new int[]{subArrayLeftIdx,subArrayRightIdx};
    }

    private static boolean isOutOfOrder(int idx, int currentNum, int[] values) {
        if(idx == 0){
            return currentNum > values[idx + 1];
        }
        if(idx == values.length -1)
            return currentNum < values[idx - 1];
        return currentNum > values[idx + 1] || currentNum < values[idx -1];

    }
}
