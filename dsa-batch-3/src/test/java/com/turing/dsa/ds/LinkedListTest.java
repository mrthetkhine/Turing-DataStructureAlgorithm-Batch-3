package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;


import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;


public class LinkedListTest {
	LinkedList list = new LinkedList();
	@Test
	void testInsertWhenEmpty()
	{
		
		list.append(100);
		
		Iterator<Node> iterator = list.createIterator();
		
		
		assertEquals(100,iterator.next().value);
		assertEquals(false,iterator.hasNext());
		
		/*
		while(iterator.hasNext())
		{
			System.out.println("Item "+iterator.next().value);
		}
		*/
	}
	@Test
	void testInsertWhenNotEmptyEmpty()
	{
		
		list.append(100);
		list.append(200);
		
		Iterator<Node> iterator = list.createIterator();
		
		
		assertEquals(100,iterator.next().value);
		assertEquals(200,iterator.next().value);
		assertEquals(false,iterator.hasNext());
		
	}
	@Test
	void testInsertMany()
	{
		
		for(int i=0;i<20;i++)
		{
			list.append(i);
		}
		
		Iterator<Node> iterator = list.createIterator();
		
		for(int i=0;i<20;i++)
		{
			assertEquals(i,iterator.next().value);
		}
		
		assertEquals(false,iterator.hasNext());
		
	}
	@Test
	void testPrependWhenEmpty()
	{
		list.prepend(100);
		
		Iterator<Node> iterator = list.createIterator();
		
		assertEquals(100,iterator.next().value);
		assertEquals(false,iterator.hasNext());
		
	}
	@Test
	void testPrependInsertMany()
	{
		list.prepend(100);
		list.prepend(200);
		list.prepend(300);
		
		Iterator<Node> iterator = list.createIterator();
		
		assertEquals(300,iterator.next().value);
		assertEquals(200,iterator.next().value);
		assertEquals(100,iterator.next().value);
		assertEquals(false,iterator.hasNext());
		
	}
	
	@Test
	void testAppendPrepend()
	{
		list.append(100);
		list.prepend(200);
		list.append(300);
		
		//[200,100,300]
		Iterator<Node> iterator = list.createIterator();
		
		assertEquals(200,iterator.next().value);
		assertEquals(100,iterator.next().value);
		assertEquals(300,iterator.next().value);
		assertEquals(false,iterator.hasNext());
		
	}
	@Test
	void testContains()
	{
		list.append(100);
		list.append(200);
		list.append(300);
		
		assertTrue(list.contains(100));
		assertTrue(list.contains(200));
		assertTrue(list.contains(300));
		assertFalse(list.contains(10));
		
	}
	@Test
	void testDeleteFirstWhenSingleNode()
	{
		list.append(100);
		
		list.delete(100);
		Iterator<Node> iterator = list.createIterator();
		assertEquals(false,iterator.hasNext());
	}
	@Test
	void testDeleteFirstWhenMultNode()
	{
		list.append(100);
		list.append(200);
		
		list.delete(100);
		
		Iterator<Node> iterator = list.createIterator();
		
		assertEquals(200,iterator.next().value);
		assertEquals(false,iterator.hasNext());
	}
	@Test
	void testDeleteMiddleNode()
	{
		list.append(100);
		list.append(200);
		list.append(300);
		
		list.delete(200);
		
		Iterator<Node> iterator = list.createIterator();
		
		assertEquals(100,iterator.next().value);
		assertEquals(300,iterator.next().value);
		assertEquals(false,iterator.hasNext());
	}
	@Test
	void testDeleteLastNode()
	{
		list.append(100);
		list.append(200);
		list.append(300);
		
		list.delete(300);
		
		Iterator<Node> iterator = list.createIterator();
		
		assertEquals(100,iterator.next().value);
		assertEquals(200,iterator.next().value);
		assertEquals(false,iterator.hasNext());
	}
}
