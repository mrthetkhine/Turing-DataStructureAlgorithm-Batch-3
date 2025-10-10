package com.turing.dsa.ds;

public class Stack {

	int top = -1;
	int[] items ;
	public Stack(int initialSize) {
		this.items = new int[initialSize];
	}

	public void push(int item) {
		if(top < this.items.length-1)
		{
			this.items [++this.top] = item;
		}
		else
		{
			throw new StackOverflowException("Stack is full");
		}
	}

	public int size() {
		return this.top+1;
	}

	public int peek() {
		if(top >=0)
		{
			return this.items[this.top];
		}
		else
		{
			throw new StackUnderflowException("Stack is empty");
		}
			
	}
	public boolean isEmpty()
	{
		return this.top ==-1;
	}
	public boolean isFull()
	{
		return this.top == this.items.length-1;
	}
	public int pop() {
		if(this.top>=0)
		{
			return this.items [this.top --];
		}
		else
		{
			throw new StackUnderflowException("Stack is empty");
		}
		
	}

}
