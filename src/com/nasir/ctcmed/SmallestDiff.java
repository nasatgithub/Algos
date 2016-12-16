package com.nasir.ctcmed;

import java.util.HashSet;

/**
 * Created by nasir on 12/1/16.
 */
public class SmallestDiff {

    public static void main(String args[]) {

        int a[] = {3,1,9,7,5,2};
        int b[] = {11,10,13,20,4,6,14};

        System.out.print("Smallest Difference : "+ findSmallestDiff(a,b));


    }

    public static int findSmallestDiff(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int vB: b)
            set.add(vB);

        int c = 0;
        while(true) {

            for (int v : a) {
                int sum = Math.abs(v+c);
                int diff = Math.abs(v-c);
                if(set.contains(sum) || set.contains(diff))
                    return c;
            }
            c++;
        }

    }
}
