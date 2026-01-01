package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WeightedGraph extends Graph{
	ArrayList<Edge> edges = new ArrayList<Edge>();
	public void addEdge(String source,String destination,int weight)
	{
		this.edges.add(new Edge(source,destination,weight));
	}
	public Edge edgeExist2(String source, String destination) {
		for(Edge edge : this.edges)
		{
			if(edge.sameEdge(source, destination))
			{
				return edge;
			}
		}
		return null;
	}
	WeightedGraph createGraphFromVertices()
	{
		WeightedGraph graph  = new WeightedGraph();
		for(String vertex : this.vertices)
		{
			graph.addVertice(vertex);
		}
		graph.init();
		
		return graph;
	}
	public ArrayList<Edge> prims() {
		WeightedGraph graph = this.createGraphFromVertices();
		
		String startVertex = this.vertices.get(0);
		
		ArrayList<String> visitedVertices = new ArrayList<String>();
		visitedVertices.add(startVertex);
		
		ArrayList<Edge> primsEdges = new ArrayList<Edge>();
		Edge initialEdge = this.getSmallestEdgeFromRechable(startVertex, visitedVertices);
		primsEdges.add(initialEdge);
		
		if(!visitedVertices.contains(initialEdge.from))
		{
			visitedVertices.add(initialEdge.from);
		}
		if(!visitedVertices.contains(initialEdge.to))
		{
			visitedVertices.add(initialEdge.to);
		}
		
		while(visitedVertices.size() != this.vertices.size())
		{
			
		}
		return primsEdges;
	}
	public Edge getSmallestEdgeFromUnvisited(ArrayList<String> visitedVertices)
	{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(String v: this.vertices)
		{
			//unvisited vertex
			if(!visitedVertices.contains(v))
			{
				
				Edge edge = getSmallestEdgeFromRechable(v,visitedVertices);
				if(edge !=null)
				{
					edges.add(edge);
				}
				
			}
		}
		System.out.println("Visited "+Arrays.toString ( visitedVertices.toArray()));
		edges.forEach((edge)->{
			System.out.println("Unvisited Rechanble edge "+edge);
		});
		return this.getSmallestEdge(edges);
	}
	public Edge getSmallestEdgeFromRechable(String vertex,ArrayList<String> visitedVertices)
	{
		System.out.println("Vertex "+vertex);
		ArrayList<Edge> rechableEdges = this.getEdgeRechableFromVertex(vertex, visitedVertices);
		System.out.println("Vertex "+vertex +" Rechable edge "+rechableEdges.size());
		return this.getSmallestEdge(rechableEdges);
	}
	public ArrayList<String> unvisitedVertices(ArrayList<String> visitedVertices)
	{
		ArrayList<String> unvisited = new ArrayList<>();
		for(String v: this.vertices)
		{
			if(!visitedVertices.contains(v))
			{
				unvisited.add(v);
			}
		}
		return unvisited;
	}
	public ArrayList<Edge> getEdgeRechableFromVertex(String vertex,ArrayList<String> visitedVertices)
	{
		ArrayList<Edge> rechableEdges = new ArrayList<>();
		ArrayList<String> unvisited = this.unvisitedVertices(visitedVertices);
		for(String un: unvisited)
		{
			
			for(String vs : visitedVertices)
			{
				Edge edge = this.edgeExist2(vs, un);
				if(edge != null)
				{
					rechableEdges.add(edge);
				}
			}
			
		}
		
		return rechableEdges;
	}
	public Edge getSmallestEdge(ArrayList<Edge> edges)
	{
		Collections.sort(edges);
		return edges.get(0);
	}
	
	
}
