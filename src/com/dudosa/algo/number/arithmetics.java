package com.dudosa.strings.numbers.number;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class arithmetics {

    public static void main(String[] args) {
        int[] input = {2,4,3,6,7,4};
        quadraticEquation();
//        System.out.println(toRomanNumber(2020));
    }

    static int calc(int m, int n){
        return (((m*n))/2)%7;
    }

    static Map<ReturnCode, Integer> calSumAndCountAllNumbersDivBy_2_Or_7(final int max){
        int count=0;
        int sum = 0;

        for (int i = 1; i < max; i ++){
            boolean isDivisibleBy2Or7 = i % 2 == 0 || i % 7 == 0;
            if(isDivisibleBy2Or7){
                count ++;
                sum +=i;
            }
        }
        System.out.println("Count: "+count);
        System.out.println("Sum: "+sum);
        return Map.of(ReturnCode.SUM, sum, ReturnCode.COUNT,count);
    }

    boolean isEven(int number){
        return number % 2 == 0;
    }
    boolean isOdd(int number){
        return number % 2 != 0;
    }
     static String numberAsText(int n){
        String value = "";
        int remainingValue = n;
        while (remainingValue > 0){
            String remainderAsText = digitAsText(remainingValue % 10);
            value = remainderAsText+" "+value;
            remainingValue /= 10;
        }
        return value.trim();
    }
    static String digitAsText(int n){
        Map<Integer, String> valueToTextMap = Map.of(0,"ZERO",1,"ONE", 2,"TWO",
                3,"THREE",4,"FOUR", 5,"FIVE", 6,"SIX", 7, "SEVEN",
                8,"EIGHT", 9,"NINE");
        return valueToTextMap.get(n%10);
    }

    static boolean isPerfectNumber(int num){
        int sumOfMultipliers = 1;
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0){
                sumOfMultipliers += i;
            }
        }
        return sumOfMultipliers == num;
    }

    static List<Integer> calcPerfectNumbers(int maxExclusive){
        List<Integer> results = new ArrayList<>();

        for (int i = 2; i < maxExclusive; i++){
            if(isPerfectNumber(i)){
                results.add(i);
            }
        }
        return results;
    }

    static List<Integer> calcPrimesUpTo(int max){
        boolean[] isPotentialPrime = new boolean[max+1];
        Arrays.fill(isPotentialPrime,true);

        for(int i = 2; i <= max/2; i++){
            if(isPotentialPrime[i]){
                eraseMultipleOfCurrent(isPotentialPrime,i);
            }
        }
        return buildPrimeList(isPotentialPrime);
    }

    private static List<Integer> buildPrimeList(boolean[] isPotentialPrime) {
        List<Integer> primes = new ArrayList<>();
        for (int i= 2; i < isPotentialPrime.length; i ++){
            if(isPotentialPrime[i]){
                primes.add(i);
            }
        }
        return primes;
    }

    private static void eraseMultipleOfCurrent(boolean[] values, int i) {
        for(int n = i+i; n < values.length; n = n + i){
            values[n] = false;
        }
    }

    // Prime number pairs method
    // Start
    static void calcPrimesPairs(int maxValue){
        Map<Integer,Integer> twinPairs = calcPair(maxValue, 2);
        Map<Integer,Integer> cousinsPairs = calcPair(maxValue, 4);
        Map<Integer,Integer> sexyPairs = calcPair(maxValue, 6);

        System.out.println("Twins: "+twinPairs);
        System.out.println("Cousins: "+cousinsPairs);
        System.out.println("Sexy: "+sexyPairs);

    }

    // helper method
    private static Map<Integer, Integer> calcPair(int maxValue, int distance) {
        List<Integer> primes = calcPrimesUpTo(maxValue);
        Map<Integer, Integer> resulPairs = new TreeMap<>();
        for(int i = 1; i <maxValue ; i++){
            if(isPrime(primes,i) && isPrime(primes, i+distance)){
                resulPairs.put(i,i+distance);
            }
        }
        return resulPairs;
    }

    // helper method
    static boolean isPrime(List<Integer> primes, int n){
        return primes.contains(n);
    }
  // end Prime number pairs method

    // Checksum function
    static int calcChecksum(String input){

        int crc = 0;
        for(int i = 0; i < input.length(); i ++){
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)){
                int pos = i + 1;
                int value = (currentChar - '0') * pos;
                crc += value;
            }
            else {
                throw new IllegalArgumentException("Illegal character: "+ currentChar);
            }
        }
        return  crc % 10;
    }
    // end checksum

    //Decimal to Roman numbers eg(17 = XVII)
    static int fromRomanToDecimal(String roman){
        int value = 0;
        int lastDigitalValue = 0;
        Map<Character,Integer> valueMap = Map.of('I',1,'V',5,'X',10,'L',50,'C',100, 'D', 500,'M',100 );

        for(int i = roman.length() - 1; i >= 0; i--){
            char romanDigital = roman.charAt(i);
            int digitalValue = valueMap.getOrDefault(romanDigital,0);
            boolean addMode = digitalValue >= lastDigitalValue;
            if(addMode){
                value += digitalValue;
                lastDigitalValue = digitalValue;
            }
            else {
                value -= digitalValue;
            }
        }
        return value;
    }
    // end

    static String checkSumPair(int[] arr, int sum){
        //Set<Integer> element = new HashSet<>();
        for (int i = 0; i < arr.length -1; i++){
            for(int j = i + 1; j < arr.length; j++){
                int sumNum = arr[i] + arr[j];
                if(sumNum == sum){
                    return "True";
                }
            }
        }
        return "False";
    }

    // Decimal number to roman
 static String toRomanNumber(int value){
        String result = "";
        int remainder = value;
     Map<Integer, String> decimalRomanMap = Map.of(1,"I",5,"V", 10,"X", 50,"L", 100,
             "C", 500,"D",1000,"M");
        Comparator<Integer> reverse = Comparator.reverseOrder();
        Map<Integer,String> sortedDecimalRoman = new TreeMap<>(reverse);

     sortedDecimalRoman.putAll(decimalRomanMap);
     var it = sortedDecimalRoman.entrySet().iterator();
     while(it.hasNext() && remainder > 0){
        Map.Entry<Integer,String> entry = it.next();
        int multiplier = entry.getKey();
        String romanDig = entry.getValue();
        if(remainder >= 900 && romanDig =="D"){
            result += "CM";
            remainder -= 900;
        } else if (remainder >= 4 && romanDig == "I") {
            result += "IV";
            remainder -= 4;
            
        } else {
            int times = remainder / multiplier;
            remainder = remainder % multiplier;
            result += repeatCharSequence(romanDig, times);
        }

     }
     return result;
 }

    private static String repeatCharSequence(String romanDig, int times) {
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < times; i++){
            result.append(romanDig);
        }
        return result.toString();
    }
 // end decimal to roman

    //display c^2 = a^2 + b^2
    static void  quadraticEquation(){
        for(int a = 0; a < 100; a ++){
            for(int b = 1; b < 100; b++){
                int inSqrt = (a*a) + (b*b);
                int c = (int) Math.sqrt(inSqrt);
                if(c < 100 && c * c == inSqrt){
                    System.out.println("a = " + a + " / b = " + b + " / c = " + c);
                }
            }
        }
    }

    enum ReturnCode{SUM,COUNT}
}
