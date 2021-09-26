package com.dudosa.strings.numbers;

import java.util.ArrayList;
import java.util.List;

public class ExtractInteger {

    public static void main(String[] args) {
        System.out.println("The result is: "+extract("cv dd 4 k 2321 2 11 k4k2 66 4d"));
    }
    public static List<Integer> extract(String str){
        List<Integer> result = new ArrayList<>();

        StringBuilder temp = new StringBuilder(String.valueOf(Integer.MAX_VALUE).length());
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isDigit(ch)){
                temp.append(ch);
            } else {
                if (temp.length() > 0){
                    result.add(Integer.parseInt(temp.toString()));
                    temp.delete(0,temp.length());
                }
            }
        }
        return result;
    }
}
