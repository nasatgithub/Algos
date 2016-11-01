package code.nasir.generalpractice;

import java.io.File;

public class MyExceptionLearning {
public class MyException extends Exception{
public MyException(String exceptionInfo){
super(exceptionInfo);
}
}
public static void main(String args[]) {
	MyExceptionLearning p2=new MyExceptionLearning();
	try{
    p2.doCompute();
	}
	catch(MyException e)
	{
		e.printStackTrace();
	}
	finally{
		System.out.println("Finally block is executed");
	}

}
public void doCompute() throws MyException{
	int a,b;
	a=10;
	b=2;
	if(b==0)
		throw new MyException("Exception: Denominator cannot be ZERO");
	else
		System.out.println(div(a,b));
		
}
public int div(int a,int b)  {
	return a/b;
}
}
