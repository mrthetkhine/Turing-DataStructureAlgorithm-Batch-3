package com.turing.dsa.search;

public class LinearSearch implements SearchAlgorithm{

	public int search(int[] arr, int element) {
		if(arr == null || arr.length==0)
		{
			return -1;
		}
		else
		{
			for(int i=0;i< arr.length;i++)
			{
				if(arr[i]== element)
				{
					return i;
				}
			}
			return -1;
		}
	}

}
