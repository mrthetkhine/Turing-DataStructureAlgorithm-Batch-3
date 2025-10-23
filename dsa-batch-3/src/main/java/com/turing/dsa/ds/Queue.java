package com.turing.dsa.ds;

public interface Queue {
	void enqueue(int item);
	int dequeue();
	int peek() ;
	int getSize();
}
