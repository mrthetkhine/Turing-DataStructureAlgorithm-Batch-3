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
			while( current != null || !stack.isEmpty())
			{
				System.out.println("Current "+current);
				if(!this.visisted.contains(current))
				{
					this.visisted.add(current);
					System.out.println("Visited "+current);
					//System.out.println("Left of "+current.value + " "+current.getLeft().value);
					if(current.getLeft() != null)
					{
						System.out.println("Push "+current.value);
						stack.push(current);
						current = current.getLeft();
						System.out.println("Go to left "+current.value);
					}
					else if(current.getRight() != null)
					{
						System.out.println("This case "+current.getRight());
						current = current.getRight();
					}
					else
					{
						//Go to  right
						if(!stack.isEmpty())
						{
							current = null;
							while(!stack.isEmpty())
							{
								Node parent = stack.pop();
								System.out.println("Pop parent "+parent);
								if(parent.right != null)
								{
									current = parent.right;
									break;
								}
								
								//break;
							}
							
						}
						else
						{
							current = null;
						}
					}
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
	public Iterator<Node> inOrderIterative() {
		
		return new InorderTraversalIterative();
	}
	class InorderTraversalIterative implements Iterator<Node>
	{
	
		List<Node> visisted = new ArrayList<Node>();
		
		InorderTraversalIterative()
		{
			
			this.traverse(root);
		}
		void traverse(Node current)
		{
			/*
			 * Root left right
			 * */
			Stack<Node> stack = new Stack<>();
			
			while( current != null || !stack.isEmpty())
			{
				while(current.left != null)
				{
					stack.push(current);
					System.out.println("Push current "+current);
					System.out.println("Move to left "+current.left);
					current = current.left;
					
				}
				System.out.println("Visited "+current);
				this.visisted.add(current);
				if(current.right != null)
				{
					System.out.println("Move to right "+current.right);
					current = current.right;
				}
				else
				{
					System.out.println("This case no");
					current = null;
					while(!stack.isEmpty())
					{
						Node root = stack.pop();
						System.out.println("Pop from stack "+root);
						System.out.println("Visited "+root);
						this.visisted.add(root);
						
						if(root.getRight() != null)
						{
							System.out.println("Move to root right "+root.getRight());
							current = root.getRight();
							break;
						}
						
					}
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
	public Iterator<Node> postOrderIterative() {
		
		return new PostOrderTraversalIterative();
	}
	class PostOrderTraversalIterative implements Iterator<Node>
	{
	
		List<Node> visisted = new ArrayList<Node>();
		
		PostOrderTraversalIterative()
		{
			
			this.traverse(root);
		}
		void traverse(Node current)
		{
			/*
			 * Root left right
			 * */
			Stack<Node> stack = new Stack<>();
			
			while( current != null || !stack.isEmpty())
			{
				if(current.left != null && !this.visisted.contains(current.left))
				{
					while(current.left !=null)
					{
						System.out.println("Push current root "+current);
						stack.push(current);
						
						if(current.right != null)
						{
							System.out.println("Push current right "+current.right);
							stack.push(current.right);
						}
						current = current.left;
					}
				}
				else if(current.right != null && !this.visisted.contains(current.right))
				{
					System.out.println("Push current root "+current);
					stack.push(current);
					
					System.out.println("Push current right "+current.right);
					stack.push(current.right);
				}
				
				
				current = null;
				if(! stack.isEmpty())	
				{
					Node item = stack.pop();
					System.out.println("Pop from stack "+item);
					current = item;
				}
				
				if(current != null && !this.visisted.contains(current))
				{
					System.out.println("Visited "+current);
					this.visisted.add(current);
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
