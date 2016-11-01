package com.nasir;

/**
 * Created by NasirAhmed on 03-Oct-16.
 */
public class QuickSort {

    public static void main(String args[]) {
        int a[] = {3,9,6,10,14};
        QuickSort q = new QuickSort();
        q.quickSort(a, 0, a.length-1);

        for(int val: a) {
            System.out.println(val+" ");
        }
    }

    public static int partition(int a[], int l, int r) {

        int i = l-1;
        int pivot = a[r];
        int temp;
        for(int j=l; j<=r-1; j++) {
            if(a[j] < pivot) {
                i++;
                //swap elements at i and j
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        //now swap element taken as pivot(last element) with the element positioned at pivot point
        temp = a[i+1];
        a[i+1] = pivot;
        a[r] = temp;

        // return the pivot index
        return i+1;
    }

    public void quickSort(int a[], int l, int r){
        if(l<r) {
            int pivotIndex = partition(a, l, r);

            quickSort(a, l, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, r);
        }
    }

}
