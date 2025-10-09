package com.turing.dsa.sorting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestSortingUtil {

	@Test
	public void testSorting()
	{
		int[] input = {100,0,12,-12,20,112};
		Arrays.sort(input);
		
		assertTrue(SortingUtil.isSorted(input));
		
		int[] input2 = {2,13,1};
		assertFalse(SortingUtil.isSorted(input2));
		
		int[] input3 = {2,2,10};
		assertTrue(SortingUtil.isSorted(input3));
	}
}
