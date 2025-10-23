package com.turing.dsa.ds;

public class CircularQueue extends NormalQueue implements Queue {

	
	public CircularQueue(int size) {
		super(size);
	
	}

	@Override
	public void enqueue(int item) {
	
		//not full
		if(this.size < items.length)
		{
			this.items[this.tail] = item;
			this.tail = (this.tail+1) % this.items.length;
			this.size ++;
		}
		else
		{
			throw new RuntimeException("Queue full");
		}
	}

	@Override
	public int dequeue() {
		if(size>0)
		{
			this.size--;
			int temp = head;
			this.head = (this.head+1) % this.items.length;
			return this.items[temp];
			
		}
		else
		{
			throw new RuntimeException("Queue underflow");
		}
	}

	
	

	

}
