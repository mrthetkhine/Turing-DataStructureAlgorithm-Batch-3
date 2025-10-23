package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NormalQueueTest {
	Queue queue = new NormalQueue(10);
	
	@Test
	public void testEnqueueBase()
	{
		
		queue.enqueue(10);
		int ele = queue.peek();
		
		assertEquals(10,ele);
		assertEquals(1,queue.getSize());
	}
	@Test
	public void testEnqueueBase2()
	{
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
		//FIFO
		queue.enqueue(30);
		queue.enqueue(20);
		queue.enqueue(10);
		int ele = queue.peek();
		
		assertEquals(30,ele);
		assertEquals(3,queue.getSize());
	}
	@Test
	public void testDequeueBase()
	{
		
		queue.enqueue(10);
		int ele = queue.dequeue();
		
		assertEquals(10,ele);
		assertEquals(0,queue.getSize());
	}
	@Test
	public void testDequeueBase2()
	{
		
		queue.enqueue(10);
		queue.enqueue(20);
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		assertEquals(0,queue.getSize());
	}
	
	@Test
	public void testEnqueueProblem()
	{
		NormalQueue queue = new NormalQueue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		assertEquals(30,queue.dequeue());
		
		assertEquals(0,queue.getSize());
		
		assertThrows(RuntimeException.class,()->{
			queue.enqueue(40);
		});
		
	}
	@Test
	public void testDequeProblem()
	{
		NormalQueue queue = new NormalQueue(3);
		queue.enqueue(10);
		queue.enqueue(20);
	
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		
		assertThrows(RuntimeException.class,()->{
			queue.dequeue();
		});
		
		
		
	}
}
