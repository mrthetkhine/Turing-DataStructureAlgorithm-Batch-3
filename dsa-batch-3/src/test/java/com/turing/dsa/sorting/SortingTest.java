package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SortingTest {

	SortingAlgorithm algo = new InsertionSort();
	
	@Test
	public void testBase()
	{
		int arr[] = {};
		int result[] = algo.sort(arr);
		assertEquals(arr,result);
		
		result = algo.sort(null);
		assertEquals(null,result);
	}
	@Test
	public void testSimple()
	{
		int arr[] = {1};
		int result[] = algo.sort(arr);
		assertEquals(arr,result);
		
	}
	@Test
	public void testComplexCase()
	{
		int arr[] = {10,20,1,-1,100};
		int result[] = algo.sort(arr);
		
		assertTrue(SortingUtil.isSorted(result));
		
		for(int i=0;i<10;i++)
		{
			int []input = SortingUtil.randomArray(30);
			//System.out.println("Input "+Arrays.toString(input));
			input = algo.sort(input);
			//System.out.println("Output "+Arrays.toString(input));
			assertTrue(SortingUtil.isSorted(input));
		}
		
	}
}
