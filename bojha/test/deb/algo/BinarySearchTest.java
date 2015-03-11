package deb.algo;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testIsExists() {
		Integer[] values = new Integer[] { 10, 15, 18, 31, 34, 38, 42, 47, 49,
				50, 55, 57, 75, 80, 92 };
		BinarySearch search = new BinarySearch();
		Assert.assertFalse(search.isExists(values, 79, 0, values.length - 1));
		Assert.assertTrue(search.isExists(values, 10, 0, values.length - 1));
		Assert.assertTrue(search.isExists(values, 80, 0, values.length - 1));
	}

}
