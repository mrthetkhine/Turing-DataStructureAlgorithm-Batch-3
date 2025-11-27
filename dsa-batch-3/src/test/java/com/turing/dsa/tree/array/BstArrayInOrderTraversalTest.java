package com.turing.dsa.tree.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.turing.dsa.tree.BstWithArray;

public class BstArrayInOrderTraversalTest {
	BstWithArray tree = new BstWithArray();
	
	@Test
	public void testInOrderBaseZeroIterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   
		 * */
		
		tree.insert(10);
		
		
		Iterator<Integer> iterator = tree.inOrder();
		
		assertEquals(10,iterator.next());
	
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testInOrderBaseIterative()
	{
			/*
		 * 			10
		 * 			/\
		 * 		   5  20
		 * 
		*/	
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		Iterator<Integer> iterator = tree.inOrder();
		
		assertEquals(5,iterator.next());
		assertEquals(10,iterator.next());
		assertEquals(20,iterator.next());
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testInOrderBase2Iterative()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		     20
		 * 
		*/
		tree.insert(10);
		tree.insert(20);
		
		
		Iterator<Integer> iterator = tree.inOrder();
		
		assertEquals(10,iterator.next());
		assertEquals(20,iterator.next());
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testInOrderBase3Iterative()
	{
		 /*	
		 * 			10
		 * 			/\
		 * 		   5  
		 *
		*/
		tree.insert(10);
		tree.insert(5);
		
		
		
		Iterator<Integer> iterator = tree.inOrder();
		
		assertEquals(5,iterator.next());
		assertEquals(10,iterator.next());
		
		
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
		 * 
		*/
		tree.insert(10);
		tree.insert(8);
		tree.insert(20);
		tree.insert(9);
		tree.insert(6);
		
		// [6,8,9,10,20]
		
		Iterator<Integer> iterator = tree.inOrder();
		
		assertEquals(6,iterator.next());
		assertEquals(8,iterator.next());
		assertEquals(9,iterator.next());
		assertEquals(10,iterator.next());
		assertEquals(20,iterator.next());
		
		
		assertFalse(iterator.hasNext());
	}
}
