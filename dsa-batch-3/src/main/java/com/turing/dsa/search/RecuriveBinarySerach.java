package com.turing.dsa.search;

public class RecuriveBinarySerach {

	public int search(int[] arr, int item, int start, int end) {
		if(start > end)
		{
			return -1;
		}
		else
		{
			int middle = (start + end)/2;
			if(arr[middle] == item)
			{
				return middle;
			}
			else if(arr[middle] > item)
			{
				return search(arr,item,start, middle-1);
			}
			else
			{
				return search(arr,item,middle+1, end);
			}
		}
		
	}

}
