package com.turing.dsa.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinearSearchTest {
	
	SearchAlgorithm algo = new LinearSearch();
	@Test
	public void testEmpty()
	{
		int arr[]= {};
		
		int index = algo.search(arr,10);
		assertEquals(-1,index);
	}
	@Test
	public void testNull()
	{
		int arr[]= null;
		
		int index = algo.search(arr,10);
		assertEquals(-1,index);
	}
	@Test
	public void testSingleElment()
	{
		int arr[]= {10};
		
		int index = algo.search(arr,10);
		assertEquals(0,index);
	}
	@Test
	public void testBoundaryCase()
	{
		int arr[]= {10,20};
		
		int index = algo.search(arr,20);
		assertEquals(1,index);
		
		index = algo.search(arr,10);
		assertEquals(0,index);
	}
	@Test
	public void testUnhappyCase()
	{
		int arr[]= {10,20,30,40,20};
		
		int index = algo.search(arr,12);
		assertEquals(-1,index);
		
	}
	
	@Test
	public void testDuplicate()
	{
		int arr[]= {10,20,30,40,20};
			
		int index = algo.search(arr,20);
		assertEquals(1,index);
		
	}
}
