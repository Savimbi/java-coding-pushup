package com.dudosa.strings.numbers;

public class OctalToDecimalConverter {
    public static void main(String[] args) {
        System.out.println(convertOctalToDecimal("124"));
    }

    public static int convertOctalToDecimal(String octal){
        int conversion = 1;
        int result =0;

        for (int i = octal.length(); i > 0; i--){
            int num = Integer.parseInt(octal.charAt(i-1)+"");
            result += num*conversion;
            conversion *=8;
        }
        return result;
    }
}
