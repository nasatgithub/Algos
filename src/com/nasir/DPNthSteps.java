package com.nasir;

import java.util.Scanner;

/**
 * Created by NasirAhmed on 04-Oct-16.
 */
public class DPNthSteps {

    public static void main(String args[]) {
        DPNthSteps dpNthSteps = new DPNthSteps();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter step number");
        int n = scan.nextInt();

        // my dp bottom-up approach
        int ways = dpNthSteps.noOfWays(n);
        System.out.println(ways);

        // ctc top-down approach
        int[] map = new int[n+1];
        for(int i=0;i<=n;i++)
            map[i]=-1;
        int countWays = countWaysDP(n, map);
        System.out.print(countWays);

    }

    public int noOfWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int from3rd, from2nd, from1st;
        for (int i = 1; i <= n; i++) {
            from3rd = i - 3;
            from2nd = i - 2;
            from1st = i - 1;
            if (i - 3 < 0)
                from3rd = 0;
            else
                from3rd = dp[i - 3];
            if (i - 2 < 0)
                from2nd = 0;
            else
                from2nd = dp[i - 2];
            if (i - 1 < 0)
                from1st = 0;
            else
                from1st = dp[i - 1];
            dp[i] = from3rd + from2nd + from1st;
        }
        return dp[n];
    }

    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map) +
                    countWaysDP(n - 2, map) +
                    countWaysDP(n - 3, map);
            return map[n];
        }
    }
}
