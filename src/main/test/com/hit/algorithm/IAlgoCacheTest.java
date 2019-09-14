package com.hit.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IAlgoCacheTest {
	
	@Test
	void  lruPageReplacementTest()
	{
	LRUAlgoCacheImpl<String,Integer> lruTest = new LRUAlgoCacheImpl<String,Integer>(4);
		
		assertEquals(null,lruTest.putElement("aa", 1));
		assertEquals(null,lruTest.putElement("bb", 2));
		assertEquals(null,lruTest.putElement("cc", 3));
		assertEquals(null,lruTest.putElement("dd", 4));
		
		assertEquals(1,lruTest.getElement("aa"));
		assertEquals(2,lruTest.getElement("bb"));
		assertEquals(3,lruTest.getElement("cc"));
		assertEquals(4,lruTest.getElement("dd"));
		
		assertEquals(1,lruTest.putElement("ee",5));
		assertEquals(2,lruTest.putElement("ff",6));
		assertEquals(null,lruTest.putElement("ff",6));
		assertEquals(3,lruTest.putElement("gg",7));
		assertEquals(4,lruTest.putElement("hh",7));
		assertEquals(5,lruTest.putElement("ii",7));
		
		lruTest.removeElement("ff");
		lruTest.removeElement("gg");
		lruTest.removeElement("hh");
		lruTest.removeElement("ii");
		
		assertEquals(null, lruTest.getElement("ff"));
		assertEquals(null, lruTest.getElement("gg"));
		assertEquals(null, lruTest.getElement("hh"));
		assertEquals(null, lruTest.getElement("ii"));
		
	}
	
	
		
	@Test
	void  RandomAlgoPageReplacementTest()
	{
		RandomAlgoCacheImpl<String,Integer> randTest = new RandomAlgoCacheImpl<String,Integer>(4);
		
		assertEquals(null,randTest.putElement("a", 0));
		assertEquals(null,randTest.putElement("b", 1));
		assertEquals(null,randTest.putElement("c", 2));
		assertEquals(null,randTest.putElement("d", 3));
		

		assertEquals(0,randTest.getElement("a"));
		assertEquals(1,randTest.getElement("b"));
		assertEquals(2,randTest.getElement("c"));
		assertEquals(3,randTest.getElement("d"));
		
		randTest.removeElement("a");
		randTest.removeElement("b");
		randTest.removeElement("c");
		randTest.removeElement("d");
		
		assertEquals(null, randTest.getElement("a"));
		assertEquals(null, randTest.getElement("b"));
		assertEquals(null, randTest.getElement("c"));
		assertEquals(null, randTest.getElement("d"));
	
		
	}
	
	
	@Test
	void  SecondChancePageReplacementTest()
	{
		SecondChance<String,Integer> scTest = new SecondChance<String,Integer>(3);
		
		assertEquals(null,scTest.putElement("a", 2));
		assertEquals(null,scTest.putElement("b", 3));
		assertEquals(null,scTest.putElement("a", 2));
		
		assertEquals(2,scTest.getElement("a"));
		assertEquals(3,scTest.getElement("b"));
		
		assertEquals(null,scTest.putElement("c", 1));
		assertEquals(3,scTest.putElement("d",5));
		assertEquals(null,scTest.putElement("a",2));
		assertEquals(1,scTest.putElement("e",4));
		assertEquals(null,scTest.putElement("d",5));

		
		assertEquals(2, scTest.getElement("a"));
		assertEquals(5, scTest.getElement("d"));
		assertEquals(4, scTest.getElement("e"));
		
		
		scTest.removeElement("a");
		scTest.removeElement("d");
		scTest.removeElement("e");
		
		assertEquals(null,scTest.getElement("a"));
		assertEquals(null,scTest.getElement("d"));
		assertEquals(null,scTest.getElement("e"));
	
		
	}
	
}
