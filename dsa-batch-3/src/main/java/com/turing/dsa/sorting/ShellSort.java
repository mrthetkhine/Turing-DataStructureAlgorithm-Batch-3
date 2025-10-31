package com.turing.dsa.sorting;

public class ShellSort {

	public int[] sort(int[] input) {
		int n = input.length / 2;
		
		while(n >0)
		{
			
			for(int i=0;i< input.length-n; i++)
			{
				for(int j=i+n;j< input.length;j++)
				{
					if(input[i]>input[j])
					{
						int temp = input[i];
						input[i] = input[j];
						input[j] = temp;
					}
				}
			}
			n = n /2;
		}
		return input;
	}

}
