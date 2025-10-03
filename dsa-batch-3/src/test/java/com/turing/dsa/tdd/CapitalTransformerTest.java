package com.turing.dsa.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CapitalTransformerTest {
	Transformer tran = new Transformer();
	
	@Test
	public void testBase()
	{
		String output = tran.transform("");
		assertEquals("",output);
	}
	@Test
	public void testBaseCaseNull()
	{
		String output = tran.transform(null);
		assertEquals(null,output);
	}
	@Test
	public void testBundary()
	{
		String output = tran.transform("h");
		assertEquals("H",output);
	}
	@Test
	public void testBasicInput()
	{
		String output = tran.transform("hello");
		assertEquals("Hello",output);
	}
	@Test
	public void testComplexInput()
	{
		String output = tran.transform("turing center");
		assertEquals("Turing Center",output);
	}
}
