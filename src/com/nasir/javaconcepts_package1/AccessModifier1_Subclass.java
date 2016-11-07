package com.nasir.javaconcepts_package1;

/**
 * Created by NasirAhmed on 03-Nov-16.
 */
public class AccessModifier1_Subclass extends Access_Modifier1 {

    public void method1() {
        // int valP = valPrivate; cannot inherit private
        System.out.print(valDefault+ " "+valProtected+" "+valPublic);
    }
}

class AccessModifier1_Subclass2  {

    public void method1() {
        // int valP = valPrivate; cannot inherit private
        Access_Modifier1 a = new AccessModifier1_Subclass();
        System.out.print(a.valDefault+ " "+a.valProtected+" "+a.valPublic);
    }
}
