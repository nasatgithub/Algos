package com.nasir.SearchAndSort;

/**
 * Created by nasir on 11/12/16.
 */
public class SearchRotatedArray {
    public static void main(String args[]) {
        int a[] = {5,6,7,8,1,3};
        System.out.print(searchRecursive(a, 0,(a.length-1), 1));
    }

    public static int searchRecursive(int[] a, int left, int right, int x) {
        if(left < right) {
            int mid = (left + right) / 2;

            if (x == a[mid]) {
                return mid;
            }

            if(a[left] < a[mid]) {
                if (x >= a[left] && x < a[mid]) {
                    return searchRecursive(a, left, mid - 1, x);
                }
                else {
                    return searchRecursive(a, mid + 1, right, x);
                }
            }

            if(a[mid] < a[right]) {
                if (x > a[mid] && x <= a[right]) {
                    return searchRecursive(a, mid+1, right, x);
                }
                else {
                    return searchRecursive(a, left, mid-1, x);
                }
            }

            if (x > a[mid] && x <= a[right]) {
                return searchRecursive(a, mid+1, right, x);
            }
            else {
                return searchRecursive(a, mid + 1, right, x);
            }


        }

        else {
            return -1;
        }
    }
}
