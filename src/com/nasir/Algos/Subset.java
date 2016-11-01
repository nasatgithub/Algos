package code.nasir.Algos;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class Subset {
 public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,
			 int index) {
			 ArrayList<ArrayList<Integer>> allsubsets;
			 if (set.size() == index) { // Base case - add empty set
			  allsubsets = new ArrayList<ArrayList<Integer>>();
			  allsubsets.add(new ArrayList<Integer>()); // Empty set	
			 }
		  else {
				  allsubsets = getSubsets(set, index + 1);
				  int item = set.get(index);
				  ArrayList<ArrayList<Integer>> moresubsets =
				  new ArrayList<ArrayList<Integer>>();
				  for (ArrayList<Integer> subset : allsubsets) {
					  ArrayList<Integer> newsubset = new ArrayList<Integer>();
					  newsubset.addAll(subset); //
					  newsubset.add(item);
					  moresubsets.add(newsubset);
				  }
				  allsubsets.addAll(moresubsets);
			  }
		  return allsubsets;
}
 public static void main(String args[]){
	 ArrayList<Integer> aL=new ArrayList<Integer>();
	 aL.add(1);
	 aL.add(2);
	 aL.add(3);
	 ArrayList<ArrayList<Integer>> result= Subset.getSubsets(aL, 0);
	 System.out.println(result);
 }
}
