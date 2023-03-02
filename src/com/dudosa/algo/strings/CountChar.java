package com.dudosa.strings.numbers.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountChar {
  public static void main(String[] args) {
      System.out.println(countDuplicateV2("Kigali namahanga mwabantu mwe"));
     }
public Map<Character, Integer> countingDuplicate(String str){
      Map<Character, Integer> resultMap = new HashMap<>();

      for(int i = 0; i < str.length(); i ++){
          char c = str.charAt(i);

          resultMap.compute(c, (k,v) -> (v == null)? 1: v++);
      }
 return  resultMap;
}

public static Map<Character,Long> countDuplicateV2(String str){
      Map<Character,Long> resultMap = str.chars()
              .mapToObj(c -> (char) c)
              .collect(Collectors.groupingBy(c -> c , Collectors.counting()));
      return  resultMap;

}

}
