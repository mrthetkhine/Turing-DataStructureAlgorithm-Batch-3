package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class PostOrderTraversalIterativeTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	//@Test
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
	//@Test
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
}
