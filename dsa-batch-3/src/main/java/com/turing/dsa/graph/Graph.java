package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	ArrayList<String> vertices = new ArrayList<>();
	int[][] adjacencyMatrix ;
	
	public void addVertice(String vertex) {
		
		if(!this.vertices.contains(vertex))
		{
			this.vertices.add(vertex);
		}
	}
	public int getNoOfVertex()
	{
		return this.vertices.size();
	}
	void init()
	{
		this.adjacencyMatrix = new int[vertices.size()][vertices.size()];
	}
	void addEdge(String source,String destination)
	{
		int sourceIndex = this.vertices.indexOf(source);
		int destinationIndex = this.vertices.indexOf(destination);
		this.adjacencyMatrix[sourceIndex][destinationIndex] = 1;
	}
	public boolean edgeExist(String source, String destination) {
		int sourceIndex = this.vertices.indexOf(source);
		int destinationIndex = this.vertices.indexOf(destination);
		
		return this.adjacencyMatrix[sourceIndex][destinationIndex] == 1;
	}
	public ArrayList<String> dfs(String startVertex) {
		ArrayList<String> visited = new ArrayList<>();
		
		Stack<String> stack = new Stack<>();
		stack.push(startVertex);
		
		while(!stack.isEmpty())
		{	
			//pop vertex
			String current = stack.pop();
			if(!visited.contains(current))
			{
				visited.add(current);
			}
			//push neighbour of vertex
			ArrayList<String> unvisitedNeighbour = this.getUnvisitedNeighbour(current,visited);
			
			//need to push in reverse order
			for(int i= unvisitedNeighbour.size()-1;i>=0;i-- )
			{
				stack.push(unvisitedNeighbour.get(i));
			}
			
		}
		return visited;
	}
	public ArrayList<String> bfs(String startVertex) {
		ArrayList<String> visited = new ArrayList<>();
		
		Queue<String> queue = new LinkedList<>();
		queue.add(startVertex);
		
		while(!queue.isEmpty())
		{	
			//pop vertex
			String current = queue.poll();
			if(!visited.contains(current))
			{
				visited.add(current);
			}
			//push neighbour of vertex
			ArrayList<String> unvisitedNeighbour = this.getUnvisitedNeighbour(current,visited);
			
			for(String v : unvisitedNeighbour)
			{
				queue.add(v);
			}
			
		}
		return visited;
	}
	public ArrayList<String> getUnvisitedNeighbour(String vertex,ArrayList<String> visited)
	{
		ArrayList<String> neighbours = this.getNeighbourOf(vertex);
		ArrayList<String> unvisitedNeighbours = new ArrayList<>();
		for(String n: neighbours)
		{
			if(!visited.contains(n))
			{
				unvisitedNeighbours.add(n);
			}
		}
		return unvisitedNeighbours;
	}
	public ArrayList<String> getNeighbourOf(String vertex)
	{
		ArrayList<String> neighbours = new ArrayList<>();
		
		
		for(String neighbour: this.vertices)
		{
			if(!neighbour.equals(vertex))
			{
				if(this.edgeExist(vertex, neighbour))
				{
					neighbours.add(neighbour);
				}
			}
		}
		return neighbours;
	}

	
}
