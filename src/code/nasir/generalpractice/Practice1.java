package code.nasir.generalpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practice1{
public static void main(String args[]){
	String a="Hi";
	String b="Bye";
	//System.out.println(b.compareTo(a));
	List<Car> cars=new ArrayList<Car>();
	cars.add(new Car("X", (long)100));
	cars.add(new Car("Y", (long)50));
	
	Iterator<Car> carsIter=cars.iterator();
	while(carsIter.hasNext())
		System.out.println("--"+carsIter.next().toString());
	
	
	HashMap<String, Long> carMap=new HashMap<String, Long>();
	Collections.sort(cars);
	for(Car car:cars){
	 System.out.println(car);
	 carMap.put(car.name, car.price);
	}
	
	Iterator iter=carMap.entrySet().iterator();
	while(iter.hasNext()){
		Map.Entry me=(Map.Entry) iter.next();
		System.out.println(me.getKey()+"\t"+me.getValue());
	}
	
	uniqueOrNot();
	reverseCStyle();	
	
}
public static void uniqueOrNot(){
	Scanner scan=new Scanner(System.in);
	String s1=scan.nextLine();
	char[] c1=s1.toCharArray();
	int[] ascii=new int[256];
	for(int i=0;i<ascii.length;i++)
		ascii[i]=0;
			
		 
	for(char c:c1){
		ascii[c]++;
		if(ascii[c]>1)
			{
			 System.out.println("not unique");
			 return;
			}
	}
	System.out.println("unique");
	
}
public static void reverseCStyle(){
	String s="abcd\n";
	char[] c=s.toCharArray();
	char[] rev=new char[c.length-1];
	for(int i=0,j=c.length-2;j>=0;i++,j--){
		rev[i]=c[j];
	}
	String revS=new String(rev)+"\n";
	System.out.println(revS);
}
}
class Car implements Comparable<Car>{
	String name;
	Long price;
	public Car(String name,Long price){
		this.name=name;
		this.price=price;
	}
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		if(price>o.price)
			return 1;
		else 
		   return -1;
	}
	
	public String toString(){
		return "name : "+name+"\tprice : "+price;
	}
	
	
	
}

