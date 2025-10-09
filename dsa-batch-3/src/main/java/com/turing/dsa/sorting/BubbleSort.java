package com.turing.dsa.sorting;

public class BubbleSort implements SortingAlgorithm{

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
			for(int i=0;i<input.length-1;i++)
			{
				int minIndex =i;
				for(int j=i+1;j<input.length;j++)
				{
					if(input[minIndex]> input[j])
					{
						minIndex = j;
					}
				}
				//now selection sort
				int temp = input[minIndex];
				input[minIndex] = input[i];
				input[i] = temp;
			}
			return input;
		}
	}

}
