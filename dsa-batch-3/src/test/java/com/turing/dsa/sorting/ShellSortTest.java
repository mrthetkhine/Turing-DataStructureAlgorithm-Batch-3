package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ShellSortTest {
	ShellSort algo = new ShellSort();
	
	@Test
	public void testBaseCase()
	{
		
		int arr[] = {20,10};
		int result[] = algo.sort(arr);
		
		assertTrue(SortingUtil.isSorted(result));
	}
	@Test
	public void testMany()
	{
		
		int arr[] = {20,10,1,12};
		int result[] = algo.sort(arr);
		
		assertTrue(SortingUtil.isSorted(result));
		
		int arr2[] = SortingUtil.randomArray(8);
		result = algo.sort(arr2);
		
		assertTrue(SortingUtil.isSorted(result));
		
		int arr3[] = SortingUtil.randomArray(7);
		result = algo.sort(arr3);
		
		assertTrue(SortingUtil.isSorted(result));
		
		int arr4[] = SortingUtil.randomArray(15);
		result = algo.sort(arr4);
		
		assertTrue(SortingUtil.isSorted(result));
	}
}
