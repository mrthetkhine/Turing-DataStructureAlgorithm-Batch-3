package com.turing.dsa.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumOfDigitTest {
	@Test
	public void testSumOfDigit()
	{
		assertEquals(0,SumOfDigit.sum(0));
		assertEquals(1,SumOfDigit.sum(1));
		assertEquals(1,SumOfDigit.sum(10));
		assertEquals(3,SumOfDigit.sum(12));
		assertEquals(4,SumOfDigit.sum(121));
	}
}
