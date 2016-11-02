package com.nasir.LinkedList;

/**
 * Created by NasirAhmed on 15-Aug-16.
 */
public class MyLinkedListMain {
    public static void main(String args[]) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addNodeFront("a");
        list.addNodeFront("b");
        list.addNodeFront("c");

        list.addNodeTail("x");
        list.addNodeTail("y");
        list.addNodeTail("z");

        list.print();

        list.deleteNode(list.getHead(), list.new Node("c"));

        list.print();



    }
}
