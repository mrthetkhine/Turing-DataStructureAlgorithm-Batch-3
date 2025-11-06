package com.turing.dsa.sorting;

public class QuickSort {

	public int partition(int[] input, int left, int right) {
		int pivotIndex = right;
		int i = left;
		
		for(int j=left;j<= right;j++)
		{
			if(input[j]<input[pivotIndex])
			{
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				
				i++;
			}
		}
		int temp = input[i];
		input[i] = input[pivotIndex];
		input[pivotIndex] = temp;
		return i;
	}
	public void quickSort(int[]input, int left,int right)
	{
		if(left< right)
		{
			int pivotIndex = this.partition(input, left, right);
			this.quickSort(input, left, pivotIndex-1);
			this.quickSort(input, pivotIndex+1, right);
		}
	}
	public void sort(int[] input) {
		this.quickSort(input, 0, input.length-1);
		
	}

}
