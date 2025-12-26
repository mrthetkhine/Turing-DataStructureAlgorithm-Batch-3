package com.turing.dsa.graph;
import java.util.ArrayList;

public class GraphWithAdList extends Graph{
	ArrayList<ArrayList<String>> adList;
	
	/*
	 * 	A-> [B,C]
	 * */
	void init()
	{
		this.adList = new ArrayList<>();
		for(String vertex : this.vertices)
		{
			this.adList.add(new ArrayList<>());
		}
	}
	void addEdge(String source,String destination)
	{
		int sourceIndex = this.vertices.indexOf(source);
		ArrayList<String> neighbours = this.adList.get(sourceIndex);
		if(!neighbours.contains(destination))
		{
			neighbours.add(destination);
		}
	}
	public boolean edgeExist(String source, String destination) {
		int sourceIndex = this.vertices.indexOf(source);
		ArrayList<String> neighbours = this.adList.get(sourceIndex);
		
		return neighbours.contains(destination);
	}
	
	
}
