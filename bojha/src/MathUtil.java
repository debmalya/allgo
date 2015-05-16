import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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
	 * @param numLength
	 *            - digits in the multiplier (2,3,....)
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
		lowerLimit = (int) (number / 10) + 1;
		// System.out.println(" number " + number+" lowerLimit " + lowerLimit);
		long multiplier = number;
		while (true) {
			result = multiplier * number;
			if (isPalindrom(String.valueOf(result))) {
				System.out.println(number + " X " + multiplier);
				break;
			}

			number--;
			if (number < lowerLimit) {
				number = --multiplier;
				System.out.println(number + " Y " + multiplier);
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

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	 * see that the 6th prime is 13.
	 * 
	 * What is the 10 001st prime number?
	 * 
	 * @param primeCount
	 */
	public long getPrime(int primeCount) {
		long prime = 2L;
		return prime;
	}

	/**
	 * 
	 * @param value
	 *            string containing numbers separated by a space
	 * @return index where prefix sum is equal to suffix sum. "2 3 1 6" for this
	 *         it should return 2- (2+3+1) == 6
	 * 
	 */
	public static int getIndex0(String value) {
		String[] values = value.split(" ");
		int[] intValues = new int[values.length];
		int[] prefixSum = new int[values.length];
		int[] suffixSum = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			intValues[i] = Integer.parseInt(values[i]);
			prefixSum[i] += intValues[i];
			if (i < values.length - 1) {
				prefixSum[i + 1] = prefixSum[i];
			}
		}

		int min = values.length;
		for (int i = values.length - 1; i > -1; i--) {

			suffixSum[i] += intValues[i];

			if (i > 0) {
				if (suffixSum[i] == prefixSum[i - 1]) {
					return i - 1;
				} else if (prefixSum[0] == prefixSum[1]) {
					return 0;
				} else {
					for (int j = 0; j < i - 1; j++) {
						if (prefixSum[i - 1] - prefixSum[j] == suffixSum[i]) {
							min = Math.min(min, (i - 1));
						}
					}
				}
				suffixSum[i - 1] += suffixSum[i];
			}
		}

		if (min != values.length) {
			return min;
		}

		return 0;
	}

	/**
	 * Returns number of inversions in the number.
	 * 
	 * Example 123 - it has no inversion. 132 - here 3 > 2 it has one inversion.
	 * if a(i) > a(j) and i < j.
	 * 
	 * @param num
	 * @return total number of inversion in the number.
	 */
	public static int getNumberOfInversions(int num) {
		int mod = num % 10;
		int divisor = num / 10;
		int inversionCount = 0;
		List<Integer> digitList = new ArrayList<Integer>();
		digitList.add(mod);
		while (divisor > 0) {
			mod = divisor % 10;
			divisor /= 10;

			digitList.add(mod);

		}

		for (int i = 0; i < digitList.size() - 1; i++) {
			for (int j = i + 1; j < digitList.size(); j++) {
				if (digitList.get(i) < digitList.get(j)) {
					inversionCount++;
				}
			}
		}
		return inversionCount;
	}
	
	/**
	 * Returns prefix sum and suffix sum.
	 * @param arr integer array
	 * @return prefix and suffix sum
	 * if int arr is 1 2 3 4
	 * it will return first element as prefix
	 * 1 1+2 1+2+3 1+2+3+4
	 * 1 3 6 10
	 * 
	 * second element as suffix sum
	 * 1+2+3+4 2+3+4 3+4 4
	 * 10 9 7 4
	 */
	public static int[][] getSum(int[] arr){
		int[][] sum = null;
		if (arr != null ) {
			int maxLen = arr.length - 1;
			
			sum = new int[2][];
			sum[0] = new int[arr.length];
			sum[1] = new int[arr.length];
			
			for (int i = 0; i < arr.length; i++) {
				sum[0][i] += arr[i];
				sum[1][maxLen - i] += arr[maxLen - i];
				if (i < maxLen) {
					sum[0][i + 1] += sum[0][i]; 
					sum[1][maxLen - i - 1] += sum[1][maxLen - i];
				}
			}
		}
		return sum;
		
	}
	
	/**
	 * Returns prefix sum and suffix sum.
	 * @param value string containing numbers each number is separated by space.
	 * @return prefix and suffix sum
	 * if int arr is 1 2 3 4
	 * it will return first element as prefix
	 * 1 1+2 1+2+3 1+2+3+4
	 * 1 3 6 10
	 * 
	 * second element as suffix sum
	 * 1+2+3+4 2+3+4 3+4 4
	 * 10 9 7 4
	 */
	public static int[][] getSum(String value){
		int[][] sum = null;
		String[] arr = value.split(" ");
		if (arr != null ) {
			int maxLen = arr.length - 1;
			
			sum = new int[2][];
			sum[0] = new int[arr.length];
			sum[1] = new int[arr.length];
			
			for (int i = 0; i < arr.length; i++) {
				sum[0][i] += Integer.parseInt(arr[i]);
				sum[1][maxLen - i] += Integer.parseInt(arr[maxLen - i]);
				if (i < maxLen) {
					sum[0][i + 1] += sum[0][i]; 
					sum[1][maxLen - i - 1] += sum[1][maxLen - i];
				}
			}
		}
		return sum;
		
	}
	/**
	 * 
	 * @param arr integer array
	 * @return index where sum of earlier indexes are equal to sum of later indexes.
	 * 
	 * e.g. for the input 2 3 1 6
	 * at index 2, sum of earlier indexes 2+3+1 = 6
	 * here we have to return 2.
	 * 
	 * If there is no such index return 0.
	 * 
	 */
	public static int getMatchingSum(int[] arr) {
		
		int[][] sum = getSum(arr);
		
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (sum[0][i] == sum[1][i + 1]) {
				return i;
			} else {
				for (int j = 0; j < i; j++) {
					if ((sum[0][i] - sum[0][j])== sum[1][i + 1]) {
						return i;
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param arr String containing integer, each integer is separated by space.
	 * @return index where sum of earlier indexes are equal to sum of later indexes.
	 * 
	 * e.g. for the input 2 3 1 6
	 * at index 2, sum of earlier indexes 2+3+1 = 6
	 * here we have to return 2.
	 * 
	 * If there is no such index return 0.
	 * 
	 */
	public static int getMatchingSum(String arr) {
		
		int[][] sum = getSum(arr);
		
		
		for (int i = 0; i < sum[0].length - 1; i++) {
			if (sum[0][i] == sum[1][i + 1]) {
				return i;
			} else {
				for (int j = 0; j < i; j++) {
					if ((sum[0][i] - sum[0][j])== sum[1][i + 1]) {
						return i;
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * Get the maximum digit from a number.
	 * @param n number whose max digit will be identified
	 * @return maximum digit
	 */
	public static int maxDigit(int n) {

		  int result = 0;
		  while (n != 0) {
		    result = Math.max(result, Math.abs(n % 10));
		    n /= 10;
		  }

		  return result;
		}
	
	/**
	 * Get the minimum digit from a number.
	 * @param n number whose minimum digit will be identified
	 * @return maximum digit
	 */
	public static int minDigit(int n) {

		  int result = Math.abs( n % 10);
		  while (n != 0) {
		    result = Math.min(result, Math.abs(n % 10));
		    n /= 10;
		  }

		  return result;
		}
}
