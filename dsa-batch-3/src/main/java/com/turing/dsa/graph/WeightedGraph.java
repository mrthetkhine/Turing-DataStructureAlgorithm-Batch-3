package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


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
	public WeightedGraph prims() {
		WeightedGraph graph = this.createGraphFromVertices();
		
		String startVertex = this.vertices.get(0);
		
		ArrayList<String> visitedVertices = new ArrayList<String>();
		visitedVertices.add(startVertex);
		
		ArrayList<Edge> primsEdges = new ArrayList<Edge>();
		Edge initialEdge = this.getSmallestEdgeFromRechable(startVertex, visitedVertices);
		primsEdges.add(initialEdge);
		
		this.addVisitedVertextFromEdge(initialEdge,visitedVertices);
		
		while(visitedVertices.size() != this.vertices.size())
		{
			Edge smallestEdge = this.getSmallestEdgeFromUnvisited(visitedVertices);
			primsEdges.add(smallestEdge);
			this.addVisitedVertextFromEdge(smallestEdge,visitedVertices);
		}
		for(Edge edge : primsEdges)
		{
			graph.addEdge(edge.from, edge.to, edge.weight);
		}
		return graph;
	}
	void addVisitedVertextFromEdge(Edge edge,ArrayList<String> visitedVertices)
	{
		if(!visitedVertices.contains(edge.from))
		{
			visitedVertices.add(edge.from);
		}
		if(!visitedVertices.contains(edge.to))
		{
			visitedVertices.add(edge.to);
		}
	}
	public Edge getSmallestEdgeFromUnvisited(ArrayList<String> visitedVertices)
	{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
	
		for(String v: visitedVertices)
		{
			//unvisited vertex
			Edge edge = getSmallestEdgeFromRechable(v,visitedVertices);
			if(edge !=null)
			{
				edges.add(edge);
			}
		}
		System.out.println("Visited "+Arrays.toString ( visitedVertices.toArray()));
		edges.forEach((edge)->{
			System.out.println("Unvisited Rechable edge "+edge);
		});
		Edge smallestEdge = this.getSmallestEdge(edges);
		System.out.println("getSmallestEdgeFromUnvisited==> "+smallestEdge);
		return smallestEdge;
	}
	public Edge getSmallestEdgeFromRechable(String vertex,ArrayList<String> visitedVertices)
	{
		System.out.println("getSmallestEdgeFromRechable Vertex "+vertex);
		ArrayList<Edge> rechableEdges = this.getEdgeRechableFromVertex(vertex, visitedVertices);
		rechableEdges.forEach(edge->{
			System.out.println("Edge rechable from "+vertex + " "+edge);
		});
		System.out.println("getSmallestEdgeFromRechable Vertex "+vertex +" Rechable edge "+rechableEdges.size());
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
			Edge edge = this.edgeExist2(vertex,un);
			if(edge != null)
			{
				rechableEdges.add(edge);
			}
			
		}
		
		return rechableEdges;
	}
	public Edge getSmallestEdge(ArrayList<Edge> edges)
	{
		if(edges.size()>0)
		{
			Collections.sort(edges);
			return edges.get(0);
		}
		else
		{
			return null;
		}
		
	}
	public WeightedGraph kruskal() {
		WeightedGraph graph = this.createGraphFromVertices();
		ArrayList<Edge> edges = this.cloneEdges();
		ArrayList<Edge> visitedEdge = new ArrayList<Edge>();
		
		ArrayList<String> visitedVertices = new ArrayList<>();
		
		while(visitedVertices.size() != this.vertices.size())
		{
			Collections.sort(edges);
			
			Edge smallest = null;
			for(int i=0;i< edges.size();i++)
			{
				smallest = edges.get(i);
				if(!isNewEdgeCreateCycle(smallest,visitedEdge))
				{
					visitedEdge.add(smallest);
					graph.addEdge(smallest.from, smallest.to, smallest.weight);
					
					System.out.println("Pick "+smallest);
					if(!visitedVertices.contains(smallest.from))
					{
						visitedVertices.add(smallest.from);
					}
					if(!visitedVertices.contains(smallest.to))
					{
						visitedVertices.add(smallest.to);
					}
					break;
				}
			}
			edges.remove(smallest);
			
		}
		return graph;
	}
	ArrayList<Edge> cloneEdges()
	{
		ArrayList<Edge> edges = new ArrayList<>();
		edges.addAll(this.edges);
		return edges;
	}
	public static boolean isNewEdgeCreateCycle(Edge edge,ArrayList<Edge> edges) {
		ArrayList<Edge> newEdges = new ArrayList<>();
		newEdges.addAll(edges);
		newEdges.add(edge);
		return isCyclic(newEdges);
	}
	public static boolean isCyclic(ArrayList<Edge> edges) {
		
		ArrayList<Edge> visitedEdges = new ArrayList<>();
		
		Edge firstEdge = edges.get(0);
		visitedEdges.add(firstEdge);
		
		ArrayList<String> visitedVertices = new ArrayList<String>();
		visitedVertices.add(firstEdge.from);
		visitedVertices.add(firstEdge.to);
		
		Stack<String> stack = new Stack<String>();
		
		stack.add(firstEdge.from);
		while(!stack.isEmpty())
		{
			String vertex = stack.pop();
			ArrayList<Edge> unvisitedRechableEdges = getUnvisitedEdgeRechableFrom(vertex,edges,visitedEdges);
			//visit edges
			for(Edge unvistedEdge : unvisitedRechableEdges)
			{
				if(isEdgeInCycle(visitedVertices,unvistedEdge))
				{
					return true;
				}
				else
				{
					if(!visitedVertices.contains(unvistedEdge.from))
					{
						visitedVertices.add(unvistedEdge.from);
						stack.push(unvistedEdge.from);
					}
					if(!visitedVertices.contains(unvistedEdge.to))
					{
						visitedVertices.add(unvistedEdge.to);
						stack.push(unvistedEdge.to);
					}
					visitedEdges.add(unvistedEdge);
				}
			}
		}
		return false;
	}
	public static boolean isEdgeInCycle(ArrayList<String> visitedVertices,Edge edge)
	{
		return visitedVertices.contains(edge.from) && visitedVertices.contains(edge.to);
	}
	public static ArrayList<Edge> getUnvisitedEdgeRechableFrom(String vertex,ArrayList<Edge> edges,ArrayList<Edge> visitedEdges )
	{
		ArrayList<Edge> rechableEdgesFromVertex = getRechableVertexFrom(vertex,edges);
		ArrayList<Edge> unvisitedRechableEdge = new ArrayList<>();
		
		for(Edge rEdge : rechableEdgesFromVertex)
		{
			if(!isEdgeInList(rEdge,visitedEdges) )
			{
				unvisitedRechableEdge.add(rEdge);
			}
		}
		return unvisitedRechableEdge;
	}
	public static ArrayList<Edge> getRechableVertexFrom(String vertex,ArrayList<Edge> edges)
	{
		ArrayList<Edge> rechableEdgesFromVertex = new ArrayList<>();
		for(Edge edge : edges)
		{
			if(edge.isRechableFromVertex(vertex))
			{
				rechableEdgesFromVertex.add(edge);
			}
		}
		return rechableEdgesFromVertex;
	}
	public static boolean isEdgeInList(Edge edge, ArrayList<Edge> edges) {
		
		for(Edge e : edges)
		{
			if(edge.sameEdge(e))
			{
				return true;
			}
		}
		return false;
	}
	
	
}
