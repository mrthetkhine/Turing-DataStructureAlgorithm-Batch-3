package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class BinaryTreeDeleteTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	
	@Test
	public void testDeleteLeafRightChild()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		tree.delete(20);
		
		/*		
		 * 			10
		 * 			/\
		 * 		   5  
		 * */
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(5,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	

	}
	@Test
	public void testDeleteLeafLeftChild()
	{
		/*		
		 * 			10
		 * 			/\
		 * 		   5  20
		 * */
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		
		tree.delete(5);
		
		/*		
		 * 			10
		 * 			/\
		 * 		     20
		 * */
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(10,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	

	}
	@Test
	public void testSuccessorBase()
	{
		/*		
		 * 			5
		 * 			/\
		 * 		   4  10
		 * 			 / \
		 * 	        9   15	
		 * */
		tree.insert(5);
		tree.insert(4);
		tree.insert(10);
		tree.insert(9);
		tree.insert(15);
		
		Node successor = tree.getSuccessor(5);
		assertEquals(9,successor.value);
		
		successor = tree.getSuccessor(10);
		assertEquals(15,successor.value);
	}
	@Test
	public void testSuccessorMoreDepth()
	{
		/*		
		 * 			5
		 * 			/\
		 * 		   4  10
		 * 			 / \
		 * 	        9   15	
		 * 				/\
		 * 			   13 20
		 * */
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(10);
		tree.insert(9);
		tree.insert(15);
		tree.insert(13);
		tree.insert(20);
		
		
		Node successor = tree.getSuccessor(5);
		assertEquals(9,successor.value);
		
		successor = tree.getSuccessor(10);
		assertEquals(13,successor.value);
	

	}
	@Test
	public void testDeleteTwoChild()
	{
		/*		
		 * 			5
		 * 			/\
		 * 		   4  10
		 * 			 / \
		 * 	        9   15	
		 * */
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(10);
		tree.insert(9);
		tree.insert(15);
		
		tree.delete(10);
		
		/*		
		 * 			5
		 * 			/\
		 * 		   4  15
		 * 			 / \
		 * 	        9  	
		 * */
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(4,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(15,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	

	}
	@Test
	public void testDeleteNonLeafPromoteLeftChild()
	{
		/*		
		 * 			5
		 * 			/\
		 * 		   4  10
		 * 			 / \
		 * 	        9   	
		 * */
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(10);
		tree.insert(9);
		
		
		tree.delete(10);
		
		/*		
		 * 			5
		 * 			/\
		 * 		   4  9
		 * 			
		 * */
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(4,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(9,iterator.next().value);
		
		
		assertFalse(iterator.hasNext());
	

	}
	//@Test
	public void testDeleteWithSuccesorMoreDepth()
	{
		/*		
		 * 			5
		 * 			/\
		 * 		   4  10
		 * 			 / \
		 * 	        9   15	
		 * 				/\
		 * 			   13 20
		 * */
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(10);
		tree.insert(9);
		tree.insert(15);
		tree.insert(13);
		tree.insert(20);
		
		tree.delete(10);
		
		/*		
		 * 			5
		 * 			/\
		 * 		   4  13
		 * 			 / \
		 * 	        9  	15
		 * 				/\
		 * 			      20
		 * */
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(4,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(13,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	

	}
	
	@Test
	public void testDeleteWithSuccesorMoreDepth2()
	{
		/*
		 * 			5
		 * 			/\
		 * 		   4  15
		 * 			 / \
		 * 	        9   20	
		 * 			 \ 	
		 * 			  13 
		 */ 
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(15);
		tree.insert(9);
		tree.insert(20);
		tree.insert(13);
	
		
		tree.delete(15);
		
		 /*
		 * 			5
		 * 			/\
		 * 		   4  20
		 * 			 / \
		 * 	        9  	
		 * 			 \
		 *            13
		 */ 
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(4,iterator.next().value);
		assertEquals(5,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(13,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	

	}
	
	@Test
	public void testDeleteRoot()
	{
	     /*			
		 * 			5
		 * 			/\
		 * 		   4  15
		 * 			 / \
		 * 	        9   20	
		 * 			 \ 	
		 * 			  13 
		 */ 
		
		tree.insert(5);
		tree.insert(4);
		tree.insert(15);
		tree.insert(9);
		tree.insert(20);
		tree.insert(13);
	
		
		tree.delete(5);
		
		/*		
		 * 			9
		 * 			/\
		 * 		   4  15
		 * 			 / \
		 * 	        13   20	
		 * 			  
		 */ 
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(4,iterator.next().value);
		assertEquals(9,iterator.next().value);
		assertEquals(13,iterator.next().value);
		assertEquals(15,iterator.next().value);
		assertEquals(20,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	

	}
	
	@Test
	public void testDeleteRootPromoteLeft()
	{
		 /*		
		 * 			15
		 * 			/\
		 * 		   10 
		 * 	      /  \
		 *        8  12
		 */
		
		tree.insert(15);
		tree.insert(10);
		tree.insert(8);
		tree.insert(12);
		
	
		
		tree.delete(15);
		
	     /*			
		 * 			10
		 * 			/\
		 * 		   12
		 * 	      /  \
		 *        8  
		 */	
		Iterator<Node> iterator = tree.inOrderIterative();
		
		assertEquals(8,iterator.next().value);
		assertEquals(12,iterator.next().value);
		assertEquals(10,iterator.next().value);
		
		assertFalse(iterator.hasNext());
	
	}
	
}
