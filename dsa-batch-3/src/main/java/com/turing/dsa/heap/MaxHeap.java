package com.turing.dsa.heap;

public class MaxHeap {
	Integer[] items = new Integer[100];
	int noOfNode = 0;
	
	Integer getRoot()
	{
		return this.items[0];
	}
	void insert(int value)
	{
		int childIndex = this.noOfNode;
		this.items[this.noOfNode++]= value;
		
		int parentIndex = this.getParentIndex(childIndex);
	
		//tickle up
		while(parentIndex >= 0 )
		{
			Integer parent = this.items[parentIndex];
			Integer child = this.items[childIndex];
			if(child > parent)
			{
				//swap
				this.items[parentIndex] = child;
				this.items[childIndex] = parent;
				
				childIndex = parentIndex;
				parentIndex = this.getParentIndex(childIndex);
			}
			else
			{
				break;
			}
		}
		
	}
	public Integer remove() {
		Integer root = this.items[0];
		int lastChildIndex = this.noOfNode-1;
		
		this.items[0] = this.items[lastChildIndex];
		this.items[lastChildIndex] = null;
		this.noOfNode--;
		
		lastChildIndex = this.noOfNode-1;
		
		int parentIndex = 0;
		int leftIndex = parentIndex *2 + 1;
		int rightIndex = parentIndex *2 + 2;
		
		while( (leftIndex <= lastChildIndex) || (rightIndex <= lastChildIndex ) )
		{
			Integer parent = this.items[parentIndex];
			Integer left = this.items[leftIndex];
			Integer right = this.items[rightIndex];
			
			int maxChildIndex = parentIndex;
			if(left !=null && right != null)//two node
			{
				System.out.println("Two child case right "+right + " left "+left);
				if(this.items[leftIndex] > this.items[maxChildIndex])
				{
					maxChildIndex = leftIndex;
				}
				if(this.items[rightIndex]> this.items[maxChildIndex])
				{
					System.out.println("Right child is larger right "+right + " left "+left);
					maxChildIndex = rightIndex;
				}
			}
			else if(left !=null)//one child
			{
				if(left > parent)
				{
					maxChildIndex = leftIndex;
				}
				
			}
			if(maxChildIndex != parentIndex)
			{
				
				this.items[parentIndex] = this.items[maxChildIndex];
				this.items[maxChildIndex] = parent;
				
				parentIndex = maxChildIndex;
				leftIndex = parentIndex *2 + 1;
				rightIndex = parentIndex *2 + 2;
			}
			else
			{
				break;//stable no change,heap property ok
			}
		}
		return root;
	}
	
	int getParentIndex(int childIndex)
	{
		if(isLeftChild(childIndex))
		{
			return (childIndex-1)/2;
		}
		else
		{
			return (childIndex-2)/2;
		}
	}
	boolean isLeftChild(int index)
	{
		return index %2 == 1;
	}
	boolean isRightChild(int index)
	{
		return index %2 == 0;
	}
	int getIndexOfNode(int value)
	{
		int index = 0;
		for(int i=0;i< this.noOfNode;i++)
		{
			if(this.items[i]==value)
			{
				return i;
			}
		}
		return -1;
	}
	public Integer leftOf(int value) {
		int indexOfParent = this.getIndexOfNode(value);
		//System.out.println("node "+value + " Index is "+indexOfParent);
		int leftNodeIndex = indexOfParent * 2 + 1;
		return this.items[leftNodeIndex];
	}

	public Integer rightOf(int value) {
		int indexOfParent = this.getIndexOfNode(value);
		//System.out.println("node "+value + " Index is "+indexOfParent);
		int leftNodeIndex = indexOfParent * 2 + 2;
		return this.items[leftNodeIndex];
	}
	

}
