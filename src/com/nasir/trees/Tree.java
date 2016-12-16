package com.nasir.trees;

import java.util.TreeMap;

/**
 * Created by nasir on 11/12/16.
 */
public class Tree {


    public void printInOrder(TreeNode n) {
        if(n == null)
            return;
        printInOrder(n.left);
        System.out.print(n.data);
        printInOrder(n.right);

    }

    public static void main(String args[]) {
        Tree t = new Tree();
        TreeNode n = new TreeNode(7);
        int a[] = {1,5,6,3,4,2};
        for(int i: a) {
           n.insertInBST(i);
        }

        t.printInOrder(n);

        System.out.println();

        TreeNode n2 = new TreeNode(1);
        int b[] = {2,3,4,5,6};
        for(int i: b) {
           n2.insertBT(i);
        }

        t.printInOrder(n2);
    }
}
