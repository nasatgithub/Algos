package com.nasir.javaconcepts_package1;

import java.util.LinkedList;

/**
 * Created by NasirAhmed on 03-Nov-16.
 */
public class Access_Modifier1 {
    private int valPrivate = 10;
    int valDefault = 11; // default
    protected int valProtected = 12;
    public int valPublic = 13;

    public void method1() {
        System.out.print(valPrivate+ " "+valDefault+ " "+valProtected+" "+valPublic);
        LinkedList<Integer> l = new LinkedList<>();

    }
}


