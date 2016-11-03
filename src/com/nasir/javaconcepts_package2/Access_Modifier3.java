package com.nasir.javaconcepts_package2;

import com.nasir.javaconcepts_package1.AccessModifier1_Subclass;
import com.nasir.javaconcepts_package1.Access_Modifier1;

/**
 * Created by NasirAhmed on 03-Nov-16.
 */
public class Access_Modifier3 extends Access_Modifier1{

    @Override
    public void method1() {
        // int valD = valDefault; cannot access default outside package
        System.out.print(valProtected+" "+valPublic);
    }
}

class Access_Modifier4 {


    public void method1() {
        // int valD = valDefault; cannot access default outside package

        Access_Modifier1 a = new AccessModifier1_Subclass();
        // int valProtect = a.valProtected   protected not accessible since not inherited
        System.out.print(a.valPublic);
    }
}
