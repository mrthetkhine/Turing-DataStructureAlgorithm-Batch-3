package com.turing.dsa.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchRecuriveTest {

	RecuriveBinarySerach algo = new RecuriveBinarySerach();
	
	@Test
	public void testBase()
	{
		int[] arr = {};
		int index = algo.search(arr,10,0,arr.length-1);
		assertEquals(-1,index);
		
		
		int[]arr2 = {1,2,4};
		index = algo.search(arr2,1,0,arr2.length);
		assertEquals(0,index);
		
		index = algo.search(arr2,4,0,arr2.length);
		assertEquals(2,index);
		
		index = algo.search(arr2,2,0,arr2.length);
		assertEquals(1,index);
	}
	@Test
	public void testComplex()
	{
	
		
		int[]arr2 = {1,2,4,8,12};
		int index = algo.search(arr2,12,0,arr2.length);
		assertEquals(4,index);
		
		index = algo.search(arr2,1,0,arr2.length);
		assertEquals(0,index);
		
		index = algo.search(arr2,2,0,arr2.length);
		assertEquals(1,index);
	}
	
	
}
