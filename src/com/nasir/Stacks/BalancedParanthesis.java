package com.nasir.Stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by nasir on 12/31/16.
 */
public class BalancedParanthesis {
    private static HashMap<Character, Character> closeOpenMap;
    private static HashSet<Character> openP;
    public static void main(String args[]) {
        String openParanthesis = "({[";
        String closeParanthesis = ")}]";
        closeOpenMap = new HashMap<>();
        openP = new HashSet<>();
        for(int i=0; i<openParanthesis.length(); i++) {
            closeOpenMap.put(closeParanthesis.charAt(i), openParanthesis.charAt(i));
            openP.add(openParanthesis.charAt(i));
        }



        String exp = "[(])";


        Boolean validParanthesis = isValidParanthesis(exp);
        System.out.println("Valid Paranthesis? : "+ validParanthesis);
    }

    public static boolean isValidParanthesis(String exp) {

        Stack<Character> parans = new Stack<>();
        for(int i=0; i<exp.length(); i++) {
            char currentParan = exp.charAt(i);
            if(openP.contains(currentParan))
                parans.push(currentParan);
            else if(!parans.isEmpty() && closeOpenMap.containsKey(currentParan)) {
                if(parans.pop() != closeOpenMap.get(currentParan))
                    return false;
            }
            else
                return false;
        }


        if(!parans.isEmpty())
            return false;

        return true;
    }

}
