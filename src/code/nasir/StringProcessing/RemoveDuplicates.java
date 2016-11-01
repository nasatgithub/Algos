package code.nasir.StringProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicates {
public static void main(String args[]){
	int a='?';
	boolean[] chars=new boolean[150];
	String s="hehb";
	char c=0;
	System.out.println("c = a"+c+"b");
	char[] sChar=s.toCharArray();
/*	for(int i=0;i<sChar.length;i++){
		char ch=sChar[i];
		int chAscii=ch;
		if(chars[chAscii]==true)
		{
			
		}
		else{
			newS=newS+ch;
			chars[chAscii]=true;
		}
	}
	System.out.println(newS);*/
	myRemoveDuplicates(sChar);
	//removeDuplicates(sChar);
	replaceSpaces();
	
}
public static void myRemoveDuplicates(char[] str){
	int[] pos=new int[str.length-1];
	int k=0;
	for(int i=0;i<str.length;i++){
		for(int j=i+1;j<str.length;j++){
			if(str[i]==str[j])
			    pos[k++]=j;	
			  
		}
	}
	for(int i:pos)
		System.out.print(i);
	int posL=pos.length;
	int sLen=str.length;
	for(int i=0;i<posL;i++)
	{
		if(pos[i]!=0)
		{
			for(int j=pos[i];j<sLen;j++){
				 int p=j+1;
				 if(j!=sLen-1)
				  str[j]=str[p];
				 else
					 str[j]=0;
				
			    
			}
		}
		 sLen--;
	}
	System.out.println("\n"+new String(str));
	
}
public static void replaceSpaces(){
	String s="ab cd ef";
	Pattern pat=Pattern.compile("\\s");
	Matcher match=pat.matcher(s);
	int space=0;
	while(match.find())
		space++;
	char c1[]=s.toCharArray();
	char c1New[]=new char[s.length()+(space*2)];
	for(int i=0,j=0;i<c1.length;i++)
	{   
		if(c1[i]==' '){
			c1New[j++]='%';
			c1New[j++]='2';
			c1New[j++]='0';
		}
		else
			c1New[j++]=c1[i];
	}
	System.out.println(new String(c1New));
	
}
public static void removeDuplicates(char[] str) {
	 if (str == null) return;
	 int len = str.length;
	 if (len < 2) return;
	
	 int tail = 1;
	
	 for (int i = 1; i < len; ++i) {
	 int j;
	 for (j = 0; j < tail; ++j) {
	 if (str[i] == str[j]) break;
	 }
	 if (j == tail) {
	 str[tail] = str[i];
	 ++tail;
	 }
	 }
	 str[tail] = 0;
	 for(char c: str)
		 System.out.print(c);
	 }
}
