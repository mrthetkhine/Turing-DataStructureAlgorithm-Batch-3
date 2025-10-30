package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MergeSortTest {
	@Test
	public void testMerge()
	{
		MergeSort algo = new MergeSort();
		int[] input = {3,1};
		//int middle = (start+end)/2
		int[] result = algo.merge(input,0,0,input.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
		
		int[] input2 = {3,1,2};
		//int middle = (start+end)/2
		result = algo.merge(input2,0,0,input2.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
	}
}
