package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackWithLinkedListTest {

	@Test
	public void testPushPop()
	{
		StackWithLinkedList stack = new StackWithLinkedList();
		
		stack.push(100);
		stack.push(200);
		stack.push(300);
		
		assertEquals(300,stack.pop());
		assertEquals(200,stack.pop());
		assertEquals(100,stack.pop());
	}
	@Test
	public void testPeek()
	{
		StackWithLinkedList stack = new StackWithLinkedList();
		
		stack.push(100);
		stack.push(200);
		stack.push(300);
		
		assertEquals(300,stack.peek());
		assertEquals(300,stack.pop());
		assertEquals(200,stack.pop());
	}
}
