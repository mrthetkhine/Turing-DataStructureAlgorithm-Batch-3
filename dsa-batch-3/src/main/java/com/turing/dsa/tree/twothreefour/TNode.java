package com.turing.dsa.tree.twothreefour;

import java.util.ArrayList;
import java.util.Arrays;

public class TNode {

	int noOfNode = 1;//start from 2 tree
	Integer keys[] = new Integer[3];
	ArrayList<TNode> children = new ArrayList<>();
	
	public void insert(int value)
	{
		if(this.noOfNode < 4)
		{
			this.simpleLeafInsert(value);
		}
		else
		{
			System.out.println("This case split");
		}
		
	}

	private void simpleLeafInsert(int value) {
		this.noOfNode ++;
		System.out.println("Keys "+Arrays.toString(keys));
		System.out.println("Value to insert "+value);
		int index = 0;
		while(keys[index] != null 
				&& keys[index]< value 
				&& index < this.keys.length)
		{
			index ++;
		}
		
		System.out.println("Index to insert "+index);
		for(int i=keys.length-2; i >= index; i--)
		{
			keys[i+1] = keys[i];
		}
		keys[index] = value;
	}
}
