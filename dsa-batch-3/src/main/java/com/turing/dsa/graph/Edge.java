package com.turing.dsa.graph;

public class Edge implements Comparable<Edge>{
	String from;
	String to ;
	int weight;
	public Edge(String from, String to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	public boolean sameEdge(String from, String to)
	{
		return ( this.from.equals(from) && this.to.equals(to)) ||
				(this.to.equals(from) && this.from.equals(to));
	}
	@Override
	public int compareTo(Edge o) {
		
		return this.weight - o.weight;
	}
}
