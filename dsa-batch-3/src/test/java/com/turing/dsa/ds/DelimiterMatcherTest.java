package com.turing.dsa.ds;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

public class DelimiterMatcherTest {
	DelimiterMatcher matcher = new DelimiterMatcher();
	@Test
	public void testBase()
	{
		assertTrue(matcher.match(null));
		assertTrue(matcher.match(""));
		assertTrue(matcher.match("ae"));
	}
	@Test
	public void testSinlgePositive()
	{
		assertTrue(matcher.match("c[d]"));
		assertTrue(matcher.match("[][][]"));
		assertTrue(matcher.match("[a[b[c]]]"));
		assertTrue(matcher.match("{a}"));
		assertTrue(matcher.match("[({a})]"));
	}
	@Test
	public void testSinlgeNegative()
	{
		assertFalse(matcher.match("c[d"));
		assertFalse(matcher.match("cd]"));
		assertFalse(matcher.match("cd]]"));
		assertFalse(matcher.match("cd[["));
		assertFalse(matcher.match("cd]["));
		assertFalse(matcher.match("{a"));
		assertFalse(matcher.match("a}"));
		assertFalse(matcher.match("[({a})"));
	}
}
