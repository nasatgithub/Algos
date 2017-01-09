package com.nasir;

import java.util.HashMap;

/**
 * Created by nasir on 1/1/17.
 */
public class MajorityWin {

    public static void main(String args[]) {
        int a[] = {3,3,4,2,4,4,2,4,4};
        String majorityExists = checkMajorityExists(a);

        System.out.println(majorityExists);
    }

    public static String checkMajorityExists(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = a.length;

        for(int i=0,j=len-1; i<=j; i++, j--) {
            int count;
            int iVal = a[i];
            int jVal = a[j];
            int countI, countJ;
            countI = getCountOfVals(iVal, map);
            if(i!=j){
                countJ = getCountOfVals(jVal, map);
            }
            else
                countJ = 0;

            if(countI > countJ) {
                 if(isMoreThanHalf(countI, len))
                     return String.valueOf(iVal);
            }
            if(countI < countJ) {
                if(isMoreThanHalf(countJ, len))
                    return String.valueOf(jVal);
            }
        }

        return "NO Majority Element";
    }

    public static  int getCountOfVals(int val, HashMap<Integer, Integer> map) {
        int count;
        if(map.containsKey(val)) {
            count = map.get(val);
            count++;
            map.put(val, count);
        }
        else{
            count = 1;
            map.put(val, count);
        }

        return count;
    }

    public static boolean isMoreThanHalf(int count, int len) {
        float percentage = (float)count/len;
        return percentage>0.5?true:false;
    }



}
