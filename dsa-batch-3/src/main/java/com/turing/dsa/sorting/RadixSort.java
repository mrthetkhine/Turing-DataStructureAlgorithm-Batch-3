package com.turing.dsa.sorting;

import java.util.ArrayList;

public class RadixSort {

	public int getRadix(int number, int bitIndex) {
		
		String input = number+"";
		try
		{
			return Integer.parseInt((input.charAt(input.length()-1-bitIndex))+"");
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	public int getLength(int num) {
		
		return (num+"").length();
	}

	public void sort(int[] input) {
		int maxLen = getMaxLength(input);
		
		for(int i=0;i<maxLen;i++)
		{
			
			ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
			
			for(int b=0;b< 10;b++)
			{
				bucket.add(new ArrayList<>());
			}
			//group number into radix bucket
			for(int k : input)
			{
				int bucketIndex = this.getRadix(k, i);
				bucket.get(bucketIndex).add(k);
			}
			//copy bucket group into array back
			int j =0;
			
			for(int b=0;b< 10;b++)
			{
				for(int item : bucket.get(b))
				{
					input[j++] = item;
				}
			}
		}
		
	}

	private int getMaxLength(int[] input) {
		int max = 0;
		for(int i=0;i< input.length;i++)
		{
			int length = this.getLength(input[i]);
			if(max < length)
			{
				max = length;
			}
		}
		return max;
	}

}
