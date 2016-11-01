package code.nasir.BitManipulate;

public class nextSmallestLargest {
public static void main(String args[]){
	int a=5;
	int max,min;
	max=min=5;
	int aDup=5;
	/*while(aDup >> 1 != a ){
		if(aDup<min)
			min=aDup;
		else if(aDup>max)
			max=aDup;
	}
	System.out.println("Next smallest : "+min);
	System.out.println("Next Largest : "+ max);
	*/
	System.out.println(GetBit(5, 1));
}
public static boolean GetBit(int n, int index) {
 return ((n & (1 << index)) > 0);
 }

 public static int SetBit(int n, int index, boolean b) {
	 if (b) {
	 return n | (1 << index);
	 } else {
	 int mask = ~(1 << index);
	 return n & mask;
	 }
 }

 public static int GetNext_NP(int n) {
	 if (n <= 0) return -1;
	
	 int index = 0;
	 int countOnes = 0;
	
	 // Find first one.
	 while (!GetBit(n, index)) index++;
	
	 // Turn on next zero.
	 while (GetBit(n, index)) {
	 index++;
	 countOnes++;
	 }
	 n = SetBit(n, index, true);
	
	 // Turn off previous one
	 index--;
	 n = SetBit(n, index, false);
	 countOnes--;
	
	 // Set zeros
	 for (int i = index - 1; i >= countOnes; i--) {
	 n = SetBit(n, i, false);
	 }
	
	 // Set ones
	 for (int i = countOnes - 1; i >= 0; i--) {
	 n = SetBit(n, i, true);
	 }
	 return n;
	}
}
