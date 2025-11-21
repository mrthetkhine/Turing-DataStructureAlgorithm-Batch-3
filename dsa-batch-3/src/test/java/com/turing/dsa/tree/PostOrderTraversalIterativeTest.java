package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class PostOrderTraversalIterativeTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	@Test
	public void testPostOderBase1()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   
		 * */
		
		tree.insert(10);
		
		
		Iterator<Node> iterator = tree.postOrderIterative();
		
		assertEquals(10,iterator.next().value);
	
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPostOrderBaseIterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		//[5,20,10]
		
		Iterator<Node> iterator = tree.postOrderIterative();
		
		assertEquals(5,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPostOrderBase2Iterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		     20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		
		//[20,10]
		
		Iterator<Node> iterator = tree.postOrderIterative();
		
	
		assertEquals(20,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPostOrderLevel2Iterative()
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
		
		
		//[6,9,8,20,10]
		
		Iterator<Node> iterator = tree.postOrderIterative();
		
	
		assertEquals(6,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(8,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPostOrderLevel2Test2Iterative()
	{
		/*		
		 * 			10
		 * 			/  \
		 * 		   8      20
		 * 		  / \     / \
		 * 		 6	 9   15  25
		 * 					  \
		 * 						30	
		 * */
		
		tree.insert(10);
		tree.insert(8);
		tree.insert(20);
		tree.insert(9);
		tree.insert(6);
		tree.insert(15);
		tree.insert(25);
		tree.insert(30);
		
		
		//[6,9,8,15,30,25,20,10]
		
		Iterator<Node> iterator = tree.postOrderIterative();
		
	
		assertEquals(6,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(8,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(30,iterator.next().value);
		assertEquals(25,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
}
