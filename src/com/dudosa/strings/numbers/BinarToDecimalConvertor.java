package com.dudosa.strings.numbers;

public class BinarToDecimalConvertor {
    public static void main(String[] args) {
        System.out.println(binaryToDecimalConvertor("111"));
    }
    public static int binaryToDecimalConvertor(String binary){
        int conversion = 1;
        int result =0;

        for(int i =1; i <= binary.length(); i++ ){
            if(binary.charAt(binary.length()-i)=='1'){
                result += conversion;
            }
            conversion *=2;
        }
        return result;
    }
}
