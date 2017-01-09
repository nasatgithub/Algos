package com.nasir.SearchAndSort;

import java.util.PriorityQueue;

/**
 * Created by nasir on 12/31/16.
 */
public class KthLargest1 {

    public static void main(String args[]) {
        int a[] = {3,2,1,5,6,4};
        int kthL = findKthLargest(a,4);

        System.out.println(kthL);
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }
}
