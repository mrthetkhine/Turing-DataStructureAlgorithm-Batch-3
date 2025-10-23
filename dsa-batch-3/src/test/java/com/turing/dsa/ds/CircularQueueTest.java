package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CircularQueueTest {

	
	
	@Test
	public void testEnqueueBase()
	{
		Queue queue = new CircularQueue(3);
		
		queue.enqueue(10);
		int ele = queue.peek();
		
		assertEquals(10,ele);
		assertEquals(1,queue.getSize());
	}
	
	@Test
	public void testEnqueueBase2()
	{
		Queue queue = new CircularQueue(3);
		//FIFO
		queue.enqueue(20);
		queue.enqueue(10);
		int ele = queue.peek();
		
		assertEquals(20,ele);
		assertEquals(2,queue.getSize());
	}
	
	@Test
	public void testEnqueueBase3()
	{
		Queue queue = new CircularQueue(3);
		//FIFO
		queue.enqueue(30);
		queue.enqueue(20);
		queue.enqueue(10);
		int ele = queue.peek();
		
		assertEquals(30,ele);
		assertEquals(3,queue.getSize());
	}
	@Test
	public void testEnqueueFullCase()
	{
		Queue queue = new CircularQueue(3);
		//FIFO
		queue.enqueue(30);
		queue.enqueue(20);
		queue.enqueue(10);
		
		assertThrows(RuntimeException.class,()->{
			queue.enqueue(100);
		});
	}
	@Test
	public void testDequeueBase()
	{
		Queue queue = new CircularQueue(3);
		queue.enqueue(10);
		int ele = queue.dequeue();
		
		assertEquals(10,ele);
		assertEquals(0,queue.getSize());
	}
	@Test
	public void testDequeueBase2()
	{
		Queue queue = new CircularQueue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		assertEquals(0,queue.getSize());
	}
	@Test
	public void testDequeueUnderFlow()
	{
		Queue queue = new CircularQueue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		
		assertThrows(RuntimeException.class,()->{
			queue.dequeue();
		});
	}
	@Test
	public void testCircularQueueBaseCase()
	{
		Queue queue = new CircularQueue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		assertEquals(30,queue.dequeue());
		
		queue.enqueue(40);
		assertEquals(40,queue.dequeue());
		
	}
	@Test
	public void testCircularQueueWithLoop()
	{
		Queue queue = new CircularQueue(3);
		
		for(int i=0;i<10;i++)
		{
			queue.enqueue(i);
			assertEquals(i,queue.dequeue());
		}
		
	}
}
