package com.dudosa.strings.numbers;

/**
 * Consider two given strings, q and p. Write a snippet of code
 * that determines whether we can obtain two identical strings
 * by performing a single edit in q or p. More precisely, we can insert,
 * remove, or replace a single character in q or in p, and q will become equal to p
 */
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println("Could we change one char to have the same string from 'tank' and 'tanck'? "+isOneEditAway("tank","tanck"));
    }

    public static boolean isOneEditAway(String q, String p){
        //Check if the difference between the string is bigger than 1
        if(Math.abs(q.length()-p.length()) > 1){
            return false;
        }

        //get shorter and longer string
        String shorter = q.length() < p.length() ? q : p;
        String longer = p.length() < q.length() ? p : q;

        int is = 0;
        int il = 0;

        boolean maker = false;

        while(is < shorter.length() && il<longer.length()){
            if(shorter.charAt(is) != longer.charAt(il)){
                // 1st difference if found
                if(maker){
                    return false;
                }
                maker = true;
                if(shorter.length() == longer.length()){
                    is++;
                }
            }else {
                is++;
            }
            il++;
        }
        return true;
    }
}
