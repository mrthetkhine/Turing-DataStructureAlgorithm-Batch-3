package com.turing.dsa.sorting;

public class InsertionSort implements SortingAlgorithm{

	@Override
	public int[] sort(int[] input) {
		if(input==null || input.length==0)
		{
			return input;
		}
		else if(input.length==1)
		{
			return input;
		}
		else
		{
			for(int i=1;i<input.length;i++)
			{
				int j =i;
				while(j >0 && input[j-1] > input[j])
				{
					//swap input[j] , input[j-1]
					int temp = input[j];
					input[j] =input[j-1];
					input[j-1] = temp;
					j--;
				}
			}
			return input;
		}
	}

}
