package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PostFixConverterTest {
	PostfixConverter converter = new PostfixConverter();
	
	@Test
	public void testEmpty()
	{
		assertEquals("",converter.transform(""));
		assertEquals(null,converter.transform(null));
		
	}
	@Test
	public void testSimpleCase()
	{
		assertEquals("ab+",converter.transform("a+b"));
		assertEquals("bc*",converter.transform("b*c"));
		assertEquals("AB*",converter.transform("A*B"));
	}
}
