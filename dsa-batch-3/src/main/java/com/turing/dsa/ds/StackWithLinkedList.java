package com.turing.dsa.ds;

public class StackWithLinkedList {

	LinkedList list = new LinkedList();
	
	public void push(int item) {
		this.list.append(item);
		
	}

	int peek()
	{
		Node last = this.list.getLast();
		return last.value;
	}
	public int pop() {
		Node last = this.list.getLast();
		list.delete(last.value);
		return last.value;
	}

}
