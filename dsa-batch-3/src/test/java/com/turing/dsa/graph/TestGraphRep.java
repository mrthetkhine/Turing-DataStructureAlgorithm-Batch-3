package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestGraphRep {
	Graph graph = new Graph();
	
	@Test
	public void testGraph()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("A");
		
		assertEquals(4,graph.getNoOfVertex());
	}
}
