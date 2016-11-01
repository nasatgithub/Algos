package code.nasir.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CoinsSumDp {
public static void main(String args[]){
	Scanner scan=new Scanner(System.in);
	int finalSum=3;
	int noOfCoins=3;
	int[] V=new int[noOfCoins];
	HashMap<Integer,List<Integer>> coins=new HashMap<Integer, List<Integer>>();
	
	// minimum number of coins required to achieve state i, where i<=finalSum
	int[] minCoins=new int[finalSum+1];
	
	System.out.println("Enter the "+noOfCoins+" coin values");
	for(int j=0;j<noOfCoins;j++)
		V[j]=scan.nextInt();
	
	for(int i=0;i<finalSum+1;i++)
		minCoins[i]= Integer.MAX_VALUE;
	
	for(int i=0;i<finalSum+1;i++)
		coins.put(i, new ArrayList<Integer>());
	
	minCoins[0]=0;
	
	for(int i=1;i<=finalSum;i++){
		for(int j=0;j<noOfCoins;j++){
			if(V[j]<=i && (minCoins[i-V[j]]+1<minCoins[i])){
				minCoins[i]=minCoins[i-V[j]]+1;
				List<Integer> coinList=coins.get(i);
				coinList.clear();
				coinList.add(V[j]);
				coinList.addAll(0, coins.get(i-V[j]));
			}
			    
		}		
	}
	
	System.out.println("Minimum Coins for Sum : "+finalSum+" = "+minCoins[finalSum]);
	System.out.println(coins.get(finalSum));
	
}
}
