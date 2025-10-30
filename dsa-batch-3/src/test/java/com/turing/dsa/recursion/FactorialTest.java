package com.turing.dsa.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactorialTest {
	@Test
	public void testBase()
	{
		assertEquals(1,Factorial.fact(0));
		assertEquals(1,Factorial.fact(1));
		assertEquals(2,Factorial.fact(2));
		assertEquals(6,Factorial.fact(3));
		//Factorial.fact(10000);
	}
}
