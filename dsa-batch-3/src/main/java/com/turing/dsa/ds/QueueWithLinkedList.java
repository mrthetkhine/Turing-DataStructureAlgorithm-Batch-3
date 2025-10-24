package com.turing.dsa.ds;

public class QueueWithLinkedList {

	LinkedList list =new LinkedList();
	public void enqueue(int item) {
		this.list.append(item);
		
	}

	public int dequeue() {
		Node temp = this.list.getFirst();
		this.list.delete(temp.value);
		return temp.value;
	}

	public int peek() {
		Node temp = this.list.getFirst();
		return temp.value;
	}

}
