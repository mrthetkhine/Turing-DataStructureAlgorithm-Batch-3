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
	
	public boolean isRechableFromVertex(String vertex)
	{
		return this.from.equals(vertex) || this.to.equals(vertex);
	}
	@Override
	public int compareTo(Edge o) {
		
		return this.weight - o.weight;
	}
	public boolean sameEdge(Edge e) {
		
		return this.sameEdge(e.from,e.to);
	}
}
