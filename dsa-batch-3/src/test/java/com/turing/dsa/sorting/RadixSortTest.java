package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RadixSortTest {
	@Test
	public void testRadix()
	{
		RadixSort algo = new RadixSort();
		assertEquals(0,algo.getRadix(120,0));
		assertEquals(2,algo.getRadix(120,1));
		assertEquals(1,algo.getRadix(120,2));
		assertEquals(0,algo.getRadix(120,3));
	}
}
