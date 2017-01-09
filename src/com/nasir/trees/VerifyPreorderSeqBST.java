package com.nasir.trees;

import java.util.Stack;

/**
 * Created by nasir on 1/3/17.
 */
public class VerifyPreorderSeqBST {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < max) {
                return false;
            }

            while (!stack.isEmpty() && num > stack.peek()) {
                max = stack.pop();
            }

            stack.push(num);
        }

        return true;
    }

    public static void main(String args[]) {
        int preorder[] = {6,2,7,9,1};
        VerifyPreorderSeqBST v = new VerifyPreorderSeqBST();
        boolean valid = v.verifyPreorder(preorder);

        System.out.println(valid);
    }
}
