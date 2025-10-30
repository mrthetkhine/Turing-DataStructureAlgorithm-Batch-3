package com.turing.dsa.recursion;

public class MethodCallDemo {

	static void methodA()
	{
		System.out.println("Method A");
		methodB();
		System.out.println("Return Back to A");
	}
	static void methodB()
	{
		System.out.println("Method B");
		methodC();
		System.out.println("Return Back to B");
	}
	static void methodC()
	{
		System.out.println("Method C");
	}
	public static void main(String[]args)
	{
		methodA();
	}
}
