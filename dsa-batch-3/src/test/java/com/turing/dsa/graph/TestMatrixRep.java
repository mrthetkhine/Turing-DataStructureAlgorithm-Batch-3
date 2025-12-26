package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMatrixRep {
	Graph graph = new Graph();
	
	TestMatrixRep()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.init();
	}
	@Test
	public void testGraph()
	{
		
		//graph.addVertice("A");
		
		assertEquals(4,graph.getNoOfVertex());
	}
	
	@Test
	public void testEdge()
	{
		graph.addEdge("A", "B");
		graph.addEdge("A", "D");
		graph.addEdge("B", "D");
		graph.addEdge("C", "B");
		graph.addEdge("C", "D");
		graph.addEdge("D", "C");
		
		assertTrue(graph.edgeExist("A","B"));
		assertTrue(graph.edgeExist("A","D"));
		assertTrue(graph.edgeExist("B","D"));
		assertTrue(graph.edgeExist("C","B"));
		assertTrue(graph.edgeExist("C","D"));
		assertTrue(graph.edgeExist("D","C"));
		
		assertFalse(graph.edgeExist("A","C"));
		
	}
}
