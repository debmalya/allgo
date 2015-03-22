import java.util.Stack;

public class MathUtil {

	public MathUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long getSmallestMultiple(long term) {
		long result = 1;
		for (int i = 2; i <= term; i++) {
			result = lcd(result, i);
		}
		return result;
	}

	public static long lcd(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static long gcd(long a, long b) {
		long max = Math.max(a, b);
		if (a == 0 || b == 0 || a == b) {
			return max;
		} else {
			long min = Math.min(a, b);
			if (max % min == 0) {
				return min;
			}

			return gcd(max, max % min);
		}
	}

	public int getNumberOfFipsRequired(int number1, int number2) {
		String value = Integer.toBinaryString(number1 ^ number2);
		int count = 0;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	/**
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 * 
	 * @param numLength - digits in the multiplier (2,3,....)
	 * @return highest palindrome
	 */
	public long getHighestPalindrome(int numLength) {
		long result = 1L;
		long number = 0L;
		int count = 0;
		int lowerLimit = 0;

		while (count < numLength) {
			number *= 10;
			number += 9;
			count++;
			
			
		}
		lowerLimit = (int)(number / 10) + 1;
//		System.out.println(" number " + number+" lowerLimit " + lowerLimit);
		long multiplier = number;
		while (true) {
			result = multiplier * number;
			if (isPalindrom(String.valueOf(result))) {
				System.out.println(number+ " X " + multiplier);
				break;
			}
			
			number--;
			if (number < lowerLimit) {
				number = --multiplier;	
				System.out.println(number+ " Y " + multiplier);
			}
			
		}

		return result;
	}

	/**
	 * To check whether the string is palindromic or not.
	 * 
	 * @param str
	 *            to be checked.
	 * @return true if palindrom, false otherwise.
	 */
	public boolean isPalindrom(String str) {
		int len = str.length();
		for (int i = 0; i < len / 2; i++)
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		return true;
	}

	/**
	 * Convert to a binary string.
	 * 
	 * @param num
	 * @return
	 */
	public String toBinaryString(long num) {
		Stack<Long> values = new Stack<Long>();

		while (num > 1) {
			values.add(num % 2);
			num /= 2;
		}
		values.add(num);

		StringBuilder returnValue = new StringBuilder();
		while (!values.isEmpty()) {
			returnValue.append(values.pop());
		}
		return returnValue.toString();
	}
}
