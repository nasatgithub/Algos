package com.nasir.trees;

import java.util.LinkedList;

/**
 * Created by nasir on 11/12/16.
 */
public class TreeNode {
    public int data;
    public TreeNode left,right;
    public TreeNode parent;
    public int size;

    public TreeNode(int data) {
        left = null;
        right = null;
        this.data = data;
        size = 1;
    }

    public void insertInBST(int newData) {
        if(newData < data) {
            if(left == null) {
                left = new TreeNode(newData);
                left.parent = this;
            }
            else {
                left.insertInBST(newData);
            }
        }
        else {
            if(right == null) {
                right = new TreeNode(newData);
                right.parent = this;
            }
            else {
                right.insertInBST(newData);
            }
        }
    }

    public void insertBT(int newData) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(this);
        while(!q.isEmpty()) {
            TreeNode n = q.removeFirst();
            if(n.left == null) {
                n.left = new TreeNode(newData);
                break;
            }
            else if(n.right == null){
                n.right = new TreeNode(newData);
                break;
            }
            else {
                q.add(n.left);
                q.add(n.right);
            }
        }
    }
}
