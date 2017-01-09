package com.nasir.Backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nasir on 1/2/17.
 */
public class NQueen2 {
    final int N = 8;
    int possibleSolutions = 0;
    private final Set<Integer> occupiedCols = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placeed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1) {

                return false;
            }

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A recursive utility function to solve N
       Queen problem */
    //return -1 if cannot be placed
    // return 1 if can be placed
    // return 2 if all are placed

    int solveNQUtil(int board[][], int col)
    {
        /* base case: If all queens are placed
           then return true */
        if (col >= N)
            return 2;

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < N; i++)
        {
            /* Check if queen can be placed on
               board[i][col] */
            if (isSafe(board, i, col))
            {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                int placedResult = solveNQUtil(board, col + 1);

                if(placedResult == 2) {
                    possibleSolutions++;
                    resetBoard(board);
                    return 1;
                }
                /* recur to place rest of the queens */
                else if (placedResult == 1 && col!=0)
                    return 1;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /* If queen can not be place in any row in
           this colum col, then return false */
        return -1;
    }

    /* This function solves the N Queen problem using
       Backtracking.  It mainly uses  solveNQUtil() to
       solve the problem. It returns false if queens
       cannot be placed, otherwise return true and
       prints placement of queens in the form of 1s.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.*/
    boolean solveNQ()
    {
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
       /* int board[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };*/

        if (solveNQUtil(board, 0) == -1)
        {
            System.out.print("Solution does not exist");
            System.out.println("No: of distinct solutions "+ possibleSolutions);
            return false;
        }

        System.out.println("No: of distinct solutions "+ possibleSolutions);

        printSolution(board);
        return true;
    }

    public void resetBoard(int[][] board) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                board[i][j] = 0;
        }
    }



    public int totalNQueens(int n) {
        return totalNQueensHelper(0, 0, n);
    }

    private int totalNQueensHelper(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (occupiedCols.contains(col))
                continue;
            int diag1 = row - col;
            if (occupiedDiag1s.contains(diag1))
                continue;
            int diag2 = row + col;
            if (occupiedDiag2s.contains(diag2))
                continue;
            // we can now place a queen here
            if (row == n-1)
                count++;
            else {
                occupiedCols.add(col);
                occupiedDiag1s.add(diag1);
                occupiedDiag2s.add(diag2);
                count = totalNQueensHelper(row+1, count, n);
                // recover
                occupiedCols.remove(col);
                occupiedDiag1s.remove(diag1);
                occupiedDiag2s.remove(diag2);
            }
        }

        return count;
    }

    // driver program to test above function
    public static void main(String args[])
    {
        NQueen2 Queen = new NQueen2();
        //Queen.solveNQ();
        System.out.println(Queen.totalNQueens(8));
    }
}
