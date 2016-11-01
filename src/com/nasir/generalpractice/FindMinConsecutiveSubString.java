package code.nasir.generalpractice;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class FindMinConsecutiveSubString {
public static void main(String args[]){
	String s="adoaabecodebanc";
	String t="abc";
	Queue<Integer> nextLetter=new PriorityQueue<Integer>();
	TreeMap<Integer, Integer> indexLength=new TreeMap<Integer, Integer>();
	int count,start,end;
	start=end=0;
	count=0;
	HashSet<Character> tHash=new HashSet<Character>();
	HashSet<Character> visitedChar=new HashSet<Character>();
	for(int i=0;i<t.length();i++)
		tHash.add(t.charAt(i));
	
	for(int i=0;i<s.length();i++){
		char c=s.charAt(i);
		if(tHash.contains(c)){
			 
			if(count!=0)
				 nextLetter.add(i);
			 else
				 start=i;
			 
			 if(!visitedChar.contains(s.charAt(i))){
			 count++;
			 visitedChar.add(s.charAt(i));
			 }
			 
			 if(count==tHash.size()){
				 end=i;
				 indexLength.put((end-start)+1, start);
				 count=0;
				 visitedChar.clear();
				 if(!nextLetter.isEmpty())
					 i=nextLetter.poll()-1;
			 }
		}
	}
	System.out.println(indexLength);
	start = indexLength.get(indexLength.firstKey());
	end=start+indexLength.firstKey();
	System.out.println("Min Consecutive : "+s.substring(start,end));
	
}
}
