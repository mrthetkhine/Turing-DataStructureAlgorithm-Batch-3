package com.turing.dsa.heap;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.turing.dsa.sorting.InsertionSort;
import com.turing.dsa.sorting.SortingAlgorithm;
import com.turing.dsa.sorting.SortingUtil;

public class HeapSortTest {
	SortingAlgorithm algo = new HeapSortAlgorithm();
	
	@Test
	public void testSorting()
	{
		int arr[] = {10,20,1,-1,100};
		int result[] = algo.sort(arr);
		
		System.out.println("Result "+Arrays.toString(result));
		
		assertTrue(SortingUtil.isSortedDescending(result));
		
		
		for(int i=0;i<10;i++)
		{
			int []input = SortingUtil.randomArray(10);
			System.out.println("Input "+Arrays.toString(input));
			input = algo.sort(input);
			System.out.println("Output "+Arrays.toString(input));
			assertTrue(SortingUtil.isSortedDescending(input));
		}
		
	}
	@Test
	public void testSorting2()
	{
		int []input = new int[]{293, 35, 118, 56, 209, 358, 784, 259, 110, 245};
		int result[] = algo.sort(input);
		System.out.println("Result "+Arrays.toString(result));
		
		assertTrue(SortingUtil.isSortedDescending(result));
	}
}
