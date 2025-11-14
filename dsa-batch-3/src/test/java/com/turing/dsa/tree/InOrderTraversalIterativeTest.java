package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class InOrderTraversalIterativeTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	@Test
	public void testPreOrderBaseZeroIterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   
		 * */
		
		tree.insert(10);
		
		
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(10,iterator.next().value);
	
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPreOrderBaseIterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(5,iterator.next().value);
		assertEquals(10,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPreOrderBase2Iterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		     20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		
		
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(10,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPreOrderBase3Iterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  
		 * */
		
		tree.insert(10);
		tree.insert(5);
		
		
		
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(5,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		
		assertFalse(iterator.hasNext());
	}
}
