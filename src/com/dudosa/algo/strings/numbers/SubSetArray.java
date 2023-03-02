package com.dudosa.strings.numbers.strings.numbers;

import java.util.List;

public class SubSetArray {
    // O(N) time complex  and O(1) space complex
    public boolean isAsubSet(List<Integer> array, List<Integer> sequence){
        if (sequence.size() > array.size()){
            return  false;
        }
        int arrayIdx = 0;
        int seqIdx = 0;
        while(arrayIdx < array.size() && seqIdx < sequence.size()){
            if(array.get(arrayIdx) == sequence.get(seqIdx)){
                seqIdx++;
            }
            arrayIdx++;
        }
        return seqIdx == sequence.size();
    }
}
