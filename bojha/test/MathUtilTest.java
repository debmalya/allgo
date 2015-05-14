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
	public void prefixSuffixSum() {
		int[] arr = new int[]{1,2,3,4,5};
		int[][] result = MathUtil.getSum(arr);
		
		int[] prefixSum = new int[]{1,3,6,10,15};
		Assert.assertArrayEquals(prefixSum, result[0]);
		
		int[] expected = new int[]{15,14,12,9,5};
		Assert.assertArrayEquals(expected, result[1]);
	}
	
	@Test
	public void getMathcingSum() {
		int index = MathUtil.getMatchingSum(new int[]{2,3,1,6});
		Assert.assertEquals(2, index);
		
		index = MathUtil.getMatchingSum(new int[]{5,4,2,3,1,2});
		Assert.assertEquals(2, index);
		
		index = MathUtil.getMatchingSum(new int[]{6, 1, -1, 1, -1, 1, -1});
		Assert.assertEquals(2, index);
		
		index = MathUtil.getMatchingSum("3 0 0 0");
		Assert.assertEquals(1, index);
		
		index = MathUtil.getMatchingSum("3 0 1 2");
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum("3 1 1 1");
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum("1 3 1 1 1");
		Assert.assertEquals(1, index);
		
		index = MathUtil.getMatchingSum("3 0 1 1 1");
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum("5 4 -2 1 1 -2");
		Assert.assertEquals(3, index);
		
		index = MathUtil.getMatchingSum("5 9 8");
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum("5 9 1 8");
		Assert.assertEquals(1, index);
	}
	
	@Test
	public void getMaxDigit() {
		Assert.assertEquals(1,MathUtil.maxDigit(100));
		Assert.assertEquals(9,MathUtil.maxDigit(999));
		Assert.assertEquals(9,MathUtil.maxDigit(889));
		Assert.assertEquals(0,MathUtil.maxDigit(000));
		
		Assert.assertEquals(1,MathUtil.maxDigit(-100));
		Assert.assertEquals(9,MathUtil.maxDigit(-999));
		Assert.assertEquals(9,MathUtil.maxDigit(-889));
		Assert.assertEquals(0,MathUtil.maxDigit(-000));
	}

}
