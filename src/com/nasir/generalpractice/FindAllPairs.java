package code.nasir.generalpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class FindAllPairs {
public static void main(String args[]){
 int a[]={1,2,4,5,3,7,3};
 Scanner scan=new Scanner(System.in);
 System.out.println("Enter the sum for which pairs need to be found");
 int sum=scan.nextInt();
 List allPairs=findAllPairsSumOptimal(a,sum);
 System.out.println(allPairs);	
 
 System.out.println("Enter the difference for which pairs need to be found");
 int diff=scan.nextInt();
 allPairs=findAllPairsDiffOptimal(a,diff);
 System.out.println(allPairs);
}


public static ArrayList<ArrayList<Integer>> findAllPairsSumOptimal(int a[],int sum){
	HashSet<Integer> aMap=new HashSet<Integer>();
	ArrayList<ArrayList<Integer>> allPairs=new ArrayList<ArrayList<Integer>>();
	for(int v:a){
		int sumMinusV=sum-v;
		ArrayList<Integer> pair;
		if(aMap.contains(sumMinusV)){
			pair=new ArrayList<Integer>();
			pair.add(v);
			pair.add(sumMinusV);
			allPairs.add(pair);
		}
		aMap.add(v);
	}
	return allPairs;
}

public static ArrayList<ArrayList<Integer>> findAllPairsDiffOptimal(int a[],int diff){
	HashSet<Integer> aMap=new HashSet<Integer>();
	ArrayList<ArrayList<Integer>> allPairs=new ArrayList<ArrayList<Integer>>();
	for(int v:a){
		int vMinusDiff=v-diff;
		ArrayList<Integer> pair;
		if(aMap.contains(vMinusDiff)){
			pair=new ArrayList<Integer>();
			pair.add(v);
			pair.add(vMinusDiff);
			allPairs.add(pair);
		}
		aMap.add(v);
	}
	return allPairs;
}
}







// Inefficient Code - IGNORE 
/*public static ArrayList<ArrayList<Integer>> findAllPairsSum(int a[],int sum){
	HashMap<Integer,Integer> aMap=new HashMap<Integer,Integer>();
	ArrayList<ArrayList<Integer>> allPairs=new ArrayList<ArrayList<Integer>>();
	for(int v:a){
		if(aMap.get(v)==null)
			aMap.put(v,1);
		else
		    aMap.put(v,aMap.get(v)+1);
	}
	for(int v:a){
		int vmSum=Math.abs(v-sum);
		if(aMap.containsKey(vmSum)){
			if(v==vmSum){
				int vCount=0;
			  	if(aMap.get(v)>=2)
			  		vCount=aMap.get(v)-2;
			  	else 
			  		continue;
			  	if(vCount==0)
			  		aMap.remove(v);
			  	else
			  		aMap.put(v, vCount);
			}
			else{
				int vCount=aMap.get(v)-1;
				int vmSumCount=aMap.get(vmSum)-1;
				if(vCount==0)
					aMap.remove(v);
				else 
					aMap.put(v, vCount);
				
				if(vmSumCount==0)
					aMap.remove(vmSum);
				else 
					aMap.put(vmSum, vmSumCount);
						
			}
			ArrayList<Integer> pair=new ArrayList<Integer>();
			pair.add(v);
			pair.add(vmSum);
			allPairs.add(pair);
		}
	}
	return allPairs;
}*/
