package com.turing.dsa.tree;

public class BinarySearchTree {

	Node root;
	
	public void insert(int value) {
		
		Node node = new Node(value);
		if(root == null)
		{
			this.root = node;
		}
		else
		{
			Node current = this.root;
			boolean done = false;
			while(!done )
			{
				if(value == current.value)
				{
					System.out.println("Duplicate item");
					return;
				}
				if(value > current.value)
				{
					if(current.getRight() != null)
					{
						current = current.getRight();
					}
					else
					{
						current.setRight(node);
						done = true;
					}
					
				}
				else if(value < current.value)
				{
					if(current.getLeft() != null)
					{
						current = current.getLeft();
					}
					else
					{
						current.setLeft(node);
						done = true;
					}
					
				}
			}
			
			
		}
	}
	public Node search(int value) {
		Node current = this.root;
		while(current != null)
		{
			if(current.value == value)
			{
				return current;
			}
			else if(value > current.value)
			{
				current = current.getRight();
			}
			else
			{
				current = current.getLeft();
			}
		}
		return null;
	}
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	
	
}
