package com.turing.dsa.tree.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class TwoThreeFourNodeInsertTest {

	TwoThreeFourTree tree = new TwoThreeFourTree();
	
	@Test
	public void testInsertBase()
	{
		
		
		TNode node = new TNode();
		node.insert(10);
		assertEquals(10,node.keys[0]);
	
	}
	@Test
	public void testInsertBase2()
	{
		
		TNode node = new TNode();
		node.insert(10);
		node.insert(5);
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
	
	}
	@Test
	public void testInsertBase3()
	{
		
		TNode node = new TNode();
		node.insert(10);
		node.insert(5);
		node.insert(20);
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
		assertEquals(20,node.keys[2]);
	
	}
	@Test
	public void testInsertBase4()
	{
		
		TNode node = new TNode();
		node.insert(20);
		node.insert(10);
		node.insert(5);
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
		assertEquals(20,node.keys[2]);
	
	}
	@Test
	public void testInsertBase5()
	{
		
		TNode node = new TNode();
		node.insert(5);
		node.insert(10);
		node.insert(20);
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
		assertEquals(20,node.keys[2]);
	
	}
	@Test
	public void testInsertBase6()
	{
		
		TNode node = new TNode();
		node.insert(5);
		node.insert(10);
		node.insert(2);
		
		assertEquals(2,node.keys[0]);
		assertEquals(5,node.keys[1]);
		assertEquals(10,node.keys[2]);
	
	}
	@Test
	public void testInsertBase7()
	{
		
		TNode node = new TNode();
		node.insert(5);
		node.insert(1);
		node.insert(2);
		
		assertEquals(1,node.keys[0]);
		assertEquals(2,node.keys[1]);
		assertEquals(5,node.keys[2]);
	
	}
	@Test
	public void testInsertComplexSplit()
	{
		
		TNode node = new TNode();
		node.insert(5);
		node.insert(1);
		node.insert(2);
		node.insert(4);
		
		assertEquals(1,node.keys[0]);
		assertEquals(2,node.keys[1]);
		assertEquals(5,node.keys[2]);
	
	}
}
