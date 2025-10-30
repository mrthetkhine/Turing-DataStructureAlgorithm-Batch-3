package com.turing.dsa.recursion;

public class Factorial {
	static int fact(int n)
	{
		if(n==0)
		{
			return 1;
		}
		else
		{
			return n * fact(n-1);
		}
	}
}
