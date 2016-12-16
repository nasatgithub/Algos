package com.nasir.SearchAndSort;

/**
 * Created by nasir on 11/23/16.
 */
public class SubSort {

    public static void main(String args[]) {
       int a[] = {1,2,4,7,10,11,7,12,6,7,16,18,19};
       getSubIndex(a);

    }

    public static void getSubIndex(int a[]) {

        int left_end, right_start;

        left_end = findLeftSubsequence(a);
        right_start = findRightSubsequence(a);

       // System.out.println(left_end + " "+ right_start);

        int min_mid_right = right_start;
        int max_left_mid = left_end;

        for(int i = left_end+1; i<right_start; i++) {
            if(a[i] < a[min_mid_right]) min_mid_right = i;
            if(a[i] > a[max_left_mid]) max_left_mid = i;
        }

        int left_end_valid = findValidLeftEnd(a, left_end, min_mid_right);
        int right_end_valid = findValidRightStart(a, right_start, max_left_mid);

        System.out.println("Indexes : "+(left_end_valid+1)+ "  "+(right_end_valid-1));

        int minLen = (right_end_valid-1) - (left_end_valid+1) + 1;
        System.out.println("Min Len : "+ minLen);

    }

    public static int findLeftSubsequence(int a[]) {
           int i;
           for(i = 0; i < a.length; i++) {
               if(a[i+1] < a[i])
                   return i;
           }

        return i-1;
    }

    public static int findRightSubsequence(int a[]) {
          int i;
          for(i = a.length - 1; i >= 0; i--) {
              if(a[i-1] > a[i])
                  return i;
          }

        return 0;
    }

    public static int findValidLeftEnd(int a[], int left_end, int min_mid_right) {
         for(int i = left_end; i >= 0; i--) {
             if(a[min_mid_right] > a[i])
                 return i;
         }

        return 0;
    }

    public static int findValidRightStart(int a[], int right_start, int max_left_mid) {
        for(int i = right_start; i <a.length; i++) {
            if(a[i] > max_left_mid)
                return i;
        }

        return a.length-1 ;
    }


}
