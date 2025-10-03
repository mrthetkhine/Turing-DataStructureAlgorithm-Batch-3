package com.turing.dsa.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	SearchAlgorithm algo = new BinarySearch();
	
	@Test
	public void testBase()
	{
		int[] arr = {};
		int index =algo.search(arr,10);
		assertEquals(-1,index);
		
		index = algo.search(null, 100);
		assertEquals(-1,index);
	}
	
	@Test
	public void testSingle()
	{
		int[] arr = {10};
		int index =algo.search(arr,10);
		assertEquals(0,index);
				
	}
	@Test
	public void testMultiple()
	{
		int[] arr = {10,20};
		int index =algo.search(arr,10);
		assertEquals(0,index);
		
		index =algo.search(arr,20);
		assertEquals(1,index);
				
	}
	@Test
	public void testMultiple2()
	{
		int[] arr = {10,20,25};
		int index =algo.search(arr,10);
		assertEquals(0,index);
		
		index =algo.search(arr,20);
		assertEquals(1,index);
				
		index =algo.search(arr,25);
		assertEquals(2,index);
	}
	@Test
	public void testUnhappy()
	{
		int[] arr = {10,20,25};
		int index =algo.search(arr,11);
		assertEquals(-1,index);
		
		index =algo.search(arr,26);
		assertEquals(-1,index);
				
		index =algo.search(arr,22);
		assertEquals(-1,index);
		
		index =algo.search(arr,9);
		assertEquals(-1,index);
	}
}
