package com.turing.dsa.graph;

import java.util.ArrayList;

public class Graph {

	ArrayList<String> vertices = new ArrayList<>();
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

}
