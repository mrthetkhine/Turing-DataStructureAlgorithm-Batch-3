package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class KruskalTest {
	WeightedGraph graph = new WeightedGraph();
	
	KruskalTest()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.init();
	}
	@Test
	public void testKruskal()
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
		
		
		WeightedGraph kGraph = graph.kruskal();
		
		assertEquals(3,kGraph.edges.size());
		assertNotNull(kGraph.edgeExist2("A","C"));
		assertNotNull(kGraph.edgeExist2("B","C"));
		assertNotNull(kGraph.edgeExist2("C","D"));
	}
}
