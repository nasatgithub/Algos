package com.nasir.Stacks;

import java.util.Stack;

/**
 * Created by nasir on 12/24/16.
 */
public class StackMin extends Stack<Integer> {
   Stack<Integer> mins;

    public StackMin() {
        mins = new Stack();
    }

    public void push(int value) {
        if(value < minFromMins())
            mins.push(value);
        super.push(value);
    }

    public Integer pop() {
        int poppedValue = super.pop();
        if(mins.peek() == poppedValue)
            mins.pop();
        return poppedValue;
    }


    public Integer minFromMins(){
        if(mins.isEmpty())
            return Integer.MAX_VALUE;
        else
            return mins.peek();
    }

    public static void main(String args[]) {
        StackMin sM = new StackMin();
        int a[] = {4,5,2,3,1};

        for(int v: a)
            sM.push(v);

        while(!sM.isEmpty()) {
            System.out.println("CURRENT MIN IN STACK IS : " + sM.mins.peek());
            System.out.println("Popping from main stack:" + sM.pop());
        }
    }
}
