package code.nasir.trees;

import java.util.LinkedList;

import code.nasir.trees.BinaryTree.Node;

public class BinaryTree {

public static LinkedList<Node> queue;
public static Node root;
class Node{
	public Node left;
	public Node right;
	public int depth;
	public int level;
	public int value;	
	public Node(int value){
		depth=0;
		level=0;
		left=null;
		right=null;
		this.value=value;
	}
	public Node addNode(int value,Node root){
		if(root.left==null){
			Node b=new Node(value);
			b.level=root.level+1;
			root.left=b;
			queue.clear();
		}
		else if(root.right==null){
			Node b=new Node(value);
			b.level=root.level+1;
			root.right=b;
			queue.clear();	
		}
		else{
			queue.add(root.left);
			queue.add(root.right);
			addNode(value, queue.poll());
		}
		
		return root;
		
	}
	public void deleteNode(){

	}
	public void printInorder(Node root){
	 if(root==null)
		 return;
	 if(root.left!=null)
		 printInorder(root.left);
	 System.out.println(root.value);
	 if(root.right!=null)
		 printInorder(root.right);	 
	}
}

public static int maxDepth(Node node){
	if(node==null)
		return 0;
	else 
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
}
public static int minDepth(Node node){
	if(node==null)
		return 0;
	else 
		return Math.min(minDepth(node.left), minDepth(node.right));
}

public static int maxLevel(Node node){
	if(node==null)
		return 0;
	else if(node.left!=null){
		return maxLevel(node.left);
	}
	else if(node.right!=null){
		return maxLevel(node.right);
	}
	else
		return node.level;
}

public static boolean checkBalanced(Node node){
 System.out.println("maxD "+maxDepth(node));
 System.out.println("minD "+minDepth(node));
 return (maxDepth(node)-minDepth(node)<=1);	
}
public static void main(String args[]){
	queue=new LinkedList<Node>();
	boolean isBalanced;
	BinaryTree b=new BinaryTree();
    root=b.new Node(5);
	
	root.addNode(6, root);
	root.addNode(7, root);
	root.addNode(2, root);
	root.addNode(4, root);
	root.addNode(8, root);
	root.addNode(9, root);
	root.addNode(10, root);
	
	root.printInorder(root);
	
	isBalanced=checkBalanced(root);
	System.out.println("Balanced :"+isBalanced);
	
	System.out.println("MaxLevel Left :"+maxLevel(root));
	
}


}
