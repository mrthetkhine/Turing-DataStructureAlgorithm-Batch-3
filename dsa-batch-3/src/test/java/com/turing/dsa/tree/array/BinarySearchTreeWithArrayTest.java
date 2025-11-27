package com.turing.dsa.tree.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.tree.BstWithArray;

public class BinarySearchTreeWithArrayTest {
	
	BstWithArray tree = new BstWithArray();
	
	@Test
	public void testInsertAtRoot()
	{
		/*
		 * 			10
		 * 		
		 * */
		tree.insert(10);
		Integer root = tree.getRoot();
		assertEquals(10,root);
	}
	@Test
	public void testTreeInsertLeftChild()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  
		 * */
		tree.insert(10);
		tree.insert(5);
		
		
		Integer left = tree.leftOf(10);
		assertEquals(5,left);
	}
	@Test
	public void testTreeInsertRightChild()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  20
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		
		Integer right = tree.rightOf(10);
		assertEquals(20,right);
	}
	@Test
	public void testInsertComplexTree()
	{
		/*				
		 * 				10
		 * 				/\
		 * 			5	  20
		 * 				/	\
		 * 				12  30
		 * 				 \
		 * 				  15	
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.insert(12);
		tree.insert(30);
		tree.insert(15);
		
		assertEquals(5,tree.leftOf(10));
		assertEquals(20,tree.rightOf(10));
		
		System.out.println("After 20 rightOf(10)");
		
		assertEquals(12,tree.leftOf(20));
		System.out.println("After 12 leftOf(20)");
		assertEquals(30,tree.rightOf(20));
		
		assertEquals(null,tree.leftOf(12));
		assertEquals(15,tree.rightOf(12));
	}
	
}
