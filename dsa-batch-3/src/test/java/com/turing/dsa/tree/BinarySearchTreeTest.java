package com.turing.dsa.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.sorting.SortingUtil;

public class BinarySearchTreeTest {
	
	BinarySearchTree tree = new BinarySearchTree();
	@Test
	public void testInsertAtRoot()
	{
		
		tree.insert(10);
		Node root = tree.getRoot();
		assertEquals(10,root.value);
	}
	
	@Test
	public void testRootLeafInsertRight()
	{
		
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(20);
		
		Node right = root.getRight();
		assertEquals(20,right.getValue());
	}
	@Test
	public void testRootLeafInertLeft()
	{
		
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(5);
		
		Node left = root.getLeft();
		
		assertEquals(5,left.getValue());
	}
	//[10,20,5,30,12,15]
	@Test
	public void testRootNonLeafInsert()
	{
		
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(20);
		tree.insert(5);
		
		Node left = root.getLeft();
		Node right = root.getRight();
		
		assertEquals(5,left.getValue());
		assertEquals(20,right.getValue());
	}
	///[10,20,5,30,12,15]
	@Test
	public void testRootNonLeafComplex()
	{
		
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		
		Node left = root.getLeft();
		Node right = root.getRight();
		
		Node rootRightOfRight = right.getRight();
		
		assertEquals(5,left.getValue());
		assertEquals(20,right.getValue());
		assertEquals(30,rootRightOfRight.getValue());
	}
	///[10,20,5,30,12,15]
	/*				
	 * 				10
	 * 				/\
	 * 			5	  20
	 * 				/	\
	 * 				12  30
	 * 				 \
	 * 				  15	
	 * */
	@Test
	public void testRootNonLeafComplete()
	{
		
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		tree.insert(12);
		tree.insert(15);
		
		Node left = root.getLeft();
		Node node20 = root.getRight();
		
		Node node30 = node20.getRight();
		Node node12 = node20.getLeft();
		Node node15 = node12.getRight();
		
		assertEquals(5,left.getValue());
		assertEquals(20,node20.getValue());
		assertEquals(30,node30.getValue());
		assertEquals(12,node12.getValue());
		assertEquals(15,node15.getValue());
	}
	
	@Test
	public void testSearch()
	{
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		tree.insert(12);
		tree.insert(15);
		
		Node node20 = tree.search(20);
		assertEquals(20,node20.getValue());
		
		Node nodeNotFound = tree.search(13);
		assertEquals(null,nodeNotFound);
	}
	@Test
	public void testEdge()
	{
		tree.insert(10);
		Node root = tree.getRoot();
		
		assertEquals(10,root.value);
		
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		tree.insert(12);
		tree.insert(15);
		
		Node node = tree.search(10);
		assertEquals(10,node.getValue());
		
		node = tree.search(5);
		assertEquals(5,node.getValue());
		
		node = tree.search(12);
		assertEquals(12,node.getValue());
		
		node = tree.search(30);
		assertEquals(30,node.getValue());
		
		node = tree.search(15);
		assertEquals(15,node.getValue());
		
		
	}
	@Test
	public void testRandom()
	{
		for(int i=0;i < 35;i++)
		{
			BinarySearchTree tree = new BinarySearchTree();
			int[] random = SortingUtil.randomArray(30);
			
			for(int item : random)
			{
				tree.insert(item);
			}
			for(int item : random)
			{
				Node node = tree.search(item);
				assertEquals(item,node.getValue());
			}
		}
		
	}
}
