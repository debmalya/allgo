package ht;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyGuruTest {

	@Test
	public void testProcesss() {
		
		assertTrue(PropertyGuru.processs("[[4,4],8]"));
		assertTrue(PropertyGuru.processs("[3,?]"));
		assertTrue(PropertyGuru.processs("[?,[?,?]]"));
		assertFalse(PropertyGuru.processs("[[[?,?],5],?]"));
		assertTrue(PropertyGuru.processs("[[[5,?],10],[?,?]]"));
		
		assertFalse(PropertyGuru.processs("[[3,4]"));
		assertFalse(PropertyGuru.processs("[[4,3]"));
		assertFalse(PropertyGuru.processs("[[?,?],5]"));
		assertFalse(PropertyGuru.processs("[[4,3],8]"));
		
		
		assertTrue(PropertyGuru.processs("[?,?]"));
		
		assertTrue(PropertyGuru.processs("[[?,?],?]"));
		assertTrue(PropertyGuru.processs("[[?,?],8]"));
		assertTrue(PropertyGuru.processs("[?,?]"));
		
		assertTrue(PropertyGuru.processs("[?,3]"));
		
	}
	
	private static final int TEST_MAX = 1000000000;
	public static int MAX = 1000000000;

	@Test
	public void checkLimit() {
		int i = MAX;
		int count = 0;
		for (; i > 0; i += i) {
			count++;

		}

	}

	@Test
	public void testProcessMainUnit() {
		assertTrue("NO".equals(PropertyGuru.processMainUnit("5,4")));
		assertTrue("NO".equals(PropertyGuru.processMainUnit("4,5")));
		assertTrue("NO".equals(PropertyGuru.processMainUnit("??,5")));
		assertTrue("8".equals(PropertyGuru.processMainUnit("4,4")));
		String result = PropertyGuru.processMainUnit("4,?");
		assertTrue("8".equals(result));

		result = PropertyGuru.processMainUnit("?,4");
		assertTrue("8".equals(result));

		result = PropertyGuru.processMainUnit("16,?????");
		assertTrue("32".equals(result));
	}

	@Test
	public void test() {
		assertTrue(PropertyGuru.processs("[[99999999,99999999],?]"));
		assertFalse(PropertyGuru.processs("[3,4]"));
		assertFalse(PropertyGuru.processs("[4,3]"));
		int max = Integer.MAX_VALUE;
		assertFalse(PropertyGuru.processs("[" + max + "," + (max - 1) + "]"));

		assertTrue(PropertyGuru.processs("[?,?]"));
		assertTrue(PropertyGuru.processs("[4,?]"));
		assertTrue(PropertyGuru.processs("[?,3]"));

		assertTrue(PropertyGuru.processs("[" + max + "," + max + "]"));
		assertTrue(PropertyGuru.processs("[?,[?,?]]"));
		assertTrue(PropertyGuru.processs("[?,[?,8]]"));

		assertFalse(PropertyGuru.processs("[[?,?],5]"));
		assertTrue(PropertyGuru.processs("[[?,?],4]"));
		assertFalse(PropertyGuru.processs("[[[?,?],5],?]"));

		assertTrue(PropertyGuru.processs("[3,?]"));
		assertTrue(PropertyGuru.processs("[?,[?,?]]"));
		assertTrue(PropertyGuru.processs("[[[5,?],10],[?,?]]"));
		assertFalse(PropertyGuru.processs("[[[5,?],11],[?,?]]"));
		assertFalse(PropertyGuru.processs("[[[5,?],20],[?,?]]"));
		assertTrue(PropertyGuru.processs("[[[?,?],?],[10,10]]"));

		assertFalse(PropertyGuru.processs("[[3,4],8]"));
		assertTrue(PropertyGuru.processs("[[4,4],8]"));
		assertFalse(PropertyGuru.processs("[[3,4],7],14]"));

		assertFalse(PropertyGuru.processs("[[[20,?],?],[10,10]]"));

		assertTrue(PropertyGuru.processs("[8,[?,[?,[?,?]]]]"));
		assertTrue(PropertyGuru.processs("[[[[?,?],?],?],8]"));

		assertTrue(PropertyGuru.processs("[[[[1,?],?],?],8]"));
		assertTrue(PropertyGuru.processs("[[" + TEST_MAX + "," + TEST_MAX + "],?]"));
		assertTrue(PropertyGuru.processs("[[[" + TEST_MAX + "," + TEST_MAX + "],?],?]"));
		assertTrue(PropertyGuru.processs("[[[[" + TEST_MAX + "," + TEST_MAX
				+ "],?],?],?]"));
		assertTrue(PropertyGuru.processs("[4,[?,[?,?]]]"));
		assertTrue(PropertyGuru.processs("[16,[?,[?,[?,?]]]]"));
		assertTrue(PropertyGuru.processs("[16,[?,[?,[?,[?,?]]]]]"));

		String testString = generateTestCasePrepend(256);
		assertTrue(PropertyGuru.processs(testString));

		testString = generateTestCasePrependWithValues(256);
		assertTrue(PropertyGuru.processs(testString));
		
	}

	/**
	 * 
	 * @param i
	 *            weight from which main unit will start. It can hold upto
	 *            1000000000.
	 * @return test string
	 */
	public String generateTestCasePrependWithValues(int i) {
		StringBuilder testString = new StringBuilder(4000);
		int total = 0;
		while (total < TEST_MAX) {
			if (total == 0) {
				// first time
				testString.append("[");
				testString.append(i);
				testString.append(",");
				testString.append(i);
				testString.append("]");
				total = (i * 2);
			}
			testString.insert(0, "[" + total + ",");
			testString.append("]");
			total += total;
		}
		return testString.toString();
	}

	/**
	 * 
	 * @param i
	 *            weight from which main unit will start. It can hold upto
	 *            1000000000.
	 * @return test string
	 */
	public String generateTestCasePrepend(int i) {
		StringBuilder testString = new StringBuilder(4000);
		int total = 0;
		while (total < 1000000000) {
			if (total == 0) {
				// first time
				testString.append("[?,?]");
				total = (i * 2);
			}
			testString.insert(0, "[?,");
			testString.append("]");
			total += total;
		}
		return testString.toString();
	}

	@Test
	public void testIsDisributable() {
		String result = PropertyGuru.isDistributable(4, "???");
		assertTrue(result.equals("8"));
		result = PropertyGuru.isDistributable(4, "?");
		assertTrue(result.equals("8"));

		result = PropertyGuru.isDistributable(3, "?");
		assertTrue(result.equals("6"));

		result = PropertyGuru.isDistributable(3, "??");
		assertTrue(result.equals("NO"));

		result = PropertyGuru.isDistributable(16, "????");
		assertTrue(result.equals("32"));

		result = PropertyGuru.isDistributable("16", "?????");
		assertTrue(result.equals("32"));

		result = PropertyGuru.isDistributable(16, "?????");
		assertTrue(result.equals("32"));

		result = PropertyGuru.isDistributable(16, "??????");
		assertTrue(result.equals("NO"));

		result = PropertyGuru.isDistributable(16, "???????");
		assertTrue(result.equals("NO"));

	}

	@Test
	public void testNested() {
		assertTrue(PropertyGuru.processs("[[?,?],?]"));
		assertFalse(PropertyGuru.processs("[[?,?],?"));
		assertFalse(PropertyGuru.processs("[?,?],?"));

		assertTrue(PropertyGuru.processs("[[1,1],[?,?]]"));
		assertFalse(PropertyGuru.processs("[[1,1],[2,?]]"));
		assertFalse(PropertyGuru.processs("[[1,1],[?,2]]"));
		assertTrue(PropertyGuru.processs("[2,[1,1],[?,?]]"));
		String nested = creatNesting();
		
		assertTrue(isBalanced(nested));
		long startTime = System.currentTimeMillis();
		assertTrue(PropertyGuru.processs(nested));
		assertFalse(PropertyGuru
				.processs("[268435457,[134217728,[67108864,[33554432,[16777216,[8388608,[4194304,[2097152,[1048576,[524288,[262144,[131072,[65536,[32768,[16384,[8192,[4096,[2048,[1024,[512,[256,[128,[64,[32,[16,[8,[4,[2,[1,1]]]]]]]]]]]]]]]]]]]]]]]]]]]]]"));

		assertFalse(PropertyGuru
				.processs("[[[268435456,[134217728,[67108864,[33554432,[16777216,[8388608,[4194304,[2097152,[1048576,[524288,[262144,[131072,[65536,[32768,[16384,[8192,[4096,[2048,[1024,[512,[256,[128,[64,[32,[16,[8,[4,[2,[1,1]]]]]]]]]]]]]]]]]]]]]]]]]]]]]],[[268435457,[134217728,[67108864,[33554432,[16777216,[8388608,[4194304,[2097152,[1048576,[524288,[262144,[131072,[65536,[32768,[16384,[8192,[4096,[2048,[1024,[512,[256,[128,[64,[32,[16,[8,[4,[2,[1,1]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]"));
		
//		System.out.println((System.currentTimeMillis() - startTime));
	}

	/**
	 * Like to create nested balance. It must have at least one ],[ pattern.
	 * 
	 * @return the String representing balance.
	 */
	public String creatNesting() {
		StringBuilder myString = new StringBuilder("[1,1]");
		int max = MAX / 2;
		int currentWeight = 2;

		while (currentWeight < max) {
			myString.insert(0, ",");
			myString.insert(0, currentWeight);
			myString.insert(0, "[");
			myString.append("]");
			currentWeight *= 2;
		}

		return "[[" + myString.toString() + "],[" + myString.toString() + "]]";
	}
	
	/**
	 * Whether the string is balanced or not. Balanced string will have equal number of "[" and "]".
	 * @param myString
	 * @return
	 */
	public boolean isBalanced(String myString) {
		int openCount = 0;
		int closeCoung = 0;
		int len = myString.length();
		for (int i = 0; i < len; i++) {
			char c = myString.charAt(i);
			if (c=='[') {
				openCount++;
			} else if (c==']') {
				closeCoung++;
			}
		}
		return openCount == closeCoung;
	}

	@Test
	public void testString() {
		String test = "[[[268435457,[134217728,[67108864,[33554432,[16777216,[8388608,[4194304,[2097152,[1048576,[524288,[262144,[131072,[65536,[32768,[16384,[8192,[4096,[2048,[1024,[512,[256,[128,[64,[32,[16,[8,[4,[2,[1,1]]]]]]]]]]]]]]]]]]]]]]]]]]]]]],[268435456,268435456]]";
        String[] results = getParts(test);
        String firstPart = results[0];
        PropertyGuru.processEachUnit(firstPart);
        String secondPart = results[1];
        assertTrue("Expected [268435456,268435456], but found " + secondPart,  "[268435456,268435456]".equals(secondPart));
        PropertyGuru.processEachUnit(secondPart);
        
        test = "[[?,?],[?,?]]";
        String[] values = getParts(test);
        assertTrue("Expected [?,?], but found " + values[1],  "[?,?]".equals(values[1]));
        assertTrue("Expected [?,?], but found " + values[0],  "[?,?]".equals(values[0]));     
	}

	public static String[] getParts(String test) {
		String[] result = new String[2];
		
		int partitionIndex = test.lastIndexOf("],[");
		result[0] = test.substring(1, partitionIndex+1);
		result[1] = test.substring(partitionIndex+"],[".length() - 1,test.length() - 1);
		return result;
	}
	
	@Test
	public void testInvalidInput() {
		assertFalse("NO".equals(PropertyGuru.processMainUnit("1,1")));
		assertTrue("NO".equals(PropertyGuru.processMainUnit("[11]")));
		assertTrue("NO".equals(PropertyGuru.processMainUnit("11")));
		assertFalse(PropertyGuru.processs("11"));
		assertFalse(PropertyGuru.processs("[11]"));
		
	}

}
