package com.nasir.LinkedList;

/**
 * Created by nasir on 11/1/16.
 */
public class Node<E> {
    public E data;
    public Node<E> next;

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