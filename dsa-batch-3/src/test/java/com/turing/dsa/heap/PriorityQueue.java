package com.turing.dsa.heap;

public class PriorityQueue {
	MaxHeap heap = new MaxHeap();
	
	void insert(int value)
	{
		heap.insert(value);
	}
	Integer remove()
	{
		return heap.remove();
	}
	
}
