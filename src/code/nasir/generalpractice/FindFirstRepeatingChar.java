package code.nasir.generalpractice;

import java.util.HashMap;

public class FindFirstRepeatingChar {
	
public static void main(String args[]){
	System.out.println("Test Case 1: HAS REPEATING CHARACTERS\n--------------------------");
	testCase1();
	
	System.out.println("\n\nTest Case 2: NO REPEATING CHARACTERS\n--------------------------");
	testCase2();
}
/*
 *  The String is converted into char array and each character is scanned.
 *  A character is added to HashMap with char being key and its index position as value, if it is not present in HashMap.
 *  If the character already exists in the HashMap, then it is set to '\0' in the char array at both the indices they are found.
 *  
 *  Then the char array is scanned from the beginning, and the first character that is not '\0' is the first non-repeating char.
 *  
 *  Time Complexity of this Algorithm is O(n).
 */
public static void findFirstNonRep(String s){
	char[] aChar=s.toCharArray();
	HashMap<Character,Integer> charIndexMap=new HashMap<Character, Integer>();
	
	for(int i=0;i<aChar.length;i++){
		char c=aChar[i];
		if(!charIndexMap.containsKey(c)) 
		 charIndexMap.put(c, i);	                // put char and its index into Hash Map
		else{
			int indx=charIndexMap.get(c);           // get index of char from Hash Map
			aChar[i]=aChar[indx]='\0';              // set char at both the index to '\0'
		}
	}
	
	if(charIndexMap.size()==aChar.length){                // If size of HashMap equal to CharArray size, then all 
		System.out.println("No Repeating Characters");    // characters are unique.
		return;
	}
	
	for(int i=0;i<aChar.length;i++){
		if(aChar[i]!='\0'){                              // print the first char that is not '\0'
			System.out.println("First Non-Repeating Character = "+aChar[i]);
			return;
		}
	}
}

//Test Case 1 : array[1000000] has a duplicate of element 100
public static void testCase1(){
	String s="DGAMNGKD";
	findFirstNonRep(s);
}

//Test Case 2 : array[1000000] has no duplicate elements
public static void testCase2(){
	String s="KBFGD";
	findFirstNonRep(s);
}
}
