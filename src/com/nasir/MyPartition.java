package com.nasir;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NasirAhmed on 29-Sep-16.
 */
public class MyPartition {
    public static void main(String args[]) {
        int[] x = {5, 4, 3, 2, 1};
        int[] xSorted = partition(x);

        for(int v: xSorted)
            System.out.print(v+" ");
    }

    public static int[] partition(int x[]) {
        int xSize = x.length;
        //int biggerArray[] = new int[xSize-1];
        //int smallerArray[] = new int[xSize-1];
        List<Integer> biggerNumbers = new ArrayList<Integer>();
        List<Integer> smallerNumbers = new ArrayList<Integer>();
        int pivot = x[xSize - 1];
        int[] xSorted = new int[xSize];


        // partition elements greater than pivot to bigger array
        // and elements lesser than pivot to smaller array

        for (int i = 0; i < xSize - 1; i++) {
            if (x[i] > pivot)
                biggerNumbers.add(x[i]);
            else
                smallerNumbers.add(x[i]);
        }

        xSorted[smallerNumbers.size()] = pivot;


        int j = 0;

        // moving smallerNumbers to before pivot in SortedArray
        if(smallerNumbers.size() != 0) {
            //store first number from smaller numbers into xSorted
            xSorted[j] = smallerNumbers.get(0);

            for (int i = 1; i < smallerNumbers.size(); i++) {
                if (smallerNumbers.get(i) < xSorted[j]) {
                    int temp = xSorted[j];
                    xSorted[j] = smallerNumbers.get(i);
                    xSorted[j + 1] = temp;
                } else
                    xSorted[j + 1] = smallerNumbers.get(i);
                j++;
            }

            // to move to the index to pivot point
            j++;
        }

        // moving biggerNumbers after pivot in SortedArray
        if(biggerNumbers.size() != 0) {

            // to move the current index to after pivot
            j++;
            xSorted[j] = biggerNumbers.get(0);
            for (int i = 1; i < biggerNumbers.size(); i++) {
                if (biggerNumbers.get(i) < xSorted[j]) {
                    int temp = xSorted[j];
                    xSorted[j] = biggerNumbers.get(i);
                    xSorted[j + 1] = temp;
                } else
                    xSorted[j + 1] = biggerNumbers.get(i);
                j++;
            }
        }


        return  xSorted;

    }

}
