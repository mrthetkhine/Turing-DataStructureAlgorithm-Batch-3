package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class BFSTest {
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
		
		ArrayList<String> vertices = graph.bfs("A");
		/*
		 * A->B->C->D->E->F->G->H->I
		 * */
		Iterator<String> iterator = vertices.iterator();
		assertEquals("A",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("E",iterator.next());
		assertEquals("F",iterator.next());
		assertEquals("G",iterator.next());
		assertEquals("H",iterator.next());
		assertEquals("I",iterator.next());
		assertFalse(iterator.hasNext());
	}
}
