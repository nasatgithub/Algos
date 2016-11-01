package com.nasir;

import java.util.Scanner;

/**
 * Created by NasirAhmed on 09-Sep-16.
 */
public class SelectionSort {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n ; i++) {
            a[i] = scan.nextInt();
        }

        int aSorted[] = selectionSort(a);

        for(int i = 0 ; i < aSorted.length; i++) {
            System.out.print(aSorted[i]+"\t");
        }
    }

    public static int[] selectionSort(int a[]) {
            for(int i = 0 ; i<a.length; i++) {
                selectSort(i, a);
            }
            return a;
    }

    public static void selectSort(int start, int a[]) {
        int minPos = findMinPosInArray(start, a);
        if(minPos!=start)
            swapMinWithFirst(start,minPos, a);
    }

    public static int findMinPosInArray(int start, int a[]) {
        int minPos = start;
        for(int j = start+1; j< a.length; j++) {
            if(a[j] < a[minPos]) {
                minPos = j;
            }
        }
        return minPos;
    }

    public static void swapMinWithFirst(int start, int minPos, int a[]) {
        int temp = a[minPos];
        a[minPos] = a[start];
        a[start] = temp;
    }

}
