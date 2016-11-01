package code.nasir.StringProcessing;

import java.util.Scanner;

public class RowColumnZero {
private int[][] image;
public static void main(String args[]){
	System.out.println("Enter the M * N");
	Scanner scan=new Scanner(System.in);
	int m=scan.nextInt();
	int n=scan.nextInt();
	RowColumnZero rc=new RowColumnZero();
	rc.image=new int[m][n];
	System.out.println("Enter the values for matrix ");
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			rc.image[i][j]=scan.nextInt();
		}
	}
	
	System.out.println("Entered Matrix is");
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			System.out.print(rc.image[i][j]+"\t");
		}
		System.out.println();
	}
	
	rc.image=RowColumnZero.makeZero(rc.image);
	System.out.println("Cleaned Matrix is");
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			System.out.print(rc.image[i][j]+"\t");
		}
		System.out.println();
	}
}
public static int[][] makeZero(int[][] matrix){
	int m=matrix.length;
	int n=matrix[0].length;
	boolean[] rowToBeZero=new boolean[m];
	boolean[] columnToBeZero=new boolean[n];
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			if(matrix[i][j]==0){
				rowToBeZero[i]=true;
				columnToBeZero[j]=true;
			}
		}
	}
	matrix=cleanedMatrix2(matrix,m,n,rowToBeZero,columnToBeZero);
	return matrix;
}
public static int[][] cleanedMatrix(int matrix[][],int m,int n,boolean[] r,boolean[] c){
	for(int k=0;k<r.length;k++){
		if(r[k]==true){
			for(int j=0;j<n;j++)
				matrix[k][j]=0;
		}
	}
	for(int k=0;k<c.length;k++){
		if(c[k]==true){
			for(int i=0;i<m;i++)
				matrix[i][k]=0;
		}
	}
	return matrix;
}
public static int[][] cleanedMatrix2(int matrix[][],int m,int n,boolean[] r,boolean[] c){
    for(int i=0;i<m;i++){
    	for(int j=0;j<n;j++){
    		if(r[i]||c[j])
    			matrix[i][j]=0;
    	}
    }
	return matrix;
}
}
