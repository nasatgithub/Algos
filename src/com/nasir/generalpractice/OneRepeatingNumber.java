package code.nasir.generalpractice;

public class OneRepeatingNumber {

public static void main(String args[]){
	System.out.println("Test Case 1: HAS DUPLICATES\n--------------------------");
	testCase1();
	
	System.out.println("\n\nTest Case 2: NO DUPLICATES\n--------------------------");
	testCase2();
}

/*  Since the array has elements between 1 and 1000000, and there is only one integer that is duplicated,
 *  that duplicate element can be found by the following function : 
 *  
 *  The elements in the array are used as index, and then the element at that index is changed to its negative
 *  value if it is not negative already. If it is negative already, then it means that same index has been visited
 *  before, thus that index being the repeating element to be found.  
 *  
 *  This function does not take consume any extra Additional Buffer. 
 *  Time complexity of this algorithm is O(n).
 */ 

public static void findOneRepeating(int a[]){
	int altIndex;
	for(int i=0;i<a.length;i++){
		
		altIndex=Math.abs(a[i])-1;    // using element at i as alternate index
		if(a[altIndex]>0)             // if element at alternate index is positive, then it is set to negative 
			a[altIndex]*=-1;
		else{                                          // if element at alternate index is negative, then that index has been 
			int repeatElement=Math.abs(altIndex+1);    // visited already, thus it is the repeating element.
			System.out.println("Repeating Element : "+repeatElement);
			return;
		}	
	}
	System.out.println("NO REPEATING ELEMENT IN THE ARRAY");
}

// Test Case 1 : array[1000000] has a duplicate of element 100
public static void testCase1(){
	int a[]=new int[1000000];
	for(int i=0,j=1000000;i<a.length;i++,j--){
		a[i]=j;
		if(i==3) // to enter a duplicate value 100 at index 3
			a[i]=100;
	}
	findOneRepeating(a);
}

//Test Case 2 : array[1000000] has no duplicate elements
public static void testCase2(){
	int a[]=new int[1000000];
	for(int i=0,j=1000000;i<a.length;i++,j--){
		a[i]=j;
	}
	findOneRepeating(a);
}
}

