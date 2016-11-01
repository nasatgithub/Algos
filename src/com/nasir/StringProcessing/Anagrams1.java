package code.nasir.StringProcessing;

import java.util.Scanner;

public class Anagrams1 {
public static void main(String args[]){
	System.out.println(Anagrams1.checkAnagram());
}
public static boolean checkAnagram(){
	System.out.println("Enter 2 strings to check for Anagrams");
	Scanner scan=new Scanner(System.in);
	int[] charCount=new int[256];
	String a=scan.next();
	String b=scan.next();
	char[] aChar=a.toCharArray();
	char[] bChar=b.toCharArray();
	for(char c:aChar){
		int ascii=c;
		charCount[ascii]++;
	}
	for(char c:bChar){
		int ascii=c;
		charCount[ascii]--;
	}
	for(int i=0;i<256;i++){
		if(charCount[i]!=0){
			return false;
		}
	}
	return true;
}
}
