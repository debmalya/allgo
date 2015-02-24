package deb.algo;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

	@Test
	public void testSort() {
		Integer[] values = new Integer[10];
		
		for (int i = 0; i < 10; i++) {
			values[i] = (int)(Math.random()*1000);
		}
		
		SelectionSort sort = new SelectionSort();
		values = (Integer[])sort.sort(values);
		
		for (int i = 0; i < 10;i++) {
			System.out.println(values[i]);
			if (i > 0) {
				Assert.assertTrue(values[i- 1] <= values[i]);
			}
		}
	}

}
