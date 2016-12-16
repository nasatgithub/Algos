package com.nasir.SearchAndSort;

/**
 * Created by nasir on 11/24/16.
 */
public class Solution {

    public static void main(String args[]) {
        System.out.println(solution(2,1,1,9));
    }

    public static  String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        // find max of all the permutations in such a way AB < 24 and CD < 60
        int maxHour, maxMin;
        maxHour = maxMin = -1;

        String a = String.valueOf(A);
        String b = String.valueOf(B);
        String c = String.valueOf(C);
        String d = String.valueOf(D);
        String timeArray = a+b+c+d;


        StringBuilder revTimeArray = new StringBuilder(timeArray);
        revTimeArray = revTimeArray.reverse();

        System.out.println(timeArray);

        //TO FIND MAX HOUR
        for(int i=0; i<timeArray.length(); i++) {
            for(int j =i+1; j<timeArray.length(); j++) {
                char sI = timeArray.charAt(i);
                char sJ = timeArray.charAt(j);

                String hourComb = String.valueOf(sI) + String.valueOf(sJ);
                int hourCombInt = Integer.parseInt(hourComb);
                if(hourCombInt < 24 && hourCombInt > maxHour)
                    maxHour = hourCombInt;
            }
        }

        for(int i=0; i<revTimeArray.length(); i++) {
            for(int j =i+1; j<revTimeArray.length(); j++) {
                char sI = revTimeArray.charAt(i);
                char sJ = revTimeArray.charAt(j);

                String hourComb = String.valueOf(sI) + String.valueOf(sJ);
                int hourCombInt = Integer.parseInt(hourComb);
                if(hourCombInt < 24 && hourCombInt > maxHour)
                    maxHour = hourCombInt;
            }
        }

        if(maxHour == -1)
            return "NOT POSSIBLE";

        String maxHourS = String.valueOf(maxHour);

        for(int i=0; i<timeArray.length(); i++) {
            for(int j =i+1; j<timeArray.length(); j++) {
                char sI = timeArray.charAt(i);
                char sJ = timeArray.charAt(j);
                if(maxHourS.indexOf(sI)<0 && maxHourS.indexOf(sJ)<0) {
                    String minComb = String.valueOf(sI) + String.valueOf(sJ);
                    int minCombInt = Integer.parseInt(minComb);
                    if (minCombInt < 60 && minCombInt > maxMin)
                        maxMin = minCombInt;
                }
            }
        }

        for(int i=0; i<revTimeArray.length(); i++) {
            for(int j =i+1; j<revTimeArray.length(); j++) {
                char sI = revTimeArray.charAt(i);
                char sJ = revTimeArray.charAt(j);
                if(maxHourS.indexOf(sI)<0 && maxHourS.indexOf(sJ)<0) {
                    String minComb = String.valueOf(sI) + String.valueOf(sJ);
                    int minCombInt = Integer.parseInt(minComb);
                    if (minCombInt < 60 && minCombInt > maxMin)
                        maxMin = minCombInt;
                }
            }
        }



        if(maxMin == -1)
            return "NOT POSSIBLE";


        return maxHour+":"+(maxMin<9?("0"+maxMin):maxMin);


    }
}