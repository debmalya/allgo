package deb.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortUtilTest {

	Integer[] ascending_values = new Integer[]{1,2,3,4,5,6,7,8,9};
	Integer[] descending_values = new Integer[]{9,8,7,6,5,4,3,2,1};
	@Test
	public void testIsSortedAscending() {		
		assertTrue(SortUtil.isSortedAscending(ascending_values));
		assertFalse(SortUtil.isSortedAscending(descending_values));
	}

	@Test
	public void testIsSortedDescending() {
		assertFalse(SortUtil.isSortedDescending(ascending_values));
		assertTrue(SortUtil.isSortedDescending(descending_values));
	}

}
