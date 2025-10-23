package com.turing.dsa.ds;

public class NormalQueue implements Queue{


	int[] items;
	int head = 0;//head
	int tail = 0;//tail
	
	int size = 0;
	public NormalQueue(int size) {
		this.items = new int[size];
	}

	
	public void enqueue(int item) {
	
		if(this.tail < items.length)
		{
			this.items[this.tail++] = item;
			this.size ++;
		}
		else
		{
			throw new RuntimeException("Queue full");
		}
	}

	public int peek() {
		return this.items[this.head];
	}
	public int getSize()
	{
		return this.size;
	}

	public int dequeue() {
		if(size>0)
		{
			this.size--;
			return this.items[this.head++];
		}
		else
		{
			throw new RuntimeException("Queue underflow");
		}
	}


	

}
