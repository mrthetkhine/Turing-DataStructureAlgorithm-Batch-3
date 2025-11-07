package com.turing.dsa.sorting;

import java.util.Random;

public class SortingUtil {

	public static int[] randomArray(int size)
	{
		Random random =new Random();
		int arr [] = new int[size];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = random.nextInt(1000);
		}
		return arr;
	}
	public static boolean isSorted(int []input)
	{
		
		for(int i=0;i<input.length-1;i++)
		{
			if(input[i] > input[i+1])
			{
				return false;
			}
		}
		return true;
	}
}
