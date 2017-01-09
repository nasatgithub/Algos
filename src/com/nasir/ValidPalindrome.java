package com.nasir;

import java.util.HashSet;

/**
 * Created by nasir on 12/31/16.
 */
public class ValidPalindrome {
    public static HashSet<Character> validChars;
    public static void main(String args[]) {
        validChars = new HashSet<>();
        String s = "abc :== :cbal";
        for(char i='a';i<='z';i++)
            validChars.add(i);
        for(char i='0';i<='9';i++)
            validChars.add(i);

        Boolean validPalindrome = isValidPalindrome(s);
        System.out.println(validPalindrome);
    }

    public static boolean isValidPalindrome(String s) {
        int i,j;
        i = 0;
        j = s.length()-1;
        while(i<j) {
            char ci = Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
            if(!validChars.contains(ci)) {
                i++;
                continue;
            }
            if(!validChars.contains(cj)) {
                j--;
                continue;
            }

            if(ci != cj)
                return false;

            i++;
            j--;
        }

        return true;
    }
}
