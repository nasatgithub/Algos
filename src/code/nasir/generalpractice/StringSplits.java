package code.nasir.generalpractice;

import java.util.ArrayList;
import java.util.List;

public class StringSplits {
public static List<Character> delimList; 
public static List<String> splitList;
public static void main(String args[]){
	String a="ab cd ef     ab";
    String delim=" ";
    List<String> splits=mySplit(a, delim);
    for(String split: splits)
    	System.out.println(split);
  
}
public static List<String> mySplit(String a,String delim){
	  char[] aChars=a.toCharArray();
	    String split="";
	    splitList=new ArrayList<String>();
	    for(int i=0;i<aChars.length;i++){
	    	if(aChars[i]==delim.charAt(0)){
	    		if(isDelimSeq(i,a,delim)){
	    			i+=delim.length()-1;
	    			if(!split.equals("")){
	    				splitList.add(split);
	    				split="";
	    			}
	    			continue;
	    		}
	    	}
	    	split=split+aChars[i];
	    }
	    if(!split.equals("")) 
	    	splitList.add(split);
	   return splitList;
}
public static boolean isDelimSeq(int curIndex,String s,String delim){
	if(curIndex+delim.length()<=s.length())
	{
		String checkDelimSeq=s.substring(curIndex,curIndex+delim.length());
		if(checkDelimSeq.contentEquals(new StringBuffer(delim))){
			return true;
		}
	}
	return false;
}
}
