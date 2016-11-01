package code.nasir.generalpractice;

import org.w3c.dom.NodeList;

class Node {
private int value;
private Node left;
private Node right;
public Node(){
	left=right=null;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public Node getLeft() {
	return left;
}
public void setLeft(Node left) {
	this.left = left;
}
public Node getRight() {
	return right;
}
public void setRight(Node right) {
	this.right = right;
}
}

public class MyLinkedList{
	private Node front;
	private Node last;
	public MyLinkedList(){
		front=null;
		last=null;
	}
	public void add(int value){
		Node node=new Node();
		node.setValue(value);
		if(last==null){
			front=last=node;
		}
		else{
			last.setRight(node);
			last=node;
		}	
	}
	public void remove(int value){
		Node prev=null;
		for(Node n=front;n!=null;n=n.getRight()){
			if(n.getValue()==value){
				if(prev==null)
					front=n.getRight();
				else if(n.getRight()==null){
					last=prev;
					last.setRight(null);
				}
				else{ 
					prev.setRight(n.getRight());
					n=null;
					break;
				}
			}
			prev=n;
		}
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		for(Node n=front;n!=null;n=n.getRight()){
			sb.append(n.getValue()+"\t");
		}
		return sb.toString();
	}
	public static void main(String args[]){
		MyLinkedList l=new MyLinkedList();
		l.add(10);
		l.add(20);
		l.add(50);
		l.add(5);
		System.out.println(l);
		int del=20;
		System.out.println("Deleting "+del);
		l.remove(del);
		System.out.println(l);
	}
}
