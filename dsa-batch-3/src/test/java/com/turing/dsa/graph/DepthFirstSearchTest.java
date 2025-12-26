package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class DepthFirstSearchTest {
	@Test
	public void testBaseDFS()
	{
		/*
			A->B->C 
			
		*/
		Graph graph = new Graph();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		//graph.addVertice("D");
		graph.init();
		
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		ArrayList<String> vertices = graph.dfs("A");
		/*
		 * A->B->C
		 * */
		Iterator<String> iterator = vertices.iterator();
		assertEquals("A",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("C",iterator.next());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testBase2DFS()
	{
		/*
			A->B->C 
			C->D
			
		*/
		Graph graph = new Graph();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.init();
		
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		ArrayList<String> vertices = graph.dfs("A");
		/*
		 * A->B->C->D
		 * */
		Iterator<String> iterator = vertices.iterator();
		assertEquals("A",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("D",iterator.next());
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testDFSComplexCase()
	{
		/*
			A->B
			A->C
			A->D
			A->E
			
			B->F
			
			D->G
			
			F->H
			
			G->I
			
		*/
		//Graph graph = new Graph();
		GraphWithAdList graph = new GraphWithAdList();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		graph.addVertice("G");
		graph.addVertice("H");
		graph.addVertice("I");
		graph.init();
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("A", "E");
		
		graph.addEdge("B", "F");
		
		graph.addEdge("D", "G");
		
		graph.addEdge("F", "H");
		
		graph.addEdge("G", "I");
		
		ArrayList<String> vertices = graph.dfs("A");
		/*
		 * A->B->F->H->C->D->G->I->E
		 * */
		Iterator<String> iterator = vertices.iterator();
		assertEquals("A",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("F",iterator.next());
		assertEquals("H",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("G",iterator.next());
		assertEquals("I",iterator.next());
		assertEquals("E",iterator.next());
		assertFalse(iterator.hasNext());
	}
}
