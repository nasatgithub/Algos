package com.nasir.tests;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collector;

/**
 * Created by nasir on 11/22/16.
 */
public class Solution1 {
    public static void main(String args[]) {

      System.out.println(isPermutation("abc", "cab"));

    }

    public static boolean isPermutation(String a, String b) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<a.length(); i++) {
            char c = a.charAt(i);
            if(!map.containsKey(a.charAt(i))) {
                map.put(c, 1);
            }
            else {
                map.put(c,map.get(c)+1);
            }
        }

        for(int i = 0; i<b.length(); i++) {
            char c = b.charAt(i);
            if(!map.containsKey(b.charAt(i))) {
                map.put(c, 1);
            }
            else {
                map.put(c,map.get(c)-1);
            }
        }

        for(Character c: map.keySet()) {
            if(map.get(c)!=0) {
                return false;
            }
        }

        return true;

    }
}
