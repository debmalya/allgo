package deb.algo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MushroomPickerTest {

	@Test
	public void testGetMaxMushrooms() {
		MushroomPicker mp = new  MushroomPicker();
		int maxroom =mp.getMaxMushrooms(new int[]{2,3,7,5,1,3,9}, 4, 6);
		System.out.println(maxroom);
	}

	@Test
	public void testPrefixSum() {
		int a[] = new int[]{1,2,3};
		int p[] = new int[a.length];
		
		MushroomPicker mp = new  MushroomPicker();
		p = mp.prefixSum(a);
		
		assertEquals(1, p[0]);
		assertEquals(3, p[1]);
		assertEquals(6, p[2]);
		
		for (int i = 1; i < a.length; i++) {
			assertEquals(a[i],mp.countSum(p, i - 1, i));
		}
	}

}
