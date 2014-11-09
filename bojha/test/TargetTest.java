import junit.framework.Assert;

import org.junit.Test;

public class TargetTest {

	/**
	 * This method is to test invalid input. For value less than 4.
	 */
	@Test
	public void testInvalidInputLowerEnd() {
		Target target = new Target();
		try {
			target.draw(3);
			Assert.assertFalse("Not a valid argument must throw exception",
					true);
		} catch (IllegalArgumentException iae) {
			Assert
					.assertTrue("Not a valid argument must throw exception",
							true);
		}
	}

	/**
	 * This method is to test invalid input. For value greater than 49.
	 */
	@Test
	public void testInvalidInputUpperEnd() {
		Target target = new Target();
		try {
			target.draw(53);
			Assert.assertFalse("Not a valid argument must throw exception",
					true);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Passed integer be between 5 and 49, inclusive.",
					iae.getMessage().equals(
							"Passed integer be between 5 and 49, inclusive."));
			Assert
					.assertTrue("Not a valid argument must throw exception",
							true);
		}
	}

	/**
	 * This method is to test invalid input. For value not in format 4k+1
	 */
	@Test
	public void testInvalidInput() {
		Target target = new Target();
		try {
			target.draw(6);
			Assert.assertFalse("Not a valid argument must throw exception",
					true);
		} catch (IllegalArgumentException iae) {
			Assert
					.assertTrue("Passed integer must be of form 4K+1", iae
							.getMessage().equals(
									"Passed integer must be of form 4K+1"));
			Assert
					.assertTrue("Not a valid argument must throw exception",
							true);
		}
	}

	/**
	 * This method test valid input.
	 */
	@Test
	public void testValidInput() {
		Target target = new Target();
		try {
			for (int i = 4; i < 49; i += 4) {
				String[] result = target.draw(i + 1);
				Assert.assertTrue("Must have " + (i + 1)
						+ " characters but found " + result.length
						+ " characters.", result.length == (i + 1));
				Assert.assertTrue("Expected " + result[0] + " but found "
						+ result[result.length - 1], result[0]
						.equals(result[result.length - 1]));
				printResult(result, i + 1);
			}

		} catch (IllegalArgumentException iae) {
			Assert.assertFalse("There should not be any exception", true);
		}
	}

	@Test
	public void test5() {
		String[] five = new String[] { "#####", "#   #", "# # #", "#   #",
				"#####" };
		Target target = new Target();
		String[] result = target.draw(5);
		for (int i = 0; i < result.length; i++) {
			if (!result[i].equals(five[i])) {
				Assert.assertFalse("Expected " + five[i] + " but found "
						+ result[i], true);
			}
		}

	}

	@Test
	public void test9() {
		String[] five = new String[] { "#########", "#       #", "# ##### #",
				"# #   # #", "# # # # #", "# #   # #", "# ##### #",
				"#       #", "#########" };
		Target target = new Target();
		String[] result = target.draw(9);
		for (int i = 0; i < result.length; i++) {
			if (!result[i].equals(five[i])) {
				Assert.assertFalse("Expected " + five[i] + " but found "
						+ result[i], true);
			}
		}

	}

	@Test
	public void test13() {
		String[] five = new String[] { "#############", "#           #",
				"# ######### #", "# #       # #", "# # ##### # #",
				"# # #   # # #", "# # # # # # #", "# # #   # # #",
				"# # ##### # #", "# #       # #", "# ######### #",
				"#           #", "#############" };
		Target target = new Target();
		String[] result = target.draw(13);
		for (int i = 0; i < result.length; i++) {
			if (!result[i].equals(five[i])) {
				Assert.assertFalse("Expected " + five[i] + " but found "
						+ result[i], true);
			}
		}

	}

	@Test
	public void test17() {
		String[] five = new String[] { "#################",
				"#               #", "# ############# #", "# #           # #",
				"# # ######### # #", "# # #       # # #", "# # # ##### # # #",
				"# # # #   # # # #", "# # # # # # # # #", "# # # #   # # # #",
				"# # # ##### # # #", "# # #       # # #", "# # ######### # #",
				"# #           # #", "# ############# #", "#               #",
				"#################" };
		Target target = new Target();
		String[] result = target.draw(17);
		for (int i = 0; i < result.length; i++) {
			if (!result[i].equals(five[i])) {
				Assert.assertFalse("Expected " + five[i] + " but found "
						+ result[i], true);
			}
		}

	}

	private void printResult(String[] result, int i) {
		System.out.println("-----------" + result.length);
		for (String each : result) {
			Assert.assertTrue("Each string must have " + i + " characters.",
					each.length() == i);
			System.out.println(each);
		}

	}

	/**
	 * Check whether middle row formed correctly or not.
	 */
	@Test
	public void testMiddleRow() {
		Target target = new Target();
		for (int i = 4; i < 49; i += 4) {
			String[] result = target.getMiddleNLastRow(i + 1);
			Assert.assertTrue(result[0].length() == i + 1);
			Assert.assertTrue(result[0].contains("# "));

			Assert.assertTrue(result[1].length() == i + 1);
			Assert.assertTrue(result[1].contains("#"));
			Assert.assertTrue(result[1], !result[1].contains(" "));
		}
	}

}
