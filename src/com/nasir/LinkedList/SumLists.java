package com.nasir.LinkedList;


/**
 * Created by nasir on 11/1/16.
 */


public class SumLists {
    public static void main(String args[]) {
        MyLinkedList<Integer> l1 = new MyLinkedList<>();
        MyLinkedList<Integer> l2 = new MyLinkedList<>();
        l1.addNodeTail(7);
        l1.addNodeTail(1);
        l1.addNodeTail(6);

        l2.addNodeTail(5);
        l2.addNodeTail(9);
        l2.addNodeTail(2);

        l1.print();
        l2.print();

        MyLinkedList<Integer> summedList = new MyLinkedList<>();
        summedList.head = performSumLists(l1.getHead(), l2.getHead());

        summedList.print();;

    }

    public static Node<Integer> performSumLists(Node<Integer> headA, Node<Integer> headB) {

        Node<Integer> p1, p2, q, headQ;
        p1 = headA;
        p2 = headB;
        q = headQ = null;
        int rem, dividend;
        dividend = 0;
        while(p1 != null || p2 != null) {
            if(p1 == null) p1.data = 0;
            if(p2 == null) p2.data = 0;

            int num = p1.data + p2.data + dividend;
            dividend = num/10;
            rem = num%10;
            Node<Integer> n = new Node<>(rem);

            if(q == null) {
              headQ = n;
              q = headQ;
            }

            else {
                q.next = n;
                q = n;
            }

            p1 = p1.next;
            p2 = p2.next;
        }
        return headQ;

    }
}
