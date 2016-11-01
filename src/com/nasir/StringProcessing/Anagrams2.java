package code.nasir.StringProcessing;

import java.util.Scanner;
public class Anagrams2 {
public static void main(String args[]){
	Scanner scan=new Scanner(System.in);
	String a=scan.nextLine();
	String b=scan.nextLine();

	if(computeTotalAscii(a)==computeTotalAscii(b))
		System.out.println("Anagrams");
	else
		System.out.println("Not Anagrams");
}
public static int computeTotalAscii(String s){
	
	int t=0;
	for(int i=0;i<s.length();i++){
		t=t+s.charAt(i);
	}
	System.out.println("t ="+t );
	return t;
}
}
