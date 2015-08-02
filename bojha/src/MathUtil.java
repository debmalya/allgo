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
				// System.out.println(number + " X " + multiplier);
				break;
			}

			number--;
			if (number < lowerLimit) {
				number = --multiplier;
				// System.out.println(number + " Y " + multiplier);
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
	 * 
	 * @param arr
	 *            integer array
	 * @return prefix and suffix sum if int arr is 1 2 3 4 it will return first
	 *         element as prefix 1 1+2 1+2+3 1+2+3+4 1 3 6 10
	 * 
	 *         second element as suffix sum 1+2+3+4 2+3+4 3+4 4 10 9 7 4
	 */
	public static int[][] getSum(int[] arr) {
		int[][] sum = null;
		if (arr != null) {
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
	 * 
	 * @param value
	 *            string containing numbers each number is separated by space.
	 * @return prefix and suffix sum if int arr is 1 2 3 4 it will return first
	 *         element as prefix 1 1+2 1+2+3 1+2+3+4 1 3 6 10
	 * 
	 *         second element as suffix sum 1+2+3+4 2+3+4 3+4 4 10 9 7 4
	 */
	public static int[][] getSum(String value) {
		int[][] sum = null;
		String[] arr = value.split(" ");
		if (arr != null) {
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
	 * @param arr
	 *            integer array
	 * @return index where sum of earlier indexes are equal to sum of later
	 *         indexes.
	 * 
	 *         e.g. for the input 2 3 1 6 at index 2, sum of earlier indexes
	 *         2+3+1 = 6 here we have to return 2.
	 * 
	 *         If there is no such index return 0.
	 * 
	 */
	public static int getMatchingSum(int[] arr) {

		int[][] sum = getSum(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			if (sum[0][i] == sum[1][i + 1]) {
				return i;
			} else {
				for (int j = 0; j < i; j++) {
					if ((sum[0][i] - sum[0][j]) == sum[1][i + 1]) {
						return i;
					}
				}
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param arr
	 *            String containing integer, each integer is separated by space.
	 * @return index where sum of earlier indexes are equal to sum of later
	 *         indexes.
	 * 
	 *         e.g. for the input 2 3 1 6 at index 2, sum of earlier indexes
	 *         2+3+1 = 6 here we have to return 2.
	 * 
	 *         If there is no such index return 0.
	 * 
	 */
	public static int getMatchingSum(String arr) {

		int[][] sum = getSum(arr);

		for (int i = 0; i < sum[0].length - 1; i++) {
			if (sum[0][i] == sum[1][i + 1]) {
				return i;
			} else {
				for (int j = 0; j < i; j++) {
					if ((sum[0][i] - sum[0][j]) == sum[1][i + 1]) {
						return i;
					}
				}
			}
		}
		return 0;
	}

	/**
	 * Get the maximum digit from a number.
	 * 
	 * @param n
	 *            number whose max digit will be identified
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
	 * 
	 * @param n
	 *            number whose minimum digit will be identified
	 * @return maximum digit
	 */
	public static int minDigit(int n) {

		int result = Math.abs(n % 10);
		while (n != 0) {
			result = Math.min(result, Math.abs(n % 10));
			n /= 10;
		}

		return result;
	}

	/**
	 * Find out if binomial coefficient C(n,k) is divisible by the given
	 * positive integer number d.
	 * 
	 * @param n
	 *            1<=n<=1000
	 * @param k
	 *            1<=k<=n
	 * @param d
	 *            2<=d<=1000000
	 * @return 1 if C(n,k) is divisible by d, 0 otherwise
	 */
	public static int conbinatoricFactor1(int n, int k, int d) {
		long value = 1;
		for (int i = n; i > n - k; i--) {
			value *= i;
		}
		for (int i = k; i > 1; i--) {
			value /= i;
		}
		return value % d == 0 ? 1 : 0;
	}

	/**
	 * Find out if binomial coefficient C(n,k) is divisible by the given
	 * positive integer number d.
	 * 
	 * @param n
	 *            1<=n<=1000
	 * @param k
	 *            1<=k<=n
	 * @param d
	 *            2<=d<=1000000
	 * @return 1 if C(n,k) is divisible by d, 0 otherwise
	 */
	public static int conbinatoricFactor2(int n, int k, int d) {

		long value = 1;
		int hr = n - k > k ? n - k : k;
		int lr = n - k > k ? k : n - k;
		for (int i = n; i > hr; i--, lr--) {
			value *= i;
			if (lr > 1) {
				value /= lr;
			}
		}
		return value % d == 0 ? 1 : 0;
	}

	public static long getBinaryCoefficient(int n, int k) {
		long value = 1;
		int hr = n - k > k ? n - k : k;
		int lr = n - k > k ? k : n - k;
		for (int i = n; i > hr; i--, lr--) {
			value *= i;
			if (lr > 1) {
				value /= lr;
			}
		}

		return value;
	}

	public static long getBinaryCoefficient0(int n, int k) {
		long value = 1;
		for (int i = n; i > n - k; i--) {
			value *= i;
		}
		for (int i = k; i > 1; i--) {
			value /= i;
		}
		return value;
	}

	/**
	 * Arrange input. Inputs less than index will be on left side, index greater
	 * than index will be on right side.
	 * 
	 * @param input
	 *            an array of integer.
	 * @param index
	 *            integer.
	 * @return arranged array
	 */
	public static int[] process(int[] input, int index) {
		int swap_right = -1;
		int swap_left = -1;
		int left = 0;
		int right = input.length - 1;
		int mid = (left + right) / 2;
		while (left < right) {
			if (input[right] < index) {
				// it should go to left side
				swap_right = right;

			}
			if (input[left] > index) {
				// it should go to right side
				swap_left = left;
			}

			if (swap_right > -1 && swap_left > -1) {
				int temp = input[swap_right];
				input[swap_right] = input[swap_left];
				input[swap_left] = temp;
				swap_right = -1;
				swap_left = -1;
			}
			left++;
			right--;
		}
		return input;
	}

	/**
	 * The equilibrium index of a sequence is an index such that the sum of
	 * elements at lower indexes is equal to the sum of elements at higher
	 * indexes. For example, in a sequence A: A[0]=-7 A[1]=1 A[2]=5 A[3]=2
	 * A[4]=-4 A[5]=3 A[6]=0 3 is an equilibrium index, because:
	 * A[0]+A[1]+A[2]=A[4]+A[5]+A[6] 6 is also an equilibrium index, because:
	 * A[0]+A[1]+A[2]+A[3]+A[4]+A[5]=0 (The sum of zero elements is zero) 7 is
	 * not an equilibrium index - because it is not a valid index of sequence A.
	 * If you still have doubts, here is a precise definition: The integer k is
	 * an equilibrium index of a sequence A[0],A[1]..,A[n-1] if and only if 0<=
	 * k and sum(A[0..(k-1)])=sum(A[(k+1)..(n-1)]). Assume the sum of zero
	 * elements is equal to zero.
	 * 
	 * @param A
	 *            array of integers.
	 * @param numberOfShelves
	 * @return
	 */
	public static int equi(int[] arr) {
		int n = arr.length;
		if (n == 0)
			return -1;
		long sum = 0;
		int i;
		for (i = 0; i < n; i++)
			sum += arr[i];

		long sum_left = 0;
		for (i = 0; i < n; i++) {
			long sum_right = sum - sum_left - (long) arr[i];
			if (sum_left == sum_right)
				return i;
			sum_left += (long) arr[i];
		}
		return -1;

	}

	/**
	 * For a given set of non-negative integers find the smallest non-negative
	 * integer not contained in that set.
	 * 
	 * In game theory this is known as the mex (minimum excludant) function and
	 * it plays an important role.
	 * 
	 * Input (a) → array.integer :
	 * 
	 * An array of N positive integers which represents a set. Some elements may
	 * be repeating. 0 ≤ N ≤ 100, all elements are less than 100. Output →
	 * integer Input [[0,2,4,4,2,1,10]] Output 3
	 * 
	 * @param a
	 *            integer array.
	 * @return smallest non-negative integer not contained in that set.
	 */
	public static int mex(int[] a) {
		int r = 0;
		while (true) {
			int f = 0, i = 0;
			while (i < a.length) {
				if (a[i++] == r) {
					f++;
					continue;
				}
			}
			if (f < 1) {
				return r;
			}
			r++;
		}

	}

	/**
	 * https://class.coursera.org/algo-004/lecture/167
	 */
	public int karatSubMultiplication(int a, int b) {
		return 0;
	}

	/**
	 * A DOTA game has N heroes, each with a distinct rank from [1..N]. In DOTA
	 * every formation is characterized as a permutation [1...N] of ranks of
	 * players. A formation is Imba when the sum of ranks of every two
	 * consecutive players is less than or equal to (N+1). Given N, you are to
	 * print the lexicographically smallest permutation of ranks [1...N] that
	 * makes the formation Imba.
	 * 
	 * @param n
	 *            number of heroes (2 <= n < 10000)
	 * @return lexicographically smallest permutation of ranks [1...N] that
	 *         makes the formation Imba.
	 */
	public static String imba(final int n) {
		StringBuilder imba = new StringBuilder("");

		int i = 1;
		int m = n;
		while (i <= m) {
			imba.append(m--);

			if (i < m) {
				imba.append(" ");
				imba.append(i++);

			}
			imba.append(" ");

		}

		return imba.reverse().toString().trim();
	}
}
