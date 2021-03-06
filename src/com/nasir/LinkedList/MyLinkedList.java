package com.nasir.LinkedList;

/**
 * Created by NasirAhmed on 15-Aug-16.
 */
public class MyLinkedList<E> {
    public Node<E> head, tail;
    public MyLinkedList() {
        head = null;
        tail = null;
    }



    public void addNodeFront(E data) {
        Node<E> n = new Node(data);
        if(head == null){
            head = n;
            tail = n;
        }
        else {
            n.next = head;
            head = n;
        }
    }

    public void addNodeTail(E data) {
        Node<E> n = new Node(data);
        if(tail == null) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
    }

    public void deleteNode(Node<E> node, Node<E> n) {
        if(node.equals(n)) {
            node.data = node.next.data;
            node.next = node.next.next;
        }

        else {
            Node prev = node;
            while(prev.next!=null) {
                if(prev.next.equals(n)) {
                    Node temp = prev.next.next;
                    prev.next = temp;
                }

                prev = prev.next;
            }
        }
    }

    public void print(){
        for(Node<E> n = head; n!=null; n = n.next) {
            System.out.print(n.data +"->");
        }
        System.out.println();
    }

    public Node<E> getHead() {
        return head;
    }


}




