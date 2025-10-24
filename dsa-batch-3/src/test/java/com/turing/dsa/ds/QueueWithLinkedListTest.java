package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueueWithLinkedListTest {
	@Test
	public void testQueue()
	{
		QueueWithLinkedList queue = new QueueWithLinkedList();
		
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		
		assertEquals(100,queue.dequeue());
		assertEquals(200,queue.dequeue());
		assertEquals(300,queue.dequeue());
	}
	@Test
	public void testQueuePeek()
	{
		QueueWithLinkedList queue = new QueueWithLinkedList();
		
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		
		assertEquals(100,queue.peek());
		assertEquals(100,queue.dequeue());
		
	}
}
