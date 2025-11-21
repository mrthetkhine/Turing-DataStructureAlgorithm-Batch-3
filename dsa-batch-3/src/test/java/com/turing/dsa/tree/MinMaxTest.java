package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class MinMaxTest {
BinarySearchTree tree = new BinarySearchTree();
	
	@Test
	public void testGetMinRoot()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   
		 * */
		
		tree.insert(10);
		int minValue = tree.getMinValue(); 
		
		assertEquals(10,minValue);
	

	}
	@Test
	public void testGetMinTwoChild()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		
		int minValue = tree.getMinValue(); 
		
		assertEquals(5,minValue);
	

	}
	@Test
	public void testGetMinTwoChild2()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		     20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		
	
		
		int minValue = tree.getMinValue(); 
		
		assertEquals(10,minValue);
	}
	@Test
	public void testGetMinComplexTree()
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
		
		int maxValue = tree.getMinValue(); 
		assertEquals(6,maxValue);
		
		
	}
	@Test
	public void testGetMaxRoot()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   
		 * */
		
		tree.insert(10);
		int maxValue = tree.getMaxValue(); 
		
		assertEquals(10,maxValue);
	

	}
	@Test
	public void testGetMaxTwoChild()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		
		int maxValue = tree.getMaxValue(); 
		
		assertEquals(20,maxValue);
	

	}
	@Test
	public void testGetMaxChildRight()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		     20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		
	
		
		int maxValue = tree.getMaxValue(); 
		
		assertEquals(20,maxValue);
	}
	@Test
	public void testGetMaxComplexTree()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   8  20
		 * 		  / \   \
		 * 		 6	 9  25
		 *                \
		 *                30
		 * */
		
		tree.insert(10);
		tree.insert(8);
		tree.insert(20);
		tree.insert(9);
		tree.insert(6);
		tree.insert(25);
		tree.insert(30);
		
		int maxValue = tree.getMaxValue(); 
		
		assertEquals(30,maxValue);
		
		
	}
}
