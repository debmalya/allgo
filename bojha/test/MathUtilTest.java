import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {

	@Test
	public void testGcd() {

		assertEquals(2, MathUtil.gcd(2, 6));
		assertEquals(2, MathUtil.gcd(2, 0));
		assertEquals(2, MathUtil.gcd(0, 2));
		assertEquals(0, MathUtil.gcd(0, 0));
		assertEquals(1, MathUtil.gcd(4, 3));
		assertEquals(1, MathUtil.gcd(3, 4));
	}

	@Test
	public void testLcd() {

		assertEquals(6, MathUtil.lcd(2, 6));
		assertEquals(0, MathUtil.lcd(2, 0));
		assertEquals(12, MathUtil.lcd(4, 3));
		assertEquals(12, MathUtil.lcd(3, 4));
	}

	@Test
	public void testGetBinary() {
		MathUtil util = new MathUtil();
		Assert.assertTrue("1".equals(util.toBinaryString(1)));
		Assert.assertTrue("10".equals(util.toBinaryString(2)));
		Assert.assertTrue("11".equals(util.toBinaryString(3)));
		Assert.assertTrue("100".equals(util.toBinaryString(4)));
		Assert.assertTrue("101".equals(util.toBinaryString(5)));
		Assert.assertTrue("110".equals(util.toBinaryString(6)));
		Assert.assertTrue("111".equals(util.toBinaryString(7)));
	}

	@Test
	public void testHighestPalindrome() {
		MathUtil util = new MathUtil();

		assertEquals(9009, util.getHighestPalindrome(2));
		System.out.println(util.getHighestPalindrome(3));
	}

	@Test
	public void testPalindrome() {
		MathUtil util = new MathUtil();
		long value = 99999L;

		while (true) {
			int divisor = 100;
			while (divisor < 1000) {
				
				if (util.isPalindrom(String.valueOf(value))) {
					System.out.println(value);
					long dividend = value / divisor;
					if (value % divisor == 0 && dividend > 100) {
						System.out.println("Looking for :" + value+ " dividend " + dividend + " divisor "+divisor);
						return;
					}
					divisor++;
				}
				value--;
			}
		}

	}
	
	@Test
	public void testGetNumberOfInversions() {
		Assert.assertEquals(0,MathUtil.getNumberOfInversions(123));
		Assert.assertEquals(1,MathUtil.getNumberOfInversions(213));
		Assert.assertEquals(1,MathUtil.getNumberOfInversions(132));
		Assert.assertEquals(2,MathUtil.getNumberOfInversions(312));
		Assert.assertEquals(3,MathUtil.getNumberOfInversions(321));
	}
	
	@Test
	public void prefixSum() {
		int[] arr = new int[]{1,2,3,4,5};
		int[][] result = MathUtil.getSum(arr);
		
		int[] prefixSum = new int[]{1,3,6,10,15};
		Assert.assertArrayEquals(prefixSum, result[0]);
		
		int[] expected = new int[]{15,14,12,9,5};
		Assert.assertArrayEquals(expected, result[1]);
	}

}
