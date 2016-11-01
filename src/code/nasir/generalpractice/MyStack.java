package code.nasir.generalpractice;

import java.util.Stack;

class StackNode{
	public int value;
	public StackNode next;
	public StackNode nextMin;
	
	public StackNode(int value){
		this.value=value;
		this.nextMin=null;
	}
	
}

public class MyStack {
  private StackNode top;
  public StackNode minNode;
  public MyStack(){
	  top=null;
  }
  public void push(int v){
	  StackNode n=new StackNode(v);
	  if(top==null){
		  top=n;
		  top.next=null;
		  minNode=top;
	  }
	  else{
		  if(n.value<=minNode.value){
			 n.nextMin=minNode;
			 minNode=n;
		  }
		  n.next=top;
		  top=n;
	  } 
  }
  public StackNode pop(){
	  StackNode popped=top;
	  if(popped==minNode)
	   minNode=popped.nextMin;
	  top=top.next;
	  return popped;
  }
  public String toString(){
	  StringBuffer stackV=new StringBuffer("");
	  while(top!=null){
		  stackV.append(top.value+"\n");
		  top=top.next;
	  }
	  return new String(stackV);
  }
  public static void main(String args[]){
	  MyStack stack=new MyStack();
	  stack.push(10);
	  stack.push(20);
	  stack.push(5);
	  stack.push(30);
	  stack.push(2);
	  stack.push(25);
/*	  stack.pop();
	  stack.pop();
	  stack.pop();
	  stack.pop();
	  stack.pop();
	  stack.pop();*/
	  if(stack.top!=null){
		  System.out.println(stack);
		  System.out.println("Min node "+stack.minNode.value);
	  }
	  else
		  System.err.println("ERROR: EMPTY STACK");
	  int[] array=new int[10];
	  
  }
}
