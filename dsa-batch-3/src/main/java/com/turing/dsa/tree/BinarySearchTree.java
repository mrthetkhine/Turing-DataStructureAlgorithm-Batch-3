package com.turing.dsa.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
	public Iterator<Node> preOrder() {
	
		return new PreoderTraversal();
	}
	class PreoderTraversal implements Iterator<Node>
	{
	
		List<Node> visisted = new ArrayList<Node>();
		
		PreoderTraversal()
		{
			
			this.traverse(root);
		}
		void traverse(Node current)
		{
			/*
			 * Root left right
			 * */
			
			this.visisted.add(current);
			if(current.getLeft()!=null)
			{
				this.traverse(current.getLeft());
			}
			if(current.getRight()!=null)
			{
				this.traverse(current.getRight());
			}
		}
		@Override
		public boolean hasNext() {
			
			return !this.visisted.isEmpty();
		}

		
		@Override
		public Node next() {
			return this.visisted.remove(0);
		}

		
	}
	public Iterator<Node> inOrder() {
		
		return new InOrderTraversal();
	}
	class InOrderTraversal implements Iterator<Node>
	{
	
		List<Node> visisted = new ArrayList<Node>();
		
		InOrderTraversal()
		{
			
			this.traverse(root);
		}
		void traverse(Node current)
		{
			/*
			 * left Root right
			 * */
			
			if(current.getLeft()!=null)
			{
				this.traverse(current.getLeft());
			}
			this.visisted.add(current);
			if(current.getRight()!=null)
			{
				this.traverse(current.getRight());
			}
		}
		@Override
		public boolean hasNext() {
			
			return !this.visisted.isEmpty();
		}

		
		@Override
		public Node next() {
			return this.visisted.remove(0);
		}

		
	}
	public Iterator<Node> postOrder() {
		return new PostOrderTraversal();
	}
	class PostOrderTraversal implements Iterator<Node>
	{
	
		List<Node> visisted = new ArrayList<Node>();
		
		PostOrderTraversal()
		{
			
			this.traverse(root);
		}
		void traverse(Node current)
		{
			/*
			 * left  right Root
			 * */
			
			if(current.getLeft()!=null)
			{
				this.traverse(current.getLeft());
			}
			
			if(current.getRight()!=null)
			{
				this.traverse(current.getRight());
			}
			this.visisted.add(current);
		}
		@Override
		public boolean hasNext() {
			
			return !this.visisted.isEmpty();
		}

		
		@Override
		public Node next() {
			return this.visisted.remove(0);
		}

		
	}
	public Iterator<Node> preOrderIterative() {
		
		return new PreoderTraversalIterative();
	}
	class PreoderTraversalIterative implements Iterator<Node>
	{
	
		List<Node> visisted = new ArrayList<Node>();
		
		PreoderTraversalIterative()
		{
			
			this.traverse(root);
		}
		void traverse(Node current)
		{
			/*
			 * Root left right
			 * */
			Stack<Node> stack = new Stack<>();
			while( current != null)
			{
				//System.out.println("Current "+current.value);
				if(!this.visisted.contains(current))
				{
					this.visisted.add(current);
					System.out.println("Visited "+current.value);
					//System.out.println("Left of "+current.value + " "+current.getLeft().value);
					if(current.getLeft() != null)
					{
						System.out.println("Push "+current.value);
						stack.push(current);
						current = current.getLeft();
						System.out.println("Go to left "+current.value);
					}
					else
					{
						//Go to  right
						while(!stack.isEmpty())
						{
							Node parent = stack.pop();
							System.out.println("Pop parent "+parent.value);
							if(parent.right != null)
							{
								current = parent.right;
								break;
							}
							
							
						}
					}
				}
				else
				{
					break;
				}
				
				
			}
			
		}
		@Override
		public boolean hasNext() {
			
			return !this.visisted.isEmpty();
		}

		
		@Override
		public Node next() {
			return this.visisted.remove(0);
		}

		
	}
}
