package com.turing.dsa.tree.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;



public class NodeTest {

	TwoThreeFourTree tree = new TwoThreeFourTree();
	
	/*
	
	*/
	//@Test
	public void testBasicSplitTwoNode()
	{
		
		Node node = new Node();
		node.insert(5);
		node.insert(1);
		node.insert(2);
		
		
		/*
		 * 			split
		 * 			[2]
		 * 		[1]   [5]
		 * */
		
		Node parent = node.split();
		assertEquals(2,parent.keys[0]);
		assertEquals(2,parent.children.size());
		
		Node left = parent.children.get(0);
		assertEquals(1,left.keys[0]);
		
		Node right = parent.children.get(1);
		assertEquals(5,right.keys[0]);
	}
	//@Test
	public void testNonFourTreeSplitDoNothing()
	{
		
		Node node = new Node();
		node.insert(5);
		node.insert(1);
		
		Node parent = node.split();
		assertEquals(parent,node);
	
	}
	//@Test
	public void testSearchLeafToInsert()
	{
		Node node = new Node();
		node.insert(5);
		node.insert(1);
		
		Node insertNode = node.searchToInsert(4);
		assertEquals(node,insertNode);
	}
	//@Test
	public void testSearchSplitTwoNode()
	{
		
		Node node = new Node();
		node.insert(5);
		node.insert(1);
		node.insert(2);
		
		
		/*
		 * 			split
		 * 			[2]
		 * 		[1]   [5]
		 * */
		
		Node parent = node.split();
		Node leafToInsert = parent.searchToInsert(4);
		Node rightChild = parent.children.get(1);
		
		assertEquals(rightChild,leafToInsert);
	}
	//@Test
	public void testSearchSplitTwoNodeRightChild()
	{
		
		Node node = new Node();
		node.insert(15);
		node.insert(20);
		node.insert(10);
		
		//10,15,20
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20]
		 * */
		
		Node parent = node.split();
		Node leafToInsert = parent.searchToInsert(5);
		Node leftChild = parent.children.get(0);
		
		assertEquals(leftChild,leafToInsert);
	}
	//@Test
	public void testSearchSplitTwoNodeLeftChildInsert()
	{
		
		Node node = new Node();
		node.insert(15);
		node.insert(20);
		node.insert(10);
		
		//10,15,20
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20]
		 * */
		Node insertedLeaf = node.insert(5);
		
		/*
		 * 			split
		 * 			[15]
		 * 		[5,10]   [20]
		 * */
		Node parent = insertedLeaf.getParent();
		assertEquals(15,parent.keys[0]);
		
		assertEquals( insertedLeaf,parent.children.get(0));
		
		assertEquals(5,insertedLeaf.keys[0]);
		assertEquals(10,insertedLeaf.keys[1]);
	}
	//@Test
	public void testSearchSplitTwoNodeRightChildInsert()
	{
		
		Node node = new Node();
		node.insert(15);
		node.insert(20);
		node.insert(10);
		
		//10,15,20
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20]
		 * */
		Node insertedLeaf = node.insert(30);
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20,30]
		 * */
		Node parent = insertedLeaf.getParent();
		assertEquals(15,parent.keys[0]);
		
		//right child
		assertEquals( insertedLeaf,parent.children.get(1));
		
		assertEquals(20,insertedLeaf.keys[0]);
		assertEquals(30,insertedLeaf.keys[1]);
	}
	
	//@Test
	public void testBasicInsertIssue()
	{
		Node node = new Node();
		node.insert(20);
		node.insert(30);
		node.insert(21);
		
		assertEquals(20,node.keys[0]);
		assertEquals(21,node.keys[1]);
		assertEquals(30,node.keys[2]);
	}
	
	@Test
	public void testSearchInsertTwoNodeFull()
	{
		
		Node node = new Node();
		node.insert(15);
		node.insert(20);
		node.insert(10);
		node.insert(30);
		/*
		 * Need to use tree instead of node
		 * issue in split , causing current node to split
		 * node.insert(30) cause node to split, but current node is discarded. 
		 * And node.searchToInsert search the node starting from discarded node
		 * we need to search from root node of tree.
		 * */
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20,30];
		 * */
		Node insertedLeaf = node.searchToInsert(21);
		
		System.out.println("Insert At *****=>"+Arrays.toString(insertedLeaf.keys));
		Node parent = insertedLeaf.getParent();
		assertEquals(15,parent.keys[0]);
		
		//right child
		Node rightChild = parent.children.get(1);
		assertEquals( insertedLeaf,rightChild);
		
		System.out.println("Right child==> "+ Arrays.toString(rightChild.keys));
		assertEquals(20,rightChild.keys[0]);
		assertEquals(30,rightChild.keys[1]);
		
	}
	//@Test
	public void testInsertTwoNodeFull()
	{
		
		Node node = new Node();
		node.insert(15);
		node.insert(20);
		node.insert(10);
		node.insert(30);
		
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20,30];
		 * */
		Node insertedLeaf = node.insert(21);
		
		/*
		 * 			split
		 * 			[15]
		 * 		[10]   [20,21,30]
		 * */
		Node parent = insertedLeaf.getParent();
		assertEquals(15,parent.keys[0]);
		
		//right child
		Node rightChild = parent.children.get(1);
		assertEquals( insertedLeaf,rightChild);
		
		System.out.println("Right child==> "+ Arrays.toString(rightChild.keys));
		assertEquals(20,rightChild.keys[0]);
		assertEquals(21,rightChild.keys[1]);
		assertEquals(30,rightChild.keys[2]);
	}
}
