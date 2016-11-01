package com.nasir;

/**
 * Created by NasirAhmed on 15-Aug-16.
 */
public class MyLinkedList<E> {
    Node head, tail;
    public MyLinkedList() {
        head = null;
        tail = null;
    }

     public class Node {
        private E data;
        private Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }

        @Override
        public boolean equals(Object obj) {
            return this.data == ((Node)obj).data;
        }
    }

    public void addNodeFront(E data) {
        Node n = new Node(data);
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
        Node n = new Node(data);
        if(tail == null) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
    }

    public void deleteNode(Node node, Node n) {
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
        for(Node n = head; n!=null; n = n.next) {
            System.out.print(n.data +"->");
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }


}


