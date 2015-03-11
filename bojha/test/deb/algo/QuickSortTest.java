package deb.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	private static final int LIMIT = 10000000;

	@Test
	public void test() {
		QuickSort qsort= new QuickSort();
		Integer[] values = new Integer[LIMIT];
		for (int i = 0; i < LIMIT; i++) {
			values[i] = (int)(Math.random()*LIMIT);
		}
		qsort.qsort(values, 0, LIMIT - 1);
		assertTrue(SortUtil.isSortedAscending(values));
	}

}
