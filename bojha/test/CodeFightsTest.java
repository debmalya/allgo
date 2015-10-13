import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class CodeFightsTest {

	/**
	 * Test method for {@link CodeFights#minBoxes(int[])}.
	 */
	// @Test
	public final void testMinBoxes() {
		CodeFights fights = new CodeFights();
		int actual = fights.minBoxes(new int[] { 9, 9, 9, 3 });
		Assert.assertEquals(4, actual);

		actual = fights.minBoxes(new int[] { 6, 7, 2, 4 });
		Assert.assertEquals(2, actual);

		actual = fights.minBoxes(new int[] { 6, 7, 3, 4 });
		Assert.assertEquals(2, actual);

		actual = fights.minBoxes(new int[] { 6, 7, 4, 4 });
		Assert.assertEquals(3, actual);

		actual = fights.minBoxes(new int[] { 9, 9, 9, 3 });
		Assert.assertEquals(4, actual);

		actual = fights.minBoxes(new int[] { 7, 4, 2, 3, 5, 1, 8 });
		Assert.assertEquals(3, actual);

	}

	@Test
	public final void testMobious() {
		CodeFights fights = new CodeFights();
		int actual = fights.mobious("10");
		Assert.assertEquals(1, actual);
	}

	@Test
	public final void testChandosNumber() {
		CodeFights fights = new CodeFights();
		int actual = fights.nthChandosNumber(1);
		Assert.assertEquals(5, actual);
		actual = fights.nthChandosNumber(2);
		Assert.assertEquals(25, actual);
		actual = fights.nthChandosNumber(3);
		Assert.assertEquals(30, actual);

		actual = fights.nthChandosNumber(4);
		Assert.assertEquals(125, actual);

		actual = fights.nthChandosNumber(5);
		Assert.assertEquals(130, actual);

		actual = fights.nthChandosNumber(9);
		Assert.assertEquals(630, actual);
	}

	@Test
	public final void testNum_Calc() {
		CodeFights fights = new CodeFights();
		int actual = fights.Num_Calc(10);
		Assert.assertEquals(6, actual);

		actual = fights.Num_Calc(9);
		Assert.assertEquals(7, actual);

		actual = fights.Num_Calc(8);
		Assert.assertEquals(3, actual);
	}

	@Test
	public final void testisPairMult() {
		CodeFights fights = new CodeFights();
		Assert.assertTrue(fights.isPairMult(new int[] { 1, 2, 3, 6, 15, 25 },
				30));
		Assert.assertFalse(fights.isPairMult(new int[] { 2, 3, 6, 15, 25 }, 10));
		Assert.assertTrue(fights.isPairMult(new int[] { 1, 2, 3 }, 6));
	}

	@Test
	public final void testDigital_Number() {
		CodeFights fights = new CodeFights();
		Assert.assertTrue(fights.digital_number("29562"));
		Assert.assertFalse(fights.digital_number("1"));
		Assert.assertFalse(fights.digital_number("77"));
		Assert.assertFalse(fights.digital_number("29962"));
		Assert.assertTrue(fights.digital_number("000"));
	}

	@Test
	public final void testmax_num_of_ele() {
		CodeFights fights = new CodeFights();
		Assert.assertEquals(2,
				fights.max_num_of_ele(10, new int[] { 10, 3, 7 }));
		Assert.assertEquals(3,
				fights.max_num_of_ele(3, new int[] { 1, 1, 2, 1 }));
	}

	@Test
	public void testmissingNumber() {
		CodeFights fights = new CodeFights();
		int actual = fights.missingNumber(new int[] { 1, 2, 4, 5 });
		Assert.assertEquals(3, actual);

		actual = fights.missingNumber(new int[] { 10, 2, 5, 7, 3, 6, 8, 1, 4 });
		Assert.assertEquals(9, actual);

		actual = fights.missingNumber(new int[] { 5, 2, 4, 1 });
		Assert.assertEquals(3, actual);

		actual = fights.missingNumber(new int[] { 6, 8, 3, 10, 1, 9, 2, 5, 7 });
		Assert.assertEquals(4, actual);
	}

	@Test
	public void testLuckyNumber() {
		CodeFights fights = new CodeFights();
		int actual = fights.LuckyNum(1, 3);
		Assert.assertEquals(-1, actual);

		actual = fights.LuckyNum(4, 7);
		Assert.assertEquals(4, actual);

		actual = fights.LuckyNum(5, 7);
		Assert.assertEquals(7, actual);

		actual = fights.LuckyNum(35, 47);
		Assert.assertEquals(44, actual);

		actual = fights.LuckyNum(45, 57);
		Assert.assertEquals(47, actual);

		actual = fights.LuckyNum(3, 77);
		Assert.assertEquals(4, actual);

		actual = fights.LuckyNum(450, 777);
		Assert.assertEquals(474, actual);

		actual = fights.LuckyNum(0, 10000);
		Assert.assertEquals(4, actual);

	}

	@Test
	public void test() {
		int[][] votes = { { 1, 2 }, { -1, -2 }, { 1, -2 }, { -1, 2 } };
		Assert.assertFalse(CodeFights.jury_compability(2, 4, votes));

		votes = new int[][] { {1,2},{-1,-2},{1,-2},{-1,2} };
		Assert.assertFalse(CodeFights.jury_compability(2, 4, votes));
		
		votes = new int[][] { {1,2},{-1,-2},{1,-2}};
		Assert.assertTrue(CodeFights.jury_compability(2,3,votes));
		
		votes = new int[][]{{1,2},{-1,-2},{3,1}};
		Assert.assertTrue(CodeFights.jury_compability(3,3,votes));
		
		votes = new int[][]{{1,2},{-1,-2},{4,5}};
		Assert.assertFalse(CodeFights.jury_compability(5,3,votes));
				

	}
	
	@Test
	public void test_correct_parentheses(){
		Assert.assertTrue(CodeFights.correct_parentheses("([])"));
		Assert.assertTrue(CodeFights.correct_parentheses("()()()()[]"));
		
		Assert.assertFalse(CodeFights.correct_parentheses("([)]"));
		Assert.assertFalse(CodeFights.correct_parentheses("("));		
		Assert.assertFalse(CodeFights.correct_parentheses("[]]"));
	}
	
	@Test
	public void test_StudyingHours(){
		int actual = CodeFights.StudyingHours(6, new int[]{2,2,1,3,4,1});
		Assert.assertEquals(3, actual);
		
		actual = CodeFights.StudyingHours(3, new int[]{2,2,9});
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public void test_encryption() {
		String actual = CodeFights.vigenere_encode("when the leaves fall", "autumn");
		Assert.assertEquals("wbxh fue fxuhrs ztfx",actual);
		
		actual = CodeFights.vigenere_encode("adinvy","a");
		Assert.assertEquals("adinvy",actual);
		
		actual = CodeFights.vigenere_encode("facebook","fb");
		Assert.assertEquals("kbhfgptl",actual);
		
		actual = CodeFights.vigenere_encode("when the leaves fall", "a u tumn");
		Assert.assertEquals("wbxh fue fxuhrs ztfx",actual);
	}
	
	@Test
	public void test_strings() {
		int actual = CodeFights.strings("abab");
		Assert.assertEquals(2, actual);
		
		actual = CodeFights.strings("acbab");
		Assert.assertEquals(1, actual);
		
		actual = CodeFights.strings("abbb");
		Assert.assertEquals(1, actual);
		
		
		actual = CodeFights.strings("abababaaaaaaaaa");
		Assert.assertEquals(4, actual);
		
		actual = CodeFights.strings("raju");
		Assert.assertEquals(0, actual);
		
		actual = CodeFights.strings("rajur");
		Assert.assertEquals(1, actual);
		
		actual = CodeFights.strings("rajuru");
		Assert.assertEquals(1, actual);
		
		actual = CodeFights.strings("rajurua");
		Assert.assertEquals(1, actual);
		
		actual = CodeFights.strings("sandipan");
		Assert.assertEquals(2, actual);
	}
	
	
	@Test
	  public void test_sumofprimenumbers() {
	    int actual = CodeFights.sumofprimenumbers (3, new int[]{11, 21, 54});
	    Assert.assertEquals(2,actual);
	    
	    actual = CodeFights.sumofprimenumbers (4, new int[]{22, 7, 121, 17});
	    Assert.assertEquals(15,actual);
	    
	    actual = CodeFights.sumofprimenumbers (2, new int[]{2,3});
	    Assert.assertEquals(5,actual);
	    
	    actual = CodeFights.sumofprimenumbers (2, new int[]{1,2});
	    Assert.assertEquals(2,actual);
	    
	    actual = CodeFights.sumofprimenumbers (2, new int[]{1,0});
	    Assert.assertEquals(0,actual);
	    
	    actual = CodeFights.sumofprimenumbers (4, new int[]{1,2,3,5});
	    Assert.assertEquals(10,actual);
	    
	    actual = CodeFights.sumofprimenumbers (5, new int[]{1,2,3,5,6});
	    Assert.assertEquals(10,actual);
	    
	    actual = CodeFights.sumofprimenumbers (5, new int[]{1,2,3,5,7});
	    Assert.assertEquals(17,actual);
	    
	    actual = CodeFights.sumofprimenumbers (4, new int[]{1,2,3,5,7});
	    Assert.assertEquals(10,actual);
	    
	    actual = CodeFights.sumofprimenumbers (3, new int[]{1,2,47});
	    Assert.assertEquals(13,actual);
	    
	    actual = CodeFights.sumofprimenumbers (1, new int[]{5});
	    Assert.assertEquals(5,actual);
	    
	    actual = CodeFights.sumofprimenumbers (1, new int[]{6});
	    Assert.assertEquals(0,actual);
	    
	    actual = CodeFights.sumofprimenumbers (2, new int[]{101,103});
	    Assert.assertEquals(6,actual);
	    
	    actual = CodeFights.sumofprimenumbers (26, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26});
	    Assert.assertEquals(46,actual);
	    
	    
	    
	  }
	
	@Test
	public void testReversePrime(){
		int actual = CodeFights.ReversePrime(2, 7);
		Assert.assertEquals(4, actual);
		
		actual = CodeFights.ReversePrime(1, 2);
		Assert.assertEquals(1, actual);
		
		actual = CodeFights.ReversePrime(3, 11);
		Assert.assertEquals(4, actual);
		
		actual = CodeFights.ReversePrime(3, 5);
		Assert.assertEquals(2, actual);
		
		actual = CodeFights.ReversePrime(4, 5);
		Assert.assertEquals(4, actual);
		
		actual = CodeFights.ReversePrime(2, 5);
		Assert.assertEquals(3, actual);
		
		actual = CodeFights.ReversePrime(2, 7);
		Assert.assertEquals(4, actual);
		
		actual = CodeFights.ReversePrime(3, 7);
		Assert.assertEquals(5, actual);
		
		actual = CodeFights.ReversePrime(4, 7);
		Assert.assertEquals(2, actual);
		
		actual = CodeFights.ReversePrime(5, 7);
		Assert.assertEquals(3, actual);
		
		actual = CodeFights.ReversePrime(6, 7);
		Assert.assertEquals(6, actual);
		
		for (int i = 1; i < 11; i++) {
			actual = CodeFights.ReversePrime(i, 11);
			
		}
		
		int i = (int)Math.pow(10, 9) + 7;
		
		
		Assert.assertEquals(1, CodeFights.ReversePrime(1, i));
		Assert.assertEquals(500000004, CodeFights.ReversePrime(2, i));
		
		Assert.assertEquals(489,CodeFights.ReversePrime(2, 977));
	}
	
	@Test
	public void test_coins() {
		int actual = CodeFights.coins(5, 8, new int[]{2,5,3,3,2});
		Assert.assertEquals(4,actual);
		
		actual = CodeFights.coins(5, 7, new int[]{2,5,3,3,2});
		Assert.assertEquals(2,actual);
		
		actual = CodeFights.coins(1, 1, new int[]{1});
		Assert.assertEquals(1,actual);
	}
	
	@Test
	public void test_CountingDigits(){
		Assert.assertEquals(11,CodeFights.CountingDigits(10));
//		Assert.assertEquals(13,CodeFights.CountingDigits(11));
	}
	
	@Test
	public void test_wellOrdered() {
		Assert.assertTrue(CodeFights.wellOrderedNumber(1489));
		Assert.assertFalse(CodeFights.wellOrderedNumber(4189));
		Assert.assertFalse(CodeFights.wellOrderedNumber(4198));
	}
	
	@Test
	  public void test_wellOrderedNumber() {
		Assert.assertFalse (CodeFights.wellOrderedNumber (132));
		Assert.assertTrue (CodeFights.wellOrderedNumber (1567));
		Assert.assertTrue (CodeFights.wellOrderedNumber (1));
		Assert.assertTrue (CodeFights.wellOrderedNumber (12));
		Assert.assertFalse (CodeFights.wellOrderedNumber (1234567890));
		Assert.assertTrue (CodeFights.wellOrderedNumber (123456789));
	  }
	
	@Test
	public void test_rank() {
		
		int[] ar = new int[]{3,2,3,4,1};
		int actual = CodeFights.RankOfElement(ar, 0);
		Assert.assertEquals(2, actual);
		
		ar = new int[]{3,2,3,4,1};
		actual = CodeFights.RankOfElement(ar, 1);
		Assert.assertEquals(1, actual);
	}
	
	
	@Test
	public void testPyramidMatrix() {
		int[][] actuals = CodeFights.pyramidMatrix(1);
		int[][] expecteds = new int[][]{{1}};
		
		checkArrays(actuals, expecteds);
		
		actuals = CodeFights.pyramidMatrix(2);		
		expecteds = new int[][]{{1,1},{1,1}};
		checkArrays(actuals, expecteds);
		
//		printArray(actuals);
		
		actuals = CodeFights.pyramidMatrix(3);		
		expecteds = new int[][]{{1,1,1},{1,2,1},{1,1,1}};
		checkArrays(actuals, expecteds);
//		printArray(actuals);
		
		actuals = CodeFights.pyramidMatrix(4);
		expecteds = new int[][]{{1,1,1,1},{1,2,2,1},{1,2,2,1},{1,1,1,1}};
		checkArrays(actuals, expecteds);
//		printArray(actuals);
		
		actuals = CodeFights.pyramidMatrix(5);
		expecteds = new int[][]{{1,1,1,1,1},{1,2,2,2,1},{1,3,4,3,1},{1,2,2,2,1},{1,1,1,1,1}};
		checkArrays(actuals, expecteds);
//		printArray(actuals);
		
		actuals = CodeFights.pyramidMatrix(100);
		actuals = CodeFights.pyramidMatrix(99);
//		printArray(actuals);

	}
	
	
	@Test
	public void test_digits() {
		int actual = CodeFights.digit(20, 22);
		Assert.assertEquals(2, actual);
		
		actual = CodeFights.digit(29, 30);
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testRomanNumerals() {
		int actual = CodeFights.RomanNumerals("I");
		Assert.assertEquals(1, actual);
		
		actual = CodeFights.RomanNumerals("V");
		Assert.assertEquals(5, actual);
		
		actual = CodeFights.RomanNumerals("X");
		Assert.assertEquals(10, actual);
		
		actual = CodeFights.RomanNumerals("L");
		Assert.assertEquals(50, actual);
		
		actual = CodeFights.RomanNumerals("C");
		Assert.assertEquals(100, actual);
		
		actual = CodeFights.RomanNumerals("D");
		Assert.assertEquals(500, actual);
		
		actual = CodeFights.RomanNumerals("M");
		Assert.assertEquals(1000, actual);
		
		actual = CodeFights.RomanNumerals("II");
		Assert.assertEquals(2, actual);
		
		actual = CodeFights.RomanNumerals("IIA");
		Assert.assertEquals(-1, actual);
		
		actual = CodeFights.RomanNumerals("XIV");
		Assert.assertEquals(14, actual);
		
		actual = CodeFights.RomanNumerals("XVI");
		Assert.assertEquals(16, actual);
		
		actual = CodeFights.RomanNumerals("XX");
		Assert.assertEquals(20, actual);
		
		actual = CodeFights.RomanNumerals("CMD");
		Assert.assertEquals(1400, actual);
		
		actual = CodeFights.RomanNumerals("CD");
		Assert.assertEquals(400, actual);
		
		actual = CodeFights.RomanNumerals("MCMIV");
		Assert.assertEquals(1904, actual);
		
		actual = CodeFights.RomanNumerals("MCMLIV");
		Assert.assertEquals(1954, actual);
		
		actual = CodeFights.RomanNumerals("MCMXC");
		Assert.assertEquals(1990, actual);
		
		actual = CodeFights.RomanNumerals("MMXIV");
		Assert.assertEquals(2014, actual);
		
		actual = CodeFights.RomanNumerals("MMXV");
		Assert.assertEquals(2015, actual);
		
		actual = CodeFights.RomanNumerals("MCMLXXI");
		Assert.assertEquals(1971, actual);
		
		actual = CodeFights.RomanNumerals("MMMCCCXXXIII");
		Assert.assertEquals(3333, actual);
		
		actual = CodeFights.RomanNumerals("MMMMCMXCIX");
		Assert.assertEquals(4999, actual);
	}
	
	@Test
	public void testTwoPrimes() {
		Assert.assertTrue(CodeFights.TwoPrimes(2, 3));
	}
	
	private void printArray(int[][] actuals) {
		System.out.println("==================================");
		for (int i = 0; i < actuals.length; i++) {
			System.out.println(Arrays.toString(actuals[i]));
		}
	}

	private void checkArrays(int[][] actuals, int[][] expecteds) {
		
		for (int i = 0; i < expecteds.length; i++) {
			Assert.assertArrayEquals(expecteds[i], actuals[i]);
		}
	}
	
	
}
