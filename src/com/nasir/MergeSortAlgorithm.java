package com.nasir;

/**
 * Created by NasirAhmed on 28-Sep-16.
 */
public class MergeSortAlgorithm {

    public static void main(String args[]) {
        int a[] = {9, 13, 4, 3, 25, 5, 2, 1, 5};
        mergeSort(a, 0, a.length - 1);

        for(int v: a) {
            System.out.print(v+" - ");
        }
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(int a[], int l, int m, int r) {
        //size of first half
        int lSize = m - l + 1;
        int rSize = r - m;

        //create 2 Temp arrays
        int[] Left = new int[lSize];
        int[] Right = new int[rSize];

        // copy the two halves into the 2 Temp arrays
        for (int i = 0; i < lSize; i++)
            Left[i] = a[l + i];
        for (int i = 0; i < rSize; i++)
            Right[i] = a[m+1+i];


        // perform comparison between Left and Right, and move
        // the smallest to the actual array a starting at l;

        int i,j,k;
        i=j=0;
        k=l;
        while(i<lSize && j<rSize) {
           if(Left[i] <= Right[j]) {
                a[k++] = Left[i++];
           }
           else {
                a[k++] = Right[j++];
           }
        }

        // once all the smallest from the 2 temp arrays are moved
        // the remaining elements in one of the Left or Right should be
        // moved to the actual array

        while(i<lSize)
            a[k++] = Left[i++];
        while(j<rSize)
            a[k++] = Right[j++];
    }

}
