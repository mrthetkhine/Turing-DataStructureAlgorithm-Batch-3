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
	public void testPrcedenceLevel()
	{
		assertEquals(true,converter.isHigherOrEqualPrcedence('*', '+'));
		assertEquals(true,converter.isHigherOrEqualPrcedence('+', '+'));
		assertEquals(false,converter.isHigherOrEqualPrcedence('+', '*'));
		assertEquals(false,converter.isHigherOrEqualPrcedence('-', '*'));
	}
	@Test
	public void testSimpleCase()
	{
		assertEquals("ab+",converter.transform("a+b"));
		assertEquals("bc*",converter.transform("b*c"));
		assertEquals("AB*",converter.transform("A*B"));
	}
	@Test
	public void testPrecedenceCase()
	{
		assertEquals("abc*+",converter.transform("a+b*c"));
		assertEquals("ab*c+",converter.transform("a*b+c"));
		assertEquals("abc*+de*+",converter.transform("a+b*c+d*e"));
		assertEquals("abc*-de*+",converter.transform("a-b*c+d*e"));
	}
	@Test
	public void testCaseWithParenthesis()
	{
		assertEquals("ab+c*",converter.transform("(a+b)*c"));
		assertEquals("ab+cd+*",converter.transform("(a+b)*(c+d)"));
		assertEquals("abc*+de+*",converter.transform("(a+b*c)*(d+e)"));
		
	}
	
}
