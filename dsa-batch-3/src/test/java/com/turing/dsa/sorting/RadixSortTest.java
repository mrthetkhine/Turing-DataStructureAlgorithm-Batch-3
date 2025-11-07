package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RadixSortTest {
	RadixSort algo = new RadixSort();
	
	@Test
	public void testRadix()
	{
		
		assertEquals(0,algo.getRadix(120,0));
		assertEquals(2,algo.getRadix(120,1));
		assertEquals(1,algo.getRadix(120,2));
		assertEquals(0,algo.getRadix(120,3));
	}
	@Test
	public void testMaxDigitLength()
	{
		assertEquals(3,algo.getLength(120));
		assertEquals(2,algo.getLength(12));
		assertEquals(1,algo.getLength(0));
	}
	
	@Test
	public void testBaseCase()
	{
		int input[] = {2,11};
		algo.sort(input);
		
		assertTrue(SortingUtil.isSorted(input));
		
		int input2[] = {421, 240, 35, 532, 305, 430, 124};
		algo.sort(input2);
		
		assertTrue(SortingUtil.isSorted(input2));
	}
}
