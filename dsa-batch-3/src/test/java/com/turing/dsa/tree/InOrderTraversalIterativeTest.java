package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class InOrderTraversalIterativeTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	@Test
	public void testInOrderBaseZeroIterative()
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
	public void testInOrderBaseIterative()
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
	public void testInOrderBase2Iterative()
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
	public void testInOrderBase3Iterative()
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
	@Test
	public void testInOrderLevel2Iterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   8  20
		 * 		  / \
		 * 		 6	 9
		 * */
		
		tree.insert(10);
		tree.insert(8);
		tree.insert(20);
		tree.insert(9);
		tree.insert(6);
		
		// [6,8,9,10,20]
		
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(6,iterator.next().value);
		assertEquals(8,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(10,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		
		assertFalse(iterator.hasNext());
	}
}
