package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {
	WeightedGraph graph = new WeightedGraph();
	
	WeightedGraphTest()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.init();
	}
	@Test
	public void testWeightedGraph()
	{
		/*
		 * A->B (3)
		 * B->C (2) 
		 * */
		graph.addEdge("A","B",3);
		graph.addEdge("B","C",2);
		
		assertNotNull(graph.edgeExist2("A","B"));
		assertNotNull(graph.edgeExist2("B","A"));
		assertNotNull(graph.edgeExist2("B","C"));
		assertNotNull(graph.edgeExist2("C","B"));
	}
	@Test
	public void testRechableVertexPrims()
	{
		/*
		
		 *  B-B 10
		 *  A-C 4
		 *  A-D 8
		 *  
		 *  B-C 2
		 *  C-D 2
		 * */
		graph.addEdge("A","B",10);
		graph.addEdge("A","C",4);
		graph.addEdge("A","D",8);
		
		graph.addEdge("B","C",2);
		graph.addEdge("C","D",2);
		
		ArrayList<String> visited = new ArrayList<>();
		visited.add("A");
		ArrayList<Edge> edges = graph.getEdgeRechableFromVertex("A", visited);
		
		assertEquals(3,edges.size());
		assertTrue(edges.get(0).sameEdge("A", "B"));
		assertTrue(edges.get(1).sameEdge("A", "C"));
		assertTrue(edges.get(2).sameEdge("A", "D"));
		
		Edge smallest = graph.getSmallestEdge(edges);
		assertTrue(smallest.sameEdge("A", "C"));
		
		visited.add("C");
		smallest = graph.getSmallestEdgeFromUnvisited(visited);
		
		assertEquals(2,smallest.weight);
	}
	
}
