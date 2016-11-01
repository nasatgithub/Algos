package code.nasir.BitManipulate;

import java.util.Scanner;

public class BitManipulationSubstring {
public static void main(String args[]){
		BitManipulationSubstring b=new BitManipulationSubstring();
		System.out.println(b.ctcCode(1024,21, 2, 6));
}

public int ctcCode(int n, int m, int i, int j) {
		 int max = ~0; /* All 1’s */
         
		 // 1’s before position j, then 0’s
		 int left = max - ((1 << (j+1)) - 1); //j+1 is important here to set all bits to 1 until j and not j. 
		  									  // remaining bits from j are set to 0 

		 // 1’s after position i
		 int right = ((1 << i) - 1);

		 // 1’s, with 0s between i and j
		 int mask = left | right;
         int maskn=n & mask;
         int mLSi=m << i;
		 // Clear i through j, then put m in there
		 return maskn | mLSi;
		 
}
public void myCode(){
	Scanner scan=new Scanner(System.in);
	StringBuffer N=new StringBuffer(scan.nextLine());
	StringBuffer M=new StringBuffer(scan.nextLine());
	int i=scan.nextInt();
	int j=scan.nextInt();
    
	char[] nc=new String(N.reverse()).toCharArray();
	System.out.println(new String(nc));
	M.reverse();
	//char[] mc=new String(M.reverse()).toCharArray();
    for(int k=0;k<M.length();k++){
    	if(i<=j){
    		nc[i++]=M.charAt(k);
    	}
    	
    }
    StringBuffer Nconv=new StringBuffer(new String(nc)).reverse();
	System.out.println(Nconv);
	
	scan.close();

}
}
