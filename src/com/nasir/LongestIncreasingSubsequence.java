package com.nasir;

/**
 * Created by NasirAhmed on 03-Oct-16.
 */
public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
       LongestIncreasingSubsequence lsp = new LongestIncreasingSubsequence();
       int a1[] = {7,9,8,4,5,12,14};
       int a2[] = {10, 5, 4, 3};
       System.out.println(lsp.lsDP(a1));
       System.out.println(lsp.lsSumDP(a2));
    }

    public int lsDP(int a[]) {
        int l = 0;
        int[] F = new int[a.length+1];
        for(int i = 0 ;i<a.length; i++) {
          int max = 0;
            for(int j = 0; j < i; j++){
                if(a[j] < a[i])
                    max = Math.max(max, F[j]);
            }
            F[i] = 1 + max;
            l = Math.max(l, F[i]);
        }

        return l;
    }

    public int lsSumDP(int a[]) {
        int l = 0;
        int[] F = new int[a.length+1];
        for(int i = 0 ;i<a.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++){
                if(a[j] < a[i])
                    max = Math.max(max, F[j]);
            }
            F[i] = a[i] + max;
            l = Math.max(l, F[i]);
        }

        return l;
    }
}
