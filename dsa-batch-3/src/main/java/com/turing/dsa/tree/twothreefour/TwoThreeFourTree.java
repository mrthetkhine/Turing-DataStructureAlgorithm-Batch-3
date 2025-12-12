package com.turing.dsa.tree.twothreefour;

import java.util.Arrays;

public class TwoThreeFourTree {
	Node root = new Node();
	
	
	public Node getRoot() {
		return root;
	}


	public void setRoot(Node root) {
		this.root = root;
	}


	public Node insert(int value)
	{
		Node nodeToInsert = this.root.searchToInsert(value);
		if(nodeToInsert.treeType < 4 && nodeToInsert.isLeaf())
		{
			return nodeToInsert.simpleInsert(value);
		}
		else if(nodeToInsert.isFourTree())
		{
			System.out.println("This case split for insert value "+value+" ===> "+Arrays.toString(nodeToInsert.keys));
			
			nodeToInsert.split(this);
			Node leafNode = this.root.searchToInsert(value); 
			return leafNode.insert(value,this);
			
		}
		else
		{
			Node leafNode = nodeToInsert.searchToInsert(value); 
			return leafNode.insert(value,this);
		}
	}
	
}
