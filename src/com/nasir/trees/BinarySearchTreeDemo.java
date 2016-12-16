package com.nasir.trees;

/**
 /**
 * Represents a node in the Binary Search Tree.
 */
class Node {
  //The value present in the node.
  public int value;

  //The reference to the left subtree.
  public Node left;

  //The reference to the right subtree.
  public Node right;

  // The reference to the parent.
  public Node parent;
  public Node(int value) {
    this.value = value;
  }

}

/**
 * Represents the Binary Search Tree.
 */
class BinarySearchTree {

  //Refrence for the root of the tree.
  public Node root;

  public BinarySearchTree insert(int value) {
    Node node = new Node(value);

    if (root == null) {
      root = node;
      return this;
    }

    insertRec(root, node);
    return this;
  }

  private void insertRec(Node latestRoot, Node node) {

    if (latestRoot.value > node.value) {

      if (latestRoot.left == null) {
        latestRoot.left = node;
        node.parent=latestRoot;
        return;
      } else {
        insertRec(latestRoot.left, node);
      }
    } else {
      if (latestRoot.right == null) {
        latestRoot.right = node;
        node.parent=latestRoot;
        return;
      } else {
        insertRec(latestRoot.right, node);
      }
    }
  }

  /**
   * Returns the minimum value in the Binary Search Tree.
   */
  public int findMinimum() {
    if (root == null) {
      return 0;
    }
    Node currNode = root;
    while (currNode.left != null) {
      currNode = currNode.left;
    }
    return currNode.value;
  }

  /**
   * Returns the maximum value in the Binary Search Tree
   */
  public int findMaximum() {
    if (root == null) {
      return 0;
    }

    Node currNode = root;
    while (currNode.right != null) {
      currNode = currNode.right;
    }
    return currNode.value;
  }
  
  /**
   * Returns the 2nd minimum value in the Binary Search Tree.
   */
  public int find2ndMinimum() {
    if (root == null) {
      return 0;
    }
    Node currNode = root;
    while (currNode.left.left != null) {
      currNode = currNode.left;
    }
    return currNode.value;
  }
  
  /**
   * Returns the 2nd minimum value in the Binary Search Tree.
   */
  public int find2ndMaximum() {
    if (root == null) {
      return 0;
    }
    Node currNode = root;
    while (currNode.right.right != null) {
      currNode = currNode.right;
    }
    return currNode.value;
  }

  /**
   * Printing the contents of the tree in an inorder way.
   */
  public void printInorder() {
    printInOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in an inorder way
   */
  private void printInOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    printInOrderRec(currRoot.left);
    System.out.print(currRoot.value + ", ");
    printInOrderRec(currRoot.right);
  }

  /**
   * Printing the contents of the tree in a Preorder way.
   */
  public void printPreorder() {
    printPreOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in a Preorder way
   */
  private void printPreOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    System.out.print(currRoot.value + ", ");
    printPreOrderRec(currRoot.left);
    printPreOrderRec(currRoot.right);
  }

  /**
   * Printing the contents of the tree in a Postorder way.
   */
  public void printPostorder() {
    printPostOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in a Postorder way
   */
  private void printPostOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    printPostOrderRec(currRoot.left);
    printPostOrderRec(currRoot.right);
    System.out.print(currRoot.value + ", ");

  }
  // Method to obtain a node that has the given value
  public Node findNode(Node latestRoot,int value){
	  if(latestRoot==null)
		  return null;
	  else if(latestRoot.value==value)
		  return latestRoot;
	  else if(value<=latestRoot.value)
		  return findNode(latestRoot.left,value);
	  else 
		  return findNode(latestRoot.right,value); 
	  
  }
  
  // Method to find next node for a node in inorder fashion
  public void findNextNode(int value){
	  if(root==null)
		  System.out.println("Empty Tree - Value Cannot Be Found");
	  else{
		  Node n=findNode(root,value);
		  if(n!=null){
			  System.out.println("Node "+n.value+" found with parent :"+ n.parent.value);
			  if(n.right!=null)
				  System.out.println("Next Node : "+n.right.value);
			  else
				  findNextNodeRec(n);
		  }
		  else
			  System.out.println("Node "+value+" not found in the tree");
		  }
  }
 
 // Helper Recursive Function for findNextNode 
 public void findNextNodeRec(Node n){
	 Node par=n.parent;
	 System.out.println(n.value + " "+ n.right);
	 if(par==null)
		 System.out.println("No Next Node");
	 else if(par.left==n)
		 System.out.println("Next node : "+par.value);
	 else if(par.right==n)
		 findNextNodeRec(par);
 }
 
 // Method to find the common ancestor node for given 2 nodes
 public Node commonAncestor(Node latestRoot,Node p,Node q){
	 if(covers(latestRoot.left,p) && covers(latestRoot.left,q))
		 return commonAncestor(latestRoot.left, p, q);
	 if(covers(latestRoot.right,p) && covers(latestRoot.right,q))
		 return commonAncestor(latestRoot.right, p, q);
	 else 
		 return latestRoot;
 }
 
 // Method to check if given node is present anywhere in the given subtree with root latestRoot
 public boolean covers(Node latestRoot,Node n){
	 if(latestRoot==null) return false;
	 else if(latestRoot==n) return true;
	 else return covers(latestRoot.left,n) || covers(latestRoot.right,n);  
 }
 public void exploreDFS(Node n){
	  System.out.print(n.value+"\t");
	  if(n.left!=null)
		  exploreDFS(n.left);
	  if(n.right!=null)
		  exploreDFS(n.right);	  
 }
}

public class BinarySearchTreeDemo {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst .insert(40)
        .insert(25)
        .insert(78)
        .insert(10)
        .insert(3)
        .insert(17)
        .insert(32)
        .insert(30)
        .insert(38)
        .insert(78)
        .insert(50)
        .insert(93);
    Node root=bst.root;
    System.out.println("Inorder traversal");
    bst.printInorder();

    System.out.println("Preorder Traversal");
    bst.printPreorder();

    System.out.println("Postorder Traversal");
    bst.printPostorder();

    System.out.println("The minimum value in the BST: " + bst.findMinimum());
    System.out.println("The maximum value in the BST: " + bst.findMaximum());
    
    System.out.println("2nd min : "+bst.find2ndMinimum());
    System.out.println("2nd max : "+bst.find2ndMaximum());
    
    bst.findNextNode(50);
    
    Node commonAncestor=bst.commonAncestor(root,
    		bst.findNode(root, 17),
    		bst.findNode(root, 93));
    System.out.println("Common Ancestor Value : "+commonAncestor.value);
    System.out.println("DFS");
    bst.exploreDFS(root);


  }
}