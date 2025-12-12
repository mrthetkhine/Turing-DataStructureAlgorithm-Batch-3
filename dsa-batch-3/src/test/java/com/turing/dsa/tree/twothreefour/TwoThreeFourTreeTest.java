package com.turing.dsa.tree.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TwoThreeFourTreeTest {
	TwoThreeFourTree tree = new TwoThreeFourTree();
	
	//@Test
	public void testInsertBase()
	{
		tree.insert(10);
		Node node = tree.getRoot();
		assertEquals(10,node.keys[0]);
	}
	//@Test
	public void testInsertBase2()
	{
		tree.insert(10);
		tree.insert(5);
		
		Node node = tree.getRoot();
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
	
	}
	//@Test
	public void testInsertBase3()
	{
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		
		Node node = tree.getRoot();
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
		assertEquals(20,node.keys[2]);
	
	}

	//@Test
	public void testInsertBase4()
	{
		
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		
		Node node = tree.getRoot();
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
		assertEquals(20,node.keys[2]);
	
	}
	//@Test
	public void testInsertBase5()
	{

		tree.insert(5);
		tree.insert(10);
		tree.insert(20);
		
		Node node = tree.getRoot();
		
		assertEquals(5,node.keys[0]);
		assertEquals(10,node.keys[1]);
		assertEquals(20,node.keys[2]);
	
	}
	//@Test
	public void testInsertBase6()
	{
		
		tree.insert(5);
		tree.insert(10);
		tree.insert(2);
		
		Node node = tree.getRoot();
		
		assertEquals(2,node.keys[0]);
		assertEquals(5,node.keys[1]);
		assertEquals(10,node.keys[2]);
	
	}
	//@Test
	public void testInsertBase7()
	{
	
		tree.insert(5);
		tree.insert(1);
		tree.insert(2);
		
		Node node = tree.getRoot();
		
		assertEquals(1,node.keys[0]);
		assertEquals(2,node.keys[1]);
		assertEquals(5,node.keys[2]);
	
	}
	//@Test
	/*
	public void testBasicSplitTwoNode()
	{
		
		tree.insert(5);
		tree.insert(1);
		tree.insert(2);
		
		
		
		Node node = tree.getRoot();
		Node parent = node.split();
		assertEquals(2,parent.keys[0]);
		assertEquals(2,parent.children.size());
		
		Node left = parent.children.get(0);
		assertEquals(1,left.keys[0]);
		
		Node right = parent.children.get(1);
		assertEquals(5,right.keys[0]);
	}
	*/
	//@Test
	public void testSearchSplitTwoNodeLeftChildInsert()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		
		//10,15,20
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20]
		 * */
		tree.insert(5);
		
		/*
		 * 			split
		 * 			[15]
		 * 		[5,10]   [20]
		 * */
		Node parent = tree.getRoot();
		assertEquals(15,parent.keys[0]);
		
		Node insertedLeaf = parent.children.get(0);
		
		assertEquals(5,insertedLeaf.keys[0]);
		assertEquals(10,insertedLeaf.keys[1]);
	}
	//@Test
	public void testSearchSplitTwoNodeLeftChildInsert2()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		
		
		/*
		 * 			split
		 * 			[15]
		 * 		[5,10]   [20]
		 * */
		tree.insert(12);
		
		
				/*
				 * 		split
				 * 				[15]
				 * 		[5,10,12]   [20]
				 * */
				
		Node parent = tree.getRoot();
		assertEquals(15,parent.keys[0]);
		
		Node insertedLeaf = parent.children.get(0);
		
		assertEquals(5,insertedLeaf.keys[0]);
		assertEquals(10,insertedLeaf.keys[1]);
		assertEquals(12,insertedLeaf.keys[2]);
	}
	//@Test
	public void testSplitPromote()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(12);
		
		/*
		 * 		split
		 * 				[15]
		 * 		[5,10,12]   [20]
		 * */
		tree.insert(13);
		
		/*
		 * 		split
		 * 				[10,15]
		 * 		[5] [12,13]   [20]
		 * */
				
				
		Node parent = tree.getRoot();
		assertEquals(10,parent.keys[0]);
		assertEquals(15,parent.keys[1]);
		
		Node leftChild = parent.children.get(0);
		assertEquals(5,leftChild.keys[0]);
		
		Node insertedLeaf = parent.children.get(1);
		
		assertEquals(12,insertedLeaf.keys[0]);
		assertEquals(13,insertedLeaf.keys[1]);
		
		Node thirdChild = parent.children.get(2);
		assertEquals(20,thirdChild.keys[0]);
		
	}
	//@Test
	public void testSplitPromote2()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(12);
		tree.insert(13);
		
		/*
		 * 			split
		 * 				[10,15]
		 * 		[5] [12,13]   [20]
		 * */
		
		tree.insert(25);
		/*
		 * 		
		 * 				[10,15]
		 * 		[5] [12,13]   [20,25]
		 * */
				
				
		Node parent = tree.getRoot();
		assertEquals(10,parent.keys[0]);
		assertEquals(15,parent.keys[1]);
		
		Node leftChild = parent.children.get(0);
		assertEquals(5,leftChild.keys[0]);
		
		Node insertedLeaf = parent.children.get(1);
		
		assertEquals(12,insertedLeaf.keys[0]);
		assertEquals(13,insertedLeaf.keys[1]);
		
		Node thirdChild = parent.children.get(2);
		assertEquals(20,thirdChild.keys[0]);
		assertEquals(25,thirdChild.keys[1]);
	}
	@Test
	public void testSplitPromote3()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(12);
		tree.insert(13);
		tree.insert(25);
		
		/*
		 * 		    [10,15]
		 * 		[5] [12,13]   [20,25]
		 * */
		
		tree.insert(30);
		/*
		 * 		
		 * 				[10,15]
		 * 		[5] [12,13]   [20,25,30]
		 * */
				
				
		Node parent = tree.getRoot();
		assertEquals(10,parent.keys[0]);
		assertEquals(15,parent.keys[1]);
		
		Node leftChild = parent.children.get(0);
		assertEquals(5,leftChild.keys[0]);
		
		Node insertedLeaf = parent.children.get(1);
		
		assertEquals(12,insertedLeaf.keys[0]);
		assertEquals(13,insertedLeaf.keys[1]);
		
		Node thirdChild = parent.children.get(2);
		assertEquals(20,thirdChild.keys[0]);
		assertEquals(25,thirdChild.keys[1]);
		assertEquals(30,thirdChild.keys[2]);
	}
	@Test
	public void testSplitPromote4()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(12);
		tree.insert(13);
		tree.insert(25);
		tree.insert(30);
		/*			
		 * 				[10,15]
		 * 		[5] [12,13]   [20,25,30]
		 * */
		
		tree.insert(40);
		/*
		 * 		
		 * 				[10,15,25]
		 * 		[5] [12,13]   [20] [30,40]
		 * */
				
				
		Node parent = tree.getRoot();
		assertEquals(10,parent.keys[0]);
		assertEquals(15,parent.keys[1]);
		assertEquals(25,parent.keys[2]);
		
		Node firstChild = parent.children.get(0);
		assertEquals(5,firstChild.keys[0]);
		
		Node secondChild = parent.children.get(1);
		
		assertEquals(12,secondChild.keys[0]);
		assertEquals(13,secondChild.keys[1]);
		
		Node thirdChild = parent.children.get(2);
		assertEquals(20,thirdChild.keys[0]);
	
		
		Node fourthChild = parent.children.get(3);
		assertEquals(30,fourthChild.keys[0]);
		assertEquals(40,fourthChild.keys[1]);
		
	}
	@Test
	public void testSplitPromoteTwoLevel()
	{
		
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(12);
		tree.insert(13);
		tree.insert(25);
		tree.insert(30);
		tree.insert(40);
		tree.insert(26);
		/*			
		 * 	
		 * 				[10,15,25]
		 * 		[5] [12,13]   [20] [26,30,40]
		 * */
		
		tree.insert(50);
		/*
		 * 					[15]
		 * 				[10]      [25,30]
		 * 		[5] [12,13]   [20] [26] [40,50]
		 * */
				
				
		Node parent = tree.getRoot();
		assertEquals(15,parent.keys[0]);
		
		Node level1LeftChild = parent.children.get(0);
		assertEquals(10,level1LeftChild.keys[0]);
		
		
		
		Node level2LeftChild = level1LeftChild.children.get(0);
		assertEquals(5,level2LeftChild.keys[0]);
		
		Node level2RightChild = level1LeftChild.children.get(1);
		assertEquals(12,level2RightChild.keys[0]);
		assertEquals(13,level2RightChild.keys[1]);
		
		Node level1RightChild = parent.children.get(1);
		assertEquals(25,level1RightChild.keys[0]);
		assertEquals(30,level1RightChild.keys[1]);
		
		Node firstChild = level1RightChild.children.get(0);
		
		assertEquals(20,firstChild.keys[0]);
		
		Node secondChild = level1RightChild.children.get(1);
		assertEquals(26,secondChild.keys[0]);
		
		Node thirdChild = level1RightChild.children.get(2);
		assertEquals(40,thirdChild.keys[0]);
		assertEquals(50,thirdChild.keys[1]);
		
		
	}
}
