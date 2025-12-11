package com.turing.dsa.tree.twothreefour;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {

	int treeType = 1;//start from 2 tree
	Integer keys[] = new Integer[3];
	ArrayList<Node> children = new ArrayList<>();
	Node parent;
	
	public Node insert(int value)
	{
		if(this.treeType < 4 && this.isLeaf())
		{
			return this.simpleInsert(value);
		}
		else if(this.isFourTree())
		{
			System.out.println("This case split for insert value "+value+" ===> "+Arrays.toString(this.keys));
			
			Node parent = this.split();
			Node leafNode = parent.searchToInsert(value); 
			return leafNode.insert(value);
			
		}
		else
		{
			Node leafNode = this.searchToInsert(value); 
			return leafNode.insert(value);
		}
		
	}

	int getPositionToInsert(int value)
	{
		int index = 0;
		while(keys[index] != null 
				&& keys[index]< value 
				&& index < this.keys.length)
		{
			index ++;
		}
		System.out.println("getPositionToInsert nodes "+ Arrays.toString(this.keys));
		System.out.println("getPositionToInsert to insert "+index);
		
		return index;
	}
	Node simpleInsert(int value) {
		this.treeType ++;
		
		System.out.println("Value to insert---> "+value);
		System.out.println("Node to insert "+ Arrays.toString(this.keys));
		
		int index = 0;
		while(keys[index] != null 
				&& keys[index]< value 
				&& index < this.keys.length)
		{
			index ++;
		}
		
		System.out.println("Index to insert "+index);
		for(int i=keys.length-2; i >= index; i--)
		{
			keys[i+1] = keys[i];
		}
		keys[index] = value;
		System.out.println("After insert ----> "+ Arrays.toString(this.keys)+"\r\n");
		return this;
	}
	boolean isFourTree()
	{
		return this.treeType == 4;
	}
	Node split()
	{
		if(this.isFourTree() && this.parent==null)
		{
			System.out.println("Four Tree and no parent");
			
			int middleEle = this.keys[1];
			
			Node splitParent = new Node();
			splitParent.insert(middleEle);
			
			Node left = new Node();
			left.setParent(splitParent);
			left.insert(this.keys[0]);
			
			splitParent.children.add(left);
			
			Node right = new Node();
			
			right.insert(this.keys[2]);
			right.setParent(splitParent);
			
			splitParent.children.add(right);
			
			return splitParent;
		}
		else if(this.isFourTree() && this.parent != null)
		{
			System.out.println("Four Tree and have parent==>");
			System.out.println("Current leaf to insert ==> "+Arrays.toString(this.keys));
			System.out.println("Parent  ==> "+Arrays.toString(this.parent.keys));
			
			int middleEle = this.keys[1];
			System.out.println("Middle element "+middleEle);
			if(!this.parent.isFourTree())
			{
				int indexToInsert = this.parent.getPositionToInsert(middleEle);
				
				this.parent.simpleInsert(middleEle);
				
				int childIndex = this.parent.children.indexOf(this);
				
				this.parent.children.remove(childIndex);
				
				Node left = new Node();
				left.setParent(parent);
				left.insert(this.keys[0]);
				
				Node right = new Node();
				
				right.insert(this.keys[2]);
				right.setParent(parent);
				
				parent.children.add(indexToInsert, right);
				parent.children.add(indexToInsert, left);
				
				
				return parent;
			}
			else
			{
				System.out.println(">>>> parent is also 4 node");
			}
			
		}
		return this;
		
	}
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	boolean isLeaf()
	{
		return this.children.size()==0;
	}
	public Node searchToInsert(int value) {
		System.out.println("Search to insert ==> "+value);
		System.out.println("Search at node ==> "+Arrays.toString(this.keys));
		if(!this.isFourTree() && this.isLeaf())
		{
			return this;
		}
		else
		{
			Node current = this;
			while(!current.isLeaf())
			{
				System.out.println("Search Current=> "+Arrays.toString(current.keys));
				int index = 0;
				Integer[] keys = current.keys;
				while(	index < this.keys.length 
						&& keys[index] != null 
						&& keys[index] < value 
						)
				{
					index ++;
				}
				System.out.println("Go child index => "+index);
				current = current.children.get(index);
			}
			return current;
		}
	}
}
