package com.nasir;

import java.util.HashSet;

/**
 * Created by NasirAhmed on 04-Aug-16.
 */
public class Isomorphic {
    public static void main(String args[]) {
        String a = "ebgg";
        String b = "addk";
        if (a.length() != b.length()) {
            System.out.println("Not Isomorphic");
        } else {
            if (noOfUniqueChars(a) == noOfUniqueChars(b)) {
                System.out.println("Isomorphic");
            } else {
                System.out.println("Not Isomorphic");
            }
        }
    }

    public static int noOfUniqueChars(String s) {
        HashSet<Character> uniqueChars = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char sI = s.charAt(i);
            if(!uniqueChars.contains(sI)){
                uniqueChars.add(sI);
            }
        }
        return uniqueChars.size();
    }
}
