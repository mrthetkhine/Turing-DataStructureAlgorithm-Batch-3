package com.turing.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

	public int[] merge(int[] input, int start, int middle, int end) {
		int result[] = new int[input.length];
		System.arraycopy(input, 0, result, 0, input.length);
		
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

	public int[] sort(int[] input)
	{
		return this.sort(input,0,input.length-1);
	}
	public int[] sort(int[] input, int start, int end) {
		
		if(start == end)
		{
			return input;
		}
		else
		{
			int middle = (start + end)/2;
			input = this.sort(input, start, middle);
			input = this.sort(input, middle+1, end);
			
			return this.merge(input, start, middle, end);
		}
	}

}
