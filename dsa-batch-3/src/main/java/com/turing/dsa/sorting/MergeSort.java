package com.turing.dsa.sorting;

public class MergeSort {

	public int[] merge(int[] input, int start, int middle, int end) {
		int result[] = new int[input.length];
		
		int i=start;
		int j = middle+1;
		int k = start;
		
		while( i< middle+1 && j < end+1)
		{
			int item ;
			if(input[i]< input [j])
			{
				item = input[i];
				i++;
			}
			else
			{
				item = input[j];
				j++;
			}
			result[k++] = item;
		}
		while(i< middle+1)
		{
			result[k++] = input[i++];
		}
		while(j< end+1)
		{
			result[k++] = input[j++];
		}
		return result;
	}

}
