package com.turing.dsa.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HashTableTest {
	HashTable ht = new HashTable(10);
	
	@Test
	public void testHash()
	{
		
		int hash = HashTable.hash("hello",10);
		assertEquals(2,hash);
		
		hash = HashTable.hash("hlloe",10);
		assertEquals(2,hash);
	}
	@Test
	public void testInsert()
	{
		ht.insert("hello");
		
		assertTrue(ht.contains("hello"));
	}
	@Test
	public void testInsertUnknown()
	{
		//ht.insert("hello");
		
		assertFalse(ht.contains("hello"));
	}
}
