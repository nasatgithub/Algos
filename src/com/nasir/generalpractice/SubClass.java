package code.nasir.generalpractice;

import java.lang.reflect.Method;
abstract class SuperClass{
	public SuperClass(){
		
	}
	public void print(String s){
		System.out.println("In SuperClass: "+s);
	}
}
 class SubClass extends SuperClass {
@Override
public	void print(String s){
	System.out.println("In SubClass: "+s);
}
public static void main(String args[]){
	SubClass s=new SubClass();
	try{
	s.print("Good Morning");
	Class c=Class.forName("java.util.HashMap");
	Method[] m=c.getMethods();
	for(Object method:m){
		System.out.println(method.toString());
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		System.out.println("Finally!!!");
	}
}
@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("In finalize");
	}

}
