package com.nasir.javaconcepts_package1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by nasir on 11/10/16.
 */
public class General {
public static void main(String args[]) {
    LinkedList<Integer> l = new LinkedList<>();
    ArrayList<LinkedList<Integer>> a = new ArrayList<>();
    a.add(l);
    for(LinkedList<Integer> l1: a) {
        System.out.print(l1);
    }
    l.add(2);
    l.add(3);
    System.out.println(l);


    String s1 = "abc";
    String s2 = "ab";

    System.out.println(s2.compareTo(s1));

    int n = swapDigit(8951);
    System.out.println(n);

    testLinkedHashMap();

    int num = -5;
    System.out.println("bit : "+flip(num));
}

    public static int swapDigit(int number) {

          String nS = String.valueOf(number);

          return Integer.parseInt(String.valueOf(nS.charAt(nS.length()-1)));

    }

    public static void testLinkedHashMap(){
        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        lhm.put(1, 10);
        lhm.put(2, 20);
        lhm.put(3, 30);

        for(int i: lhm.keySet())
            System.out.print(lhm.get(i) + " ");
    }

    public static int flip(int a) {
        return ((a >> 31) & 0x1);
    }


}
