package com.turing.dsa.recursion;

public class SumOfDigit {

	public static int sum(int n) {
	
		if(n<10)
		{
			return n;
		}
		else
		{
			return n%10 + sum(n/10);
		}
	}

}
