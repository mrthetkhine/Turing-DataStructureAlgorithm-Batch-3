package com.turing.dsa.ds;

import java.util.Iterator;

public class LinkedList {

	Node first;
	Node last;
	LinkedList()
	{

	}
	
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public void append(int value) {
		
		Node newNode = new Node(value);
		
		if(this.first == null)
		{
			this.first= newNode;
			this.last = newNode;
		}
		else if(this.last != null)
		{
			last.next = newNode;
			this.last = newNode;
		}
	}
	public void prepend(int value) {
		
		Node newNode = new Node(value);
		if(this.first == null)
		{
			this.first= newNode;
		}
		else
		{
			newNode.next = this.first;
			this.first = newNode;
		}
	}
	public Iterator<Node> createIterator() {
	
		return new LinkedListIterator();
	}
	class LinkedListIterator implements Iterator<Node>
	{

		Node current;
		LinkedListIterator()
		{
			current = first;
		}
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Node next() {
			Node temp = current;
			current = current.next;
			return temp;
		}		
	}
	public Node findNode(int value) {
		if(this.first == null)
		{
			return null;
		}
		else
		{
			Node current = this.first;
			while(current !=null)
			{
				if(current.value == value)
				{
					return current;
				}
				current = current.next;
			}
			return null;
		}
	}
	public boolean contains(int value) {
		return this.findNode(value)!=null;
	}
	public void delete(int value)
	{
		Node node = this.findNode(value);
		if(node == this.first)
		{
			if(this.first==this.last)//single node
			{
				Node next = this.first.next;
				this.first = next;
				this.last = next;
				
			}
			else
			{
				Node next = this.first.next;
				this.first = next;
			}
			
		}
		else if(node == this.last)
		{
			Node current = this.first;
			Node previous = null ;
			while(current !=null)
			{
				if(current.value == value)
				{
					break;
				}
				previous = current;
				current = current.next;
			}
			previous.next = null;
			this.last = previous;
		}
		else//middle node
		{
			Node current = this.first;
			Node previous = null ;
			while(current !=null)
			{
				if(current.value == value)
				{
					break;
				}
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
		}
	}
	
	
}
