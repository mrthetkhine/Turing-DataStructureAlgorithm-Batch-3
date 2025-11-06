package com.turing.dsa.sorting;

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

}
