package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSortTest {
	MergeSort algo = new MergeSort();
	
	@Test
	public void testMerge()
	{
		
		int[] input = {3,1};
		//int middle = (start+end)/2
		int[] result = algo.merge(input,0,0,input.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
		
		int[] input2 = {3,1,2};
		//int middle = (start+end)/2
		result = algo.merge(input2,0,0,input2.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
		
		/*
		a =[1,4,8]
				b =[2,3,10,12,15]
		*/
		int input3[] = {1,4,8,2,3,10,12,15};
		result = algo.merge(input3,0,2,input3.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
		
		/*
		a =[1,4,8,19,25,30]
				b =[2,3,10,12,15]
		*/
		int input4[] = {1,4,8,19,25,30,2,3,10,12,15};
		result = algo.merge(input4,0,5,input4.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
	}
	@Test
	public void testMerge2()
	{
		
		int[] input = {3,2};
		//int middle = (start+end)/2
		int[] result = algo.merge(input,0,0,input.length-1); 
		
		assertTrue(SortingUtil.isSorted(result));
		
		int[] input2 = {2,3,1,10};
		//int middle = (start+end)/2
		result = algo.merge(input2,0,1,input2.length-1); 
		
		//System.out.println("Array "+Arrays.toString(result));
		assertTrue(SortingUtil.isSorted(result));
	}
	@Test
	public void testBaseCase()
	{
		int[] input = {3};
		int[] result= algo.sort(input);
		
		assertTrue(SortingUtil.isSorted(result));
		
		
	}
	@Test
	public void testMany()
	{
		int[] input2 = {3,2};
		int[] result= algo.sort(input2);
		
		assertTrue(SortingUtil.isSorted(result));
		
		int[] input3 = {3,2,1,10};
		result = algo.sort(input3);
		//System.out.println("Array "+Arrays.toString(result));
		assertTrue(SortingUtil.isSorted(result));
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
