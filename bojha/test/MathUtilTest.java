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
		
	}

	@Test
	public void testPalindrome() {
		MathUtil util = new MathUtil();
		long value = 99999L;

		while (true) {
			int divisor = 100;
			while (divisor < 1000) {
				
				if (util.isPalindrom(String.valueOf(value))) {
					
					long dividend = value / divisor;
					if (value % divisor == 0 && dividend > 100) {
						
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
	
//	@Test
	public void testEqui() {
		int index = MathUtil.equi(new int[]{2,3,1,6});
		Assert.assertEquals(2, index);
		
		index = MathUtil.equi(new int[]{5,4,2,3,1,2});
		Assert.assertEquals(2, index);
		
		index = MathUtil.equi(new int[]{6, 1, -1, 1, -1, 1, -1});
		Assert.assertEquals(2, index);
		
		index = MathUtil.equi(new int[]{3 ,0, 0, 0});
		Assert.assertEquals(1, index);
		
		index = MathUtil.equi(new int[]{3, 0, 1, 2});
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum(new int[]{3, 1, 1, 1});
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum(new int[]{ 3, 1, 1, 1});
		Assert.assertEquals(1, index);
		
		index = MathUtil.getMatchingSum(new int[]{3, 0, 1, 1, 1});
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum(new int[]{5 ,4, -2, 1, 1, -2});
		Assert.assertEquals(3, index);
		
		index = MathUtil.getMatchingSum(new int[]{5, 9, 8});
		Assert.assertEquals(0, index);
		
		index = MathUtil.getMatchingSum(new int[]{5, 9, 1, 8});
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
	
	@Test
	public void getMinDigit() {
		Assert.assertEquals(0,MathUtil.minDigit(100));
		Assert.assertEquals(9,MathUtil.minDigit(999));
		Assert.assertEquals(8,MathUtil.minDigit(889));
		Assert.assertEquals(0,MathUtil.minDigit(000));
		
		Assert.assertEquals(0,MathUtil.minDigit(-100));
		Assert.assertEquals(9,MathUtil.minDigit(-999));
		Assert.assertEquals(8,MathUtil.minDigit(-889));
		Assert.assertEquals(0,MathUtil.minDigit(-000));
	}

	/**
	 * Find out if binomial coefficient C(n,k) is divisible by the given positive integer number d.
	 * @param n 1<=n<=1000
	 * @param k 1<=k<=n
	 * @param d 2<=d<=1000000
	 * @return 1 if C(n,k) is divisible by d, 0 otherwise
	 */
	@Test
	public void getConbinatoricFactor2() {
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(6, 2, 6));
		Assert.assertEquals(1,MathUtil.conbinatoricFactor2(6, 2, 5));
		Assert.assertEquals(1,MathUtil.conbinatoricFactor2(6, 2, 3));
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(6, 2, 2));
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(6, 0, 2));
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(6, 0, 1000));
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(1000, 1, 1000000));
		Assert.assertEquals(1,MathUtil.conbinatoricFactor2(1000, 1, 1000));
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(1, 1, 2));
		Assert.assertEquals(1,MathUtil.getBinaryCoefficient(4, 0));
		Assert.assertEquals(4,MathUtil.getBinaryCoefficient(4, 1));
		Assert.assertEquals(6,MathUtil.getBinaryCoefficient(4, 2));
		Assert.assertEquals(4,MathUtil.getBinaryCoefficient(4, 3));
		Assert.assertEquals(1,MathUtil.getBinaryCoefficient(4, 4));
		Assert.assertEquals(1,MathUtil.getBinaryCoefficient(1000, 0));
		Assert.assertEquals(1000,MathUtil.getBinaryCoefficient(1000, 999));
		Assert.assertEquals(1000,MathUtil.getBinaryCoefficient(1000, 1));
		Assert.assertEquals(1,MathUtil.getBinaryCoefficient(1000, 1000));
		Assert.assertEquals(747697931370219115L,MathUtil.getBinaryCoefficient(1000, 500));
		Assert.assertEquals(0,MathUtil.conbinatoricFactor2(1000, 500, 1000));
		Assert.assertEquals(1,MathUtil.conbinatoricFactor2(1000, 1, 1000));
		Assert.assertEquals(1,MathUtil.conbinatoricFactor2(1000, 999, 1000));
		
		Assert.assertEquals(1,MathUtil.getBinaryCoefficient(1, 1));
		
		
	}

	@Test
	public void testProcess() {
		int[] result = MathUtil.process(new int[]{-1, 2,-3,4,-5},0);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
		result = MathUtil.process(new int[]{-1,-3,4,-5},0);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
	}
	
	@Test
	public void testMex(){
		int actual = MathUtil.mex(new int[]{0,2,4,4,2,1,10});
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public void testImba() {
		String actual = MathUtil.imba(3);		
		Assert.assertEquals("2 1 3", actual);
		
		actual = MathUtil.imba(2);		
		Assert.assertEquals("1 2", actual);
		
		actual = MathUtil.imba(4);		
		Assert.assertEquals("2 3 1 4", actual);
		
		actual = MathUtil.imba(5);		
		Assert.assertEquals("3 2 4 1 5", actual);
	}
}
