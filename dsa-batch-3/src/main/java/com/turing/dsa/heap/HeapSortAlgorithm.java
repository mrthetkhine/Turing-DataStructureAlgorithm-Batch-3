package com.turing.dsa.heap;

import com.turing.dsa.sorting.SortingAlgorithm;

public class HeapSortAlgorithm implements SortingAlgorithm {

	@Override
	public int[] sort(int[] input) {
		int[] output = new int[input.length];
		MaxHeap maxHeap = new MaxHeap();
		
		for(int i=0;i<input.length;i++)
		{
			maxHeap.insert(input[i]);
		}
		for(int i=0;i<input.length;i++)
		{
			int ele = maxHeap.remove();
			output[i] = ele;
		}
		return output;
	}

}
