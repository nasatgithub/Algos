package com.nasir;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by nasir on 12/26/16.
 */
public class MyFlipGame {

    public static void main(String args[]) {

        String s = "-+-++--++++--+";
        System.out.println(flipGame(s));
    }

    public static List<String> flipGame(String s) {
        HashSet<Integer> pos = new HashSet<>();
        List<String> result = new ArrayList<>();
        StringBuffer buf = new StringBuffer("");
        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == '+' && (i+1) < s.length() && s.charAt(i+1) == '+') {
                 result.add(s.substring(0, i)+"--"+s.substring(i+2));
            }
        }

        return result;
    }
}
