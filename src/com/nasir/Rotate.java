package com.nasir;

import java.util.Scanner;

public class Rotate {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello");
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int n = a.length;
        int order = new Scanner(System.in).nextInt();
        int splitIndex = a.length - order - 1;

        simpleReverse(a, 0, splitIndex);
        simpleReverse(a, splitIndex + 1, a.length - 1);
        simpleReverse(a, 0, a.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public static void simpleReverse(int a[], int start, int end) {
        int left = start;
        int right = end;
        int temp;
        while (left < right) {
            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}
