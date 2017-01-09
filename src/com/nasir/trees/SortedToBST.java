package com.nasir.trees;

/**
 * Created by nasir on 1/1/17.
 */
public class SortedToBST {

    public static TreeNode root;

    public static class TreeNode{
        TreeNode left,right;
        int data;
        public TreeNode(int data){
            left = right = null;
            this.data = data;
        }

        private void addToLeft(int data){
            TreeNode newNode = new TreeNode(data);
            left = newNode;
        }

        private void addToRight(int data){
            TreeNode newNode = new TreeNode(data);
            right = newNode;
        }
    }

    public static void inorderTraversal(TreeNode node) {
        if(node == null)
            return;

        inorderTraversal(node.left);
        System.out.println(node.data);
        inorderTraversal(node.right);
    }

    public static TreeNode convertToBST(int a[], int start, int end){

        if(start>end) {
            return null;
        }

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(a[mid]);

        node.left = convertToBST(a, start, mid-1);
        node.right = convertToBST(a, mid+1, end);


        return node;
    }

    public static void main(String args[]) {

        int a[] = {1,2,3,4,5};
        TreeNode root = convertToBST(a, 0, a.length-1);

        System.out.println("Printing from Formed BST:");
        inorderTraversal(root);


    }
}
