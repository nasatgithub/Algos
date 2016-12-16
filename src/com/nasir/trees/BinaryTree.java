package com.nasir.trees;

import java.util.Map;

/**
 * Created by NasirAhmed on 13-Oct-16.
 */
class Node1 {
    int data;
    Node1 left,right;
    public Node1(int data) {
        data = this.data;
        left = right = null;
    }
}

public class BinaryTree {


    public static void main(String args[]) {

        Node1 first = new Node1(10);

        Node1 second = new Node1(8);
        first.left = second;

        Node1 third = new Node1(15);
        first.right = third;

        Node1 fourth = new Node1(7);
        second.left = fourth;

        Node1 fifth = new Node1(9);
        fourth.left = fifth;

        System.out.print(isBalanced(first));

    }

    public static int getHeight(Node1 n) {
        if(n == null) return  0;

        else {
            return Math.max(getHeight(n.left),getHeight(n.right))+1;
        }
    }

    public static boolean isBalanced(Node1 n) {

        if(n == null)
            return true;

        int lHeight = getHeight(n.left);
        int rHeight = getHeight(n.right);

        if(Math.abs(lHeight - rHeight) > 1)
            return false;
        else {
            return isBalanced(n.left) && isBalanced(n.right);
        }
    }

}
