package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTraversalTest {
	
	BinarySearchTree tree = new BinarySearchTree();
	
	public BinarySearchTreeTraversalTest()
	{
		/*
		
		*/
	}
	@Test
	public void testPreOrderBase()
	{
		//10,5,20,12,15,30
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		Iterator<Node> iterator = tree.preOrder();
		
		assertEquals(10,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testPreOrder()
	{
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		tree.insert(12);
		tree.insert(15);
		//10,5,20,12,15,30
		Iterator<Node> iterator = tree.preOrder();
		
		assertEquals(10,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(12,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(30,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	void initV2()
	{
		tree.insert(10);
		tree.insert(8);
		tree.insert(13);
		tree.insert(4);
		tree.insert(6);
		tree.insert(11);
		tree.insert(15);
		tree.insert(14);
		tree.insert(25);
	}
	@Test
	public void testPreOrderV2()
	{
		
		this.initV2();
		Iterator<Node> iterator = tree.preOrder();
		
		//10, 8,4,6,13,11,15,14,25
		assertEquals(10,iterator.next().value);
		assertEquals(8,iterator.next().value);
		assertEquals(4,iterator.next().value);
		assertEquals(6,iterator.next().value);
		assertEquals(13,iterator.next().value);
		assertEquals(11,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(14,iterator.next().value);
		assertEquals(25,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	/*
	 *  	10
	 *     /  \
	 *     5  20
	 *     left Root right
	 * */
	@Test
	public void testInOrderBase()
	{
		//10,5,20
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		Iterator<Node> iterator = tree.inOrder();
		
		assertEquals(5,iterator.next().value);
		assertEquals(10,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testInOrder()
	{
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		tree.insert(12);
		tree.insert(15);
		//10,5,20,12,15,30
		Iterator<Node> iterator = tree.inOrder();
		
		assertEquals(5,iterator.next().value);
		assertEquals(10,iterator.next().value);
		assertEquals(12,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(30,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testInOrderV2()
	{
		this.initV2();
		//[4,6,8,10,11,13,14,15,25]
		Iterator<Node> iterator = tree.inOrder();
		
		assertEquals(4,iterator.next().value);
		assertEquals(6,iterator.next().value);
		assertEquals(8,iterator.next().value);
		assertEquals(10,iterator.next().value);
		assertEquals(11,iterator.next().value);
		assertEquals(13,iterator.next().value);
		assertEquals(14,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(25,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	/*		
	 * 			10
	 * 			/\
	 * 		   5  20
	 * */
	@Test
	public void testPostOrderBase()
	{
		//10,5,20
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		Iterator<Node> iterator = tree.postOrder();
		
		assertEquals(5,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPostOrder()
	{
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		tree.insert(12);
		tree.insert(15);
	
		Iterator<Node> iterator = tree.postOrder();
		
		//
		assertEquals(5,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(12,iterator.next().value);
		assertEquals(30,iterator.next().value);
		assertEquals(20,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPostOrderV2()
	{
		this.initV2();
	
		Iterator<Node> iterator = tree.postOrder();
		
		//[6,4,8,11,14,25,15,13,10]
		assertEquals(6,iterator.next().value);
		assertEquals(4,iterator.next().value);
		assertEquals(8,iterator.next().value);
		assertEquals(11,iterator.next().value);
		assertEquals(14,iterator.next().value);
		assertEquals(25,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(13,iterator.next().value);
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
		
		Iterator<Node> iterator = tree.preOrderIterative();
		
		assertEquals(10,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	//@Test
	public void testPreOrderLevel2()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * 		 /	
		 * 		4
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(4);
		
		Iterator<Node> iterator = tree.preOrderIterative();
		
		assertEquals(10,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(4,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
}
