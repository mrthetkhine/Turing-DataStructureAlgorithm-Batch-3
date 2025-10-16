package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest {
	/*
	 * a = 2
	 * b = 3
	 * c = 5
	 * */
	
	HashMap<Character,Integer> variables= new HashMap<>();
	ExpressionEvaluatorTest()
	{
		this.variables.put('a', 2);
		this.variables.put('b', 3);
		this.variables.put('c', 5);
		this.variables.put('d', 7);
	}
	@Test
	public void testEval()
	{
		//a+b*c = 
		ExpressionEvaluator eval = new ExpressionEvaluator();
		int result = eval.execute("a+b*c",variables);
		
		assertEquals(17,result);
		
		result = eval.execute("a*b+c",variables);
		assertEquals(11,result);
		
		result = eval.execute("a*(b+c)",variables);
		assertEquals(16,result);
	}
}
