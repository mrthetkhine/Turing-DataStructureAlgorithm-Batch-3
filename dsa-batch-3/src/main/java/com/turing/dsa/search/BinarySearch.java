package com.turing.dsa.search;

public class BinarySearch implements SearchAlgorithm {

	@Override
	public int search(int[] arr, int element) {
		
		if(arr == null || arr.length==0)
		{
			return -1;
		}
		int start = 0;
		int end = arr.length;
		
		while(start <= end)
		{
			int middle = (start+end)/2;
			if(middle >= arr.length)
			{
				return -1;
			}
			if(arr[middle] == element)
			{
				return middle;
			}
			else if(arr[middle] < element)
			{
				start = middle +1;
			}
			else
			{
				end = middle -1;
			}
		}
		return -1;
		
	}
	

}
