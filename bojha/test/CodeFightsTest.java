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
	
}
