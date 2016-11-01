package code.nasir.generalpractice;

import java.util.HashSet;

public class SherlockBeast {
public static void main(String args[]){
	System.out.println(NDigits(3));
}

public static String NDigits(int N){
	int max3,max5;
	max5=max3=0;
	int Q3=N/3;
	int Q5=N/5;
	
   int flag=0;
    for(int i=Q3;i>=0;i--){
    	for(int j=Q5;j>=0;j--){
    		if((i*3+j*5)==N)
    		{
    			    max3=i;
    				max5=j;
    				flag=1;
    			
    		}
    	}
    	if(flag==1)
    		break;
    }
	if(max3==0 && max5 == 0)
		return "-1";
	StringBuffer b=new StringBuffer("");
    for(int i=0;i<max3*3;i++)
        b.append("5");
    for(int i=0;i<max5*5;i++)
        b.append("3");
   
    return new String(b);
}
}
