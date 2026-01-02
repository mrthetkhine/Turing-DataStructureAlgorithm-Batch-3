package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CycleTest {
	WeightedGraph graph = new WeightedGraph();
	
	CycleTest()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.init();
	}
	
	@Test
	public void testEdgeIsInList()
	{
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge("A","B",10));
		edges.add(new Edge("A","C",2));
		
		assertTrue(WeightedGraph.isEdgeInList(new Edge("B","A",10),edges));
		assertTrue(WeightedGraph.isEdgeInList(new Edge("A","B",10),edges));
		assertTrue(WeightedGraph.isEdgeInList(new Edge("A","C",2),edges));
		assertTrue(WeightedGraph.isEdgeInList(new Edge("C","A",2),edges));
		
		assertFalse(WeightedGraph.isEdgeInList(new Edge("C","B",10),edges));
	}
	@Test
	public void testRechableUnvisitedTest()
	{
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge("A","B",10));
		edges.add(new Edge("A","C",2));
		edges.add(new Edge("A","D",2));
		edges.add(new Edge("B","C",5));
		
		ArrayList<Edge> visitedEdge = new ArrayList<>();
		visitedEdge.add(new Edge("A","B",10));
		
		ArrayList<Edge> unvisitedRechableEdge = WeightedGraph.getUnvisitedEdgeRechableFrom("A", edges, visitedEdge);
		assertEquals(2,unvisitedRechableEdge.size());
		
		assertTrue(WeightedGraph.isEdgeInList(new Edge("A","C",10),unvisitedRechableEdge));
		assertTrue(WeightedGraph.isEdgeInList(new Edge("A","D",10),unvisitedRechableEdge));
	}
	@Test
	public void testCycle()
	{
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge("A","B",10));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("A","C",4));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("B","C",2));
		assertTrue(WeightedGraph.isCyclic(edges));
		
	}
	@Test
	public void testCycle2()
	{
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge("A","B",10));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("A","C",4));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("C","D",2));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("A","D",8));
		assertTrue(WeightedGraph.isCyclic(edges));
		
	}
	@Test
	public void testCycle3()
	{
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge("A","B",10));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("B","C",4));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("C","D",2));
		assertFalse(WeightedGraph.isCyclic(edges));
		
		edges.add(new Edge("C","A",8));
		assertTrue(WeightedGraph.isCyclic(edges));
		
	}
}
