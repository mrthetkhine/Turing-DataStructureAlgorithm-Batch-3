package com.turing.dsa.hash;

import java.util.LinkedList;

public class HashTable {

	int bucketSize;
	LinkedList<String>[] data;
	
	public HashTable(int bucketSize)
	{
		this.bucketSize = bucketSize;
		this.data = new LinkedList[this.bucketSize];
		
		for(int i=0;i< this.bucketSize;i++)
		{
			this.data[i] = new LinkedList<String>();
		}
	}
	public static int hash(String input, int bucketSize) {
	
		int total =0;
		for(int i=0;i<input.length();i++ )
		{
			total += input.codePointAt(i);
		}
		
		return total% bucketSize;
	}
	public void insert(String input) {
		
		int hashKey = hash(input,this.bucketSize);
		LinkedList<String> bucket = this.data[hashKey];
		bucket.add(input);
	}
	public boolean contains(String input)
	{
		int hashKey = hash(input,this.bucketSize);
		LinkedList<String> bucket = this.data[hashKey];
		return bucket.contains(input);
	}
	public void delete(String input) {
		int hashKey = hash(input,this.bucketSize);
		LinkedList<String> bucket = this.data[hashKey];
		bucket.remove(input);
		
	}
}
