package com.turing.dsa.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MaxHeapTest {
	MaxHeap heap = new MaxHeap();
	
	@Test
	public void testInsertAtRoot()
	{
		/*
		 * 			10
		 * 		
		 * */
		heap.insert(10);
		Integer root = heap.getRoot();
		assertEquals(10,root);
	}
	@Test
	public void testInsertChild()
	{
		/*
		 * 			10
		 * 		
		 * */
		heap.insert(10);
		heap.insert(15);
		
		/*
		 * 			15
		 * 			/
		 * 			10
		 * */
		Integer root = heap.getRoot();
		assertEquals(15,root);
		
		assertEquals(10,heap.leftOf(15));
	}
	@Test
	public void testInsertTwoChild()
	{
		heap.insert(10);
		heap.insert(15);
		/*
		 * 			15
		 * 			/
		 * 			10
		 * 		
		 * */
		heap.insert(20);
		
		/*
		 * 			20
		 * 			/\
		 * 		  10  15
		 * */
		Integer root = heap.getRoot();
		assertEquals(20,root);
		
		assertEquals(10,heap.leftOf(20));
		assertEquals(15,heap.rightOf(20));
	}
	@Test
	public void testInsertAnotherLevelNoTickle()
	{
		heap.insert(10);
		heap.insert(15);
		heap.insert(20);
		/*
		 * 			20
		 * 			/\
		 * 		  10  15
		 * 		
		 * */
		heap.insert(9);
		
		/*
		 * 			20
		 * 			/\
		 * 		  10  15
		 * 		/
		 * 		9
		 * */
		Integer root = heap.getRoot();
		assertEquals(20,root);
		
		assertEquals(10,heap.leftOf(20));
		assertEquals(15,heap.rightOf(20));
		
		assertEquals(9,heap.leftOf(10));
	}
	@Test
	public void testInsertAnotherLevelTickle()
	{
		heap.insert(10);
		heap.insert(15);
		heap.insert(20);
		/*
		 * 			20
		 * 			/\
		 * 		  10  15
		 * 		
		 * */
		heap.insert(21);
		
		/*
		 * 			21
		 * 			/\
		 * 		  20  15
		 * 		/
		 * 		10
		 * */
		Integer root = heap.getRoot();
		
		//System.out.println("Heap "+Arrays.toString(heap.items));
		assertEquals(21,root);
		
		assertEquals(20,heap.leftOf(21));
		assertEquals(15,heap.rightOf(21));
		
		assertEquals(10,heap.leftOf(20));
	}
	@Test
	public void testInsertAnotherLevelRightTickle()
	{
		heap.insert(10);
		heap.insert(15);
		heap.insert(20);
		heap.insert(21);
		/*
		 * 			21
		 * 			/\
		 * 		  20  15
		 * 		/
		 * 		10
		 * 		
		 * */
		
		heap.insert(25);
		/*
		 * 			25
		 * 			/\
		 * 		  21  15
		 * 		/  \ 
		 * 		10  20
		 * */
		Integer root = heap.getRoot();
		
		//System.out.println("Heap "+Arrays.toString(heap.items));
		assertEquals(25,root);
		
		assertEquals(21,heap.leftOf(25));
		assertEquals(15,heap.rightOf(25));
		
		assertEquals(10,heap.leftOf(21));
		assertEquals(20,heap.rightOf(21));
	}
	@Test
	public void testRemoveOnlyRoot()
	{
		heap.insert(21);
		
		
		/*
		 * 			21
		 * 			/\
		 * 		
		 * 		/
		 * 		
		 * 		
		 * */
		Integer deletedItem = heap.remove();
		
		assertEquals(21,deletedItem);
	
	}
	@Test
	public void testRemoveOnlyChild()
	{
		heap.insert(21);
		heap.insert(10);
		
		/*
		 * 			21
		 * 			/\
		 * 		10
		 * 		
		 * 		
		 * 		
		 * */
		Integer deletedItem = heap.remove();
		
		assertEquals(21,deletedItem);
		assertEquals(10,heap.getRoot());
	}
	@Test
	public void testRemoveTwoChild()
	{
		heap.insert(21);
		heap.insert(10);
		heap.insert(19);
		
		/*
		 * 			21
		 * 			/\
		 * 		10    19
		 * 		
		 * 		
		 * 		
		 * */
		Integer deletedItem = heap.remove();
		
		assertEquals(21,deletedItem);
		
		/*
		 * 			19
		 * 			/\
		 * 		10    
		 * 		
		 * 		
		 * 		
		 * */
		assertEquals(19,heap.getRoot());
		assertEquals(10,heap.leftOf(19));
	}
	@Test
	public void testRemoveTickeDown()
	{
		heap.insert(21);
		heap.insert(20);
		heap.insert(15);
		
		/*
		 * 			21
		 * 			/\
		 * 		  20  15
		 * 		/
		 * 		
		 * 		
		 * */
		Integer deletedItem = heap.remove();
		/*
		 * 			20
		 * 			/\
		 * 		  15  
		 * 		
		 * 		
		 * 		
		 * */
		assertEquals(21,deletedItem);
		
		Integer root = heap.getRoot();
		
		assertEquals(20,root);
		assertEquals(15,heap.leftOf(20));
	}
	@Test
	public void testRemoveDeeperLevelTickeDown()
	{
		heap.insert(21);
		heap.insert(20);
		heap.insert(15);
		heap.insert(18);
		heap.insert(19);
		heap.insert(14);
		
		/*
		 * 			21
		 * 			/\
		 * 		  20     15
		 * 		/  \     /
		 * 		18 19   14 
		 * 		
		 * */
		Integer deletedItem = heap.remove();
		/*
		 * 			20
		 * 			/\
		 * 		  19     15
		 * 		/  \     /
		 * 		18 14    
		 * 		
		 * 		
		 * 		
		 * */
		assertEquals(21,deletedItem);
		
		Integer root = heap.getRoot();
		
		assertEquals(20,root);
		assertEquals(19,heap.leftOf(20));
		assertEquals(15,heap.rightOf(20));
		
		assertEquals(18,heap.leftOf(19));
		assertEquals(14,heap.rightOf(19));
		
		
	}
	@Test
	public void testMaxHeapBug()
	{
		//293, 35, 118, 56, 209, 358, 784, 259, 110, 245
		heap.insert(293);
		heap.insert(35);
		heap.insert(118);
		heap.insert(56);
		heap.insert(209);
		heap.insert(358);
		heap.insert(784);
		heap.insert(259);
		heap.insert(110);
		heap.insert(245);
		/*
					 784
			        /   \
		       259      358
		       /\       /  \ 
		   209    245   118  293
		  /\       /
		35  110.   56
		
		
		         784
		        /      \
		       259      358
		      / \.       /\
		    209  245.  118  293
		    /\.    /
		   35  110 56
		 * */
		
		Integer root = heap.getRoot();
		assertEquals(784,root);
		
		assertEquals(259,heap.leftOf(root));
		assertEquals(358,heap.rightOf(root));
		
		assertEquals(209,heap.leftOf(259));
		assertEquals(245,heap.rightOf(259));
		
		assertEquals(118,heap.leftOf(358));
		assertEquals(293,heap.rightOf(358));
		
		assertEquals(35,heap.leftOf(209));
		assertEquals(110,heap.rightOf(209));
		
		assertEquals(56,heap.leftOf(245));
		
		//int[]output = new int[]{784, 358, 293, 259, 245, 209, 118, 56, 110, 35};
		int[]output = new int[]{784, 358, 293, 259, 245, 209, 118,  110,56, 35};
		
		for(int i=0;i<output.length;i++)
		{
			assertEquals(output[i],heap.remove());
		}
		
	}
	
	@Test
	public void testReplicate()
	{
		// 209, 118, 56, 110, 35
		
		heap.insert(118);
		heap.insert(110);
		heap.insert(35);
		heap.insert(56);
		
		assertEquals(118,heap.remove());
		assertEquals(110,heap.remove());
		assertEquals(56,heap.remove());
		assertEquals(35,heap.remove());
		
	}
	
}
