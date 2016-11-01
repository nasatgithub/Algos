package code.nasir.generalpractice;

public class FIzzBuzz {
public static void main(String args[]){
	boolean isFizz,isBuzz;
	for(int i=1;i<=100;i++){
		isFizz=isBuzz=false;
		if(i%3==0)
			isFizz=true;
		if(i%5==0)
			isBuzz=true;
		if(isFizz&&isBuzz)
			System.out.println("FizzBuzz");
		else if(isFizz)
			System.out.println("Fizz");
		else if(isBuzz)
			System.out.println("Buzz");
		else 
			System.out.println(i);
	}
}
}
