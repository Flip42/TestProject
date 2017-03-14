package tree;


import static org.junit.Assert.*;
import org.junit.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TreeTest {
	
	private Map<Integer, String> tree;

	@Before
	public void init(){
		tree = new Tree<Integer,String>();
	}

	@Test
	public void enshureJUnitWorks() {
		assertTrue("There is something wrong with JUnit.",true);
	}

	@Test
	public void sizeOfEmptyMap() {
		assertEquals("Map is not Empty",0,tree.size());
	}

	@Test
	public void sizeOfOneEntryMap() {
		tree.put(42, "The Meaning of Life");
		assertEquals("Map is Empty",1,tree.size());
	}

	@Test
	public void sizeOfTwoEntryMap() {
		tree.put(42, "The Meaning of Life");
		tree.put(1, "I'm the no One!");
		assertEquals("Map is Empty",2,tree.size());
	}

	@Test
	public void sizeOfThreeEntryMap() {
		tree.put(42, "The Meaning of Life");
		tree.put(1, "I'm the no One!");
		tree.put(100, "Bestof");
		assertEquals("Map is Empty",3,tree.size());
	}

	@Test
	public void getOneFromMap() {
		tree.put(42, "The Meaning of Life");
		assertEquals("Map doesn' contain an Element at Index 42","The Meaning of Life",tree.get(42));
	}

	@Test
	public void getTwoFromMap() {
		tree.put(42, "The Meaning of Life");
		tree.put(1, "I'm the no One!");
		assertEquals("Map doesn' contain an Element at Index 42","The Meaning of Life",tree.get(42));
		assertEquals("Map doesn' contain an Element at Index 1","I'm the no One!",tree.get(1));
	}

	@Test
	public void getThreeFromMap() {
		tree.put(42, "The Meaning of Life");
		tree.put(1, "I'm the no One!");
		tree.put(100, "Bestof");
		assertEquals("Map doesn' contain an Element at Index 42","The Meaning of Life",tree.get(42));
		assertEquals("Map doesn' contain an Element at Index 1","I'm the no One!",tree.get(1));
		assertEquals("Map doesn' contain an Element at Index 100","Bestof",tree.get(100));
	}

	@Test
	public void isEmptyMap() {
		assertTrue("Map is not Empty",tree.isEmpty());
	}

	@Test
	public void isNotEmptyMap() {
		tree.put(42, "The Meaning of Life");
		assertFalse("Map is Empty",tree.isEmpty());
	}

	@Test
	public void mapContainsKey() {
		tree.put(42, "The Meaning of Life");
		assertTrue("Map does not contain Key 42",tree.containsKey(42));
	}

	@Test
	public void mapDoesntContainKey() {
		assertFalse("Map does contain Key 42",tree.containsKey(42));
	}

	@Test
	public void mapContainsValue() {
		tree.put(42, "42");
		assertTrue("Map does not contain Value 42",tree.containsValue("42"));
	}

	@Test
	public void mapContainsValueOutOfTwo() {
		tree.put(1, "1");
		tree.put(42, "42");
		assertTrue("Map does not contain Value 42",tree.containsValue("42"));
	}

	@Test
	public void mapContainsValueOutOfThree() {
		tree.put(1, "1");
		tree.put(100, "100");
		tree.put(42, "42");
		assertTrue("Map does not contain Value 42",tree.containsValue("42"));
	}

	@Test
	public void removeElementfromTree() {
		tree.put(1, "1");
		tree.put(100, "100");
		tree.put(42, "42");
		tree.remove(1);
		assertFalse("Map does contain Key 1",tree.containsKey(1));
	}

	@Test
	public void mapDoesntContainValue() {
		assertFalse("Map does contain Value 42",tree.containsValue("42"));
	}

	@Test
	public void putAll() {
		Map<Integer, String> init = new HashMap<Integer,String>();
		for(int i=0;i<10;i++){
			init.put(i, String.valueOf(i));
		}
		tree.putAll(init);
		assertEquals("putAll() failed",10,tree.size());
	}

	@Test
	public void clearThree() {
		tree.put(1, "1");
		tree.put(42, "42");
		tree.clear();
		assertEquals("Map is not cleared",0,tree.size());
	}

	@Test
	public void getKeySet() {
		tree.put(1, "1");
		tree.put(2, "2");
		tree.put(3, "3");
		tree.put(42, "42");
		Set<Integer> set = tree.keySet();
		assertTrue("keySet() misses a Key",set.contains(1));
		assertTrue("keySet() misses a Key",set.contains(2));
		assertTrue("keySet() misses a Key",set.contains(3));
		assertTrue("keySet() misses a Key",set.contains(42));
	}

	@Test
	public void MapValues() {
		tree.put(1, "1");
		tree.put(2, "2");
		tree.put(3, "3");
		tree.put(42, "42");
		Collection<String> set = tree.values();
		assertTrue("values() misses a Value",set.contains("1"));
		assertTrue("values() misses a Value",set.contains("2"));
		assertTrue("values() misses a Value",set.contains("3"));
		assertTrue("values() misses a Value",set.contains("42"));
	}


	@Test
	public void performaceTest() {
		for(int i=0;i<10000;i++){
			tree.put(i, String.valueOf(i));
		}
		assertEquals("performaceTest() failed",10000,tree.size());
	}
}
