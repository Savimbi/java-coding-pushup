package com.dudosa.strings.numbers.number;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class arithmetics {

    public static void main(String[] args) {
        Integer[] input = {1, 1, 1, 1, 5, 10, 20, 50};
        System.out.println(toHex(77));
    }

    static int calc(int m, int n) {
        return (((m * n)) / 2) % 7;
    }

    static Map<ReturnCode, Integer> calSumAndCountAllNumbersDivBy_2_Or_7(final int max) {
        int count = 0;
        int sum = 0;

        for (int i = 1; i < max; i++) {
            boolean isDivisibleBy2Or7 = i % 2 == 0 || i % 7 == 0;
            if (isDivisibleBy2Or7) {
                count++;
                sum += i;
            }
        }
        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        return Map.of(ReturnCode.SUM, sum, ReturnCode.COUNT, count);
    }

    boolean isEven(int number) {
        return number % 2 == 0;
    }

    boolean isOdd(int number) {
        return number % 2 != 0;
    }

    static String numberAsText(int n) {
        String value = "";
        int remainingValue = n;
        while (remainingValue > 0) {
            String remainderAsText = digitAsText(remainingValue % 10);
            value = remainderAsText + " " + value;
            remainingValue /= 10;
        }
        return value.trim();
    }

    static String digitAsText(int n) {
        Map<Integer, String> valueToTextMap = Map.of(0, "ZERO", 1, "ONE", 2, "TWO",
                3, "THREE", 4, "FOUR", 5, "FIVE", 6, "SIX", 7, "SEVEN",
                8, "EIGHT", 9, "NINE");
        return valueToTextMap.get(n % 10);
    }

    static boolean isPerfectNumber(int num) {
        int sumOfMultipliers = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sumOfMultipliers += i;
            }
        }
        return sumOfMultipliers == num;
    }

    static List<Integer> calcPerfectNumbers(int maxExclusive) {
        List<Integer> results = new ArrayList<>();

        for (int i = 2; i < maxExclusive; i++) {
            if (isPerfectNumber(i)) {
                results.add(i);
            }
        }
        return results;
    }

    static List<Integer> calcPrimesUpTo(int max) {
        boolean[] isPotentialPrime = new boolean[max + 1];
        Arrays.fill(isPotentialPrime, true);

        for (int i = 2; i <= max / 2; i++) {
            if (isPotentialPrime[i]) {
                eraseMultipleOfCurrent(isPotentialPrime, i);
            }
        }
        return buildPrimeList(isPotentialPrime);
    }

    private static List<Integer> buildPrimeList(boolean[] isPotentialPrime) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPotentialPrime.length; i++) {
            if (isPotentialPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static void eraseMultipleOfCurrent(boolean[] values, int i) {
        for (int n = i + i; n < values.length; n = n + i) {
            values[n] = false;
        }
    }

    // Prime number pairs method
    // Start
    static void calcPrimesPairs(int maxValue) {
        Map<Integer, Integer> twinPairs = calcPair(maxValue, 2);
        Map<Integer, Integer> cousinsPairs = calcPair(maxValue, 4);
        Map<Integer, Integer> sexyPairs = calcPair(maxValue, 6);

        System.out.println("Twins: " + twinPairs);
        System.out.println("Cousins: " + cousinsPairs);
        System.out.println("Sexy: " + sexyPairs);

    }

    // helper method
    private static Map<Integer, Integer> calcPair(int maxValue, int distance) {
        List<Integer> primes = calcPrimesUpTo(maxValue);
        Map<Integer, Integer> resulPairs = new TreeMap<>();
        for (int i = 1; i < maxValue; i++) {
            if (isPrime(primes, i) && isPrime(primes, i + distance)) {
                resulPairs.put(i, i + distance);
            }
        }
        return resulPairs;
    }

    // helper method
    static boolean isPrime(List<Integer> primes, int n) {
        return primes.contains(n);
    }
    // end Prime number pairs method

    // Checksum function
    static int calcChecksum(String input) {

        int crc = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                int pos = i + 1;
                int value = (currentChar - '0') * pos;
                crc += value;
            } else {
                throw new IllegalArgumentException("Illegal character: " + currentChar);
            }
        }
        return crc % 10;
    }
    // end checksum

    //Decimal to Roman numbers eg(17 = XVII)
    static int fromRomanToDecimal(String roman) {
        int value = 0;
        int lastDigitalValue = 0;
        Map<Character, Integer> valueMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 100);

        for (int i = roman.length() - 1; i >= 0; i--) {
            char romanDigital = roman.charAt(i);
            int digitalValue = valueMap.getOrDefault(romanDigital, 0);
            boolean addMode = digitalValue >= lastDigitalValue;
            if (addMode) {
                value += digitalValue;
                lastDigitalValue = digitalValue;
            } else {
                value -= digitalValue;
            }
        }
        return value;
    }
    // end

    static String checkSumPair(int[] arr, int sum) {
        //Set<Integer> element = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sumNum = arr[i] + arr[j];
                if (sumNum == sum) {
                    return "True";
                }
            }
        }
        return "False";
    }

    // Decimal number to roman
    static String toRomanNumber(int value) {
        String result = "";
        int remainder = value;
        Map<Integer, String> decimalRomanMap = Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100,
                "C", 500, "D", 1000, "M");
        Comparator<Integer> reverse = Comparator.reverseOrder();
        Map<Integer, String> sortedDecimalRoman = new TreeMap<>(reverse);

        sortedDecimalRoman.putAll(decimalRomanMap);
        var it = sortedDecimalRoman.entrySet().iterator();
        while (it.hasNext() && remainder > 0) {
            Map.Entry<Integer, String> entry = it.next();
            int multiplier = entry.getKey();
            String romanDig = entry.getValue();
            if (remainder >= 900 && romanDig == "D") {
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
        for (int i = 0; i < times; i++) {
            result.append(romanDig);
        }
        return result.toString();
    }
    // end decimal to roman

    //display c^2 = a^2 + b^2
    static void quadraticEquation() {
        for (int a = 0; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                int inSqrt = (a * a) + (b * b);
                int c = (int) Math.sqrt(inSqrt);
                if (c < 100 && c * c == inSqrt) {
                    System.out.println("a = " + a + " / b = " + b + " / c = " + c);
                }
            }
        }
    }

    static int[] maxCounter(int size, int[] arr) {
        int[] counters = new int[size];
        Arrays.fill(counters, 0);
        int startLine = 0;
        int maxCounter = 0;

        for (int i : arr) {
            int idx = i - 1;
            if (i > size) {
                startLine = maxCounter;
            } else if (counters[idx] < startLine) {
                counters[idx] = startLine + 1;
            } else {
                counters[idx] += 1;
            }
            if (i <= size && counters[idx] > maxCounter) maxCounter = counters[idx];

        }
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < startLine) counters[i] = startLine;
        }
        return counters;
    }

    // O(n) time "one for loop"| O(1) space
    static int solution(int[] A) {
        long actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }
        long maxValue = A.length + 1;
        long expected = maxValue * (maxValue + 1) / 2;
        return (int) (expected - actualSum);

    }

    //O(n) time "for loop" | O(1) time: no more memory needed
    static int equilibrium(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;
        for (int x : A) rightSum += x;
        rightSum -= leftSum;
        int minDiff = Math.abs(leftSum - rightSum);
        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            int currentDiff = Math.abs(rightSum - leftSum);
            if (minDiff > currentDiff) minDiff = currentDiff;

        }
        return minDiff;
    }

    //O(n) time | O(n) space
    static int[] cyclicRotation(int[] array, int rotation) {
        int len = array.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int newIdx = (i + rotation) % len;
            result[newIdx] = array[i];
        }

        return result;
    }

    //O(n^3) time | O(1) space
    static void solveCubicEq() {
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                for (int c = 1; c < 100; c++) {
                    int value = a * a + b * b - c * c;
                    if (value > 0) {
                        int d = (int) Math.sqrt(value);
                        if (d < 100 && a * a + b * b == c * c + d * d) {
                            System.out.println("a= " + a + "/b= " + b + "/c= " + c + "/d= " + d);
                        }
                    }
                }
            }
        }
    }

    //Armstrong numbers O(n^3) time | O(1) space
    static List<Integer> calcArmstrongNumbers() {
        List<Integer> results = new ArrayList<>();
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                for (int z = 1; z < 10; z++) {
                    int numeric = 100 * x + 10 * y + z;
                    int cubicValue = (int) (Math.pow(x, 3)
                            + Math.pow(y, 3)
                            + Math.pow(z, 3));
                    if (numeric == cubicValue) {
                        results.add(numeric);
                    }
                }
            }
        }
        return results;
    }

    static int calcMaxChange(List<Integer> value) {
        List<Integer> sortedNumbers = new ArrayList<>(value);
        sortedNumbers.sort(Integer::compareTo);

        int maxChange = 0;
        for (int number : sortedNumbers) {
            if (number > maxChange + 1)
                break;
            maxChange += number;
        }

        return maxChange;
    }
    static Map<Integer,Integer> calcFriends(int max){
        Map<Integer,Integer> friends = new TreeMap<>();
        for(int number=2; number< max; number++){
            List<Integer> divisor1 = findProperDivisors(number);
            int sumDiv1 = sum(divisor1);
            List<Integer> divisor2 = findProperDivisors(sumDiv1);
            int sumDiv2 = sum(divisor2);
            if(number == sumDiv2 && sumDiv1 != sumDiv2){
                friends.put(number, sumDiv1);
            }
        }
        return friends;
    }

    private static List<Integer> findProperDivisors(int value) {
        final List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= value / 2; i++) {
            if (value % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    private static Integer sum(List<Integer> values) {
       return values.stream().mapToInt(n -> n).sum();
    }


    static String toBinary(int value){
        if(value < 0)
            throw new IllegalArgumentException("The value must be greater than 0");
        if(value <= 1){
            return String.valueOf(value);
        }
        int lastDigit = value % 2;
        int remainder = value / 2;
        return toBinary(remainder) + lastDigit;
    }

    static String toHex(int value){
        if(value<0){
            throw  new IllegalArgumentException("Value should be greater the 0");
        }
        if(value <= 15){
            return asHexDigit(value);
        }
        int lastDig = value % 16;
        int remainder = value / 16;
        return toHex(remainder)+asHexDigit(lastDig);
    }

    private static String asHexDigit(int value) {
        if(value <= 15){
            char hexDig = "0123456789ABCDEF".charAt(value);
            return String.valueOf(hexDig);
        }
        throw new IllegalArgumentException("The value is not in range[0-15]");
    }

    enum ReturnCode {SUM, COUNT}
}
