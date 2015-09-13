/**
 * 
 */




import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MainTest {

	/**
	 * 
	 */
	private static final int LIMIT = 10000000;

	/**
	 * Test method for {@link Main#sort(int[])}.
	 */
	@Test
	public final void testSort() {
		int[] actuals = Main.sort(new int[] { 3, 1, 2, 4 });
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, actuals);
		Assert.assertEquals(2, Main.getInversionCount());

		Main.setInversionCount(0);
		actuals = Main.sort(new int[] { 3, 1, 2 });
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, actuals);
		Assert.assertEquals(2, Main.getInversionCount());

		
		Main.setInversionCount(0);
		
		actuals = Main.sort(new int[] { 2, 3, 8, 6, 1 });
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 6, 8 }, actuals);
		Assert.assertEquals(5, Main.getInversionCount());
		
		Main.setInversionCount(0);
		
		actuals = Main.sort(new int[] { 2, 8, 3, 6, 1 });
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 6, 8 }, actuals);
		Assert.assertEquals(6, Main.getInversionCount());
	}

	@Test
	public void testPerformance() {
		int[] arr = new int[LIMIT];
		int[] arr1 = new int[LIMIT];
		
		for (int i = 0; i < LIMIT; i++) {
			int value = (int) Math.random()*LIMIT;
			arr[i] = value;
			arr1[i] = value;
		}
		long startTime = System.currentTimeMillis();
		Arrays.sort(arr);
		System.out.println("System time : " + (System.currentTimeMillis() - startTime)+ " ms.");
		
		startTime = System.currentTimeMillis();
		int[] actuals = Main.sort(arr1);
		System.out.println("My time : " + (System.currentTimeMillis() - startTime)+ " ms.");
		Assert.assertArrayEquals(arr, actuals);
		
		
	}
}
