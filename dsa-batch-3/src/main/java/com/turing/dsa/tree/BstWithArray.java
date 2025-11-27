package com.turing.dsa.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.turing.dsa.tree.BinarySearchTree.InorderTraversalIterative;

public class BstWithArray {

	Integer[] items = new Integer[100];
	
	public void insert(int value) {
		
		//start from root
		int index = 0;
		Integer current = items[index];
		if(current == null)
		{
			items[index] = value;
		}
		else
		{
			while(current != null)
			{
				if(value < current )
				{
					index = index * 2 +1;
				}
				else if(value > current)
				{
					index = index * 2+ 2;
				}
				current = this.items[index];
			}
			this.items[index] = value;
			
			
		}
	}
	int getIndexOfNode(int value)
	{
		int index = 0;
		Integer current = items[index];
		if(current == value)
		{
			return index;
		}
		else
		{
			while(current != null)
			{
				if(current == value)
				{
					return index;
				}
				else if(value < current )
				{
					index = index * 2 +1;
				}
				else if(value > current)
				{
					index = index * 2+ 2;
				}
				current = this.items[index];
			}
			return index;
			
		}
		
	}
	public Integer leftOf(int value) {
		int indexOfParent = this.getIndexOfNode(value);
		System.out.println("node "+value + " Index is "+indexOfParent);
		int leftNodeIndex = indexOfParent * 2 + 1;
		return this.items[leftNodeIndex];
	}

	public Integer rightOf(int value) {
		int indexOfParent = this.getIndexOfNode(value);
		System.out.println("node "+value + " Index is "+indexOfParent);
		int leftNodeIndex = indexOfParent * 2 + 2;
		return this.items[leftNodeIndex];
	}

	public Integer getRoot() {
		
		return this.items[0];
	}
	
	public Iterator<Integer> inOrder() {
		
		return new InorderTraversal();
	}
	class InorderTraversal implements Iterator<Integer>
	{
		//left Root right
		List<Integer> visisted = new ArrayList<Integer>();
		
		InorderTraversal()
		{
			int rootIndex = 0;
			this.traverse(rootIndex);
		}
		void traverse(int index)
		{
			Integer left = this.getLeftChild(index);
			if(left != null)
			{
				//go to left
				this.traverse(index*2+1);
			}
			Integer current = items[index];
			if(current !=null)
			{
				this.visisted.add(current);
			}
			Integer right = this.getRightChild(index);
			if(right != null)
			{
				//go to right
				this.traverse(index*2+2);
			}
			
		}
		Integer getLeftChild(int index)
		{
			int leftIndex = index*2 + 1;
			Integer left = items[leftIndex];
			return left;
		}
		Integer getRightChild(int index)
		{
			int rightIndex = index*2 + 2;
			Integer left = items[rightIndex];
			return left;
		}
		@Override
		public boolean hasNext() {
			
			return !this.visisted.isEmpty();
		}

		
		@Override
		public Integer next() {
			return this.visisted.remove(0);
		}

		
	}

}
