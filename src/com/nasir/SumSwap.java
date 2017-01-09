package com.nasir;

import java.util.HashSet;

/**
 * Created by nasir on 1/6/17.
 */
public class SumSwap {

    public static void main(String args[]) {
        SumSwap ss = new SumSwap();
        int a[] = {4, 1, 2, 1, 1, 2};
        int b[] = {3, 6, 3, 3};
        ss.sumSwap(a,b);
    }

    public void sumSwap(int a[], int b[]) {

        int sum = Math.abs(sumArray(a) - sumArray(b));
        HashSet<Integer> set = new HashSet<>();

        for(int v: b) {
            set.add(v);
        }

        for(int v: a) {
            int findVal = Math.abs(sum - v);
            if(set.contains(findVal)){
                System.out.println("{"+v+","+findVal+"}");

            }

        }

    }

    public int sumArray(int a[]) {
        int sumArr = 0;
        for(int i: a) {
            sumArr += i;
        }
        return sumArr;
    }
}
