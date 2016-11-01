package com.nasir.trees;

import java.util.Map;

/**
 * Created by NasirAhmed on 13-Oct-16.
 */
class Node {
    int data;
    Node left,right;
    public Node(int data) {
        data = this.data;
        left = right = null;
    }
}

public class BinaryTree {


    public static void main(String args[]) {

        Node first = new Node(10);

        Node second = new Node(8);
        first.left = second;

        Node third = new Node(15);
        first.right = third;

        Node fourth = new Node(7);
        second.left = fourth;

        Node fifth = new Node(9);
        fourth.left = fifth;

        System.out.print(isBalanced(first));

    }

    public static int getHeight(Node n) {
        if(n == null) return  0;

        else {
            return Math.max(getHeight(n.left),getHeight(n.right))+1;
        }
    }

    public static boolean isBalanced(Node n) {

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
