package com.turing.dsa.ds;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackTest {
	
	Stack stack = new Stack(10);
	@Test
	void testStackPushEmpty()
	{
		
		int size = stack.size();
		stack.push(10);
		
		assertEquals(size+1, stack.size());
		assertEquals(10,stack.peek());
	}
	@Test
	void testStackPushBase()
	{
		
		
		int size = stack.size();
		stack.push(20);
		
		assertEquals(size+1, stack.size());
		assertEquals(20,stack.peek());
	}
	@Test
	void testStackPushMultiple()
	{
		int size = stack.size();
		stack.push(10);
		stack.push(20);
		
		assertEquals(size+2, stack.size());
		assertEquals(20,stack.peek());
	}
	@Test
	void testStackPushFull()
	{
		
		for(int i=0;i<10;i++)
		{
			stack.push(i);
		}
		
		
		assertEquals(10, stack.size());
		assertEquals(9,stack.peek());
	}
	@Test
	void testStackPushWhenFull()
	{
		for(int i=0;i<10;i++)
		{
			stack.push(i);
		}
		
		assertThrows(StackOverflowException.class, ()->{
			stack.push(100);
		});
	
	}
	@Test
	void testPopBaseCase()
	{
		
		stack.push(10);
		int size = stack.size();
		
		int item = stack.pop();
		assertEquals(size-1,stack.size());
		assertEquals(10,item);
	}
	@Test
	void testPopMultiple()
	{
		
		stack.push(10);
		stack.push(20);
		
		assertEquals(20, stack.pop());
		assertEquals(10, stack.pop());
		assertEquals(0,stack.size());
	}
	@Test
	void testPopBoundary()
	{
		
		for(int i=0;i<10;i++)
		{
			stack.push(i);
		}
		
		for(int i=9;i>=0;i--)
		{
			assertEquals(i, stack.pop());
		}
		assertEquals(0,stack.size());
	}
	@Test
	void testPopEdge()
	{
		
		stack.push(10);
		
		stack.pop();
		
		assertThrows(StackUnderflowException.class,()->{
			stack.pop();
		});
	}
	@Test
	void testPeekBaseCase()
	{
		
		stack.push(10);
		assertEquals(10,stack.peek());
		assertEquals(1,stack.size());
	}
	@Test
	void testPeek()
	{
		
		assertThrows(StackUnderflowException.class,()->{
			stack.peek();
		});
	}
	@Test
	void testStackIsEmpty()
	{
		assertTrue(stack.isEmpty());	
	}
	@Test
	void testStackIsFull()
	{
		
		for(int i=0;i<10;i++)
		{
			stack.push(i);
		}
		assertTrue(stack.isFull());
		
	}
}
