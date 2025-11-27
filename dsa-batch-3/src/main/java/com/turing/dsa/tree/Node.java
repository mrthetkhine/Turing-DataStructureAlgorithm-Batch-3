package com.turing.dsa.tree;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value)
	{
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public boolean isLeaf()
	{
		return this.left == null&& this.right == null;
	}
	int getChildCount()
	{
		int count = 0;
		if(this.left != null)
		{
			count ++;
		}
		if(this.right != null)
		{
			count ++;
		}
		return count;
	}
	public boolean isOneChild()
	{
		
		return this.getChildCount() == 1;
	}
	public boolean isTwoChild()
	{
		return this.getChildCount() == 2;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
	
	
}
