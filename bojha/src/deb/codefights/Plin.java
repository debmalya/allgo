/**
 * 
 */
package deb.codefights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author debmalyajash
 *
 */
public class Plin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Math.floor(0.9));
		System.out.println(Math.floor(0.4));

	}

	/**
	 * Caesar Box is a simple transposition cipher used in the Roman Empire, in
	 * which characters of the given message are broken into multiple lines that
	 * form a square when stacked up and then read the square column by column.
	 * 
	 * Given a message, encode it.
	 * 
	 * Example
	 * 
	 * For inputString = "a message", the square will look as follows:
	 * 
	 * a m ess age Thus, the encoded message will be aea sgmse.
	 * 
	 * [input] string inputString
	 * 
	 * A string of length n2 for some integer n. [output] string
	 * 
	 * @param inputString
	 * @return
	 */
	public String caesarBoxCipherEncoding(String inputString) {

		int n = (int) Math.sqrt(inputString.length());
		String ans = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += inputString.charAt(j * n + i);
			}
		}

		return ans;
	}

	/**
	 * In geometry, the minimum bounding box for a set of points is the box with
	 * the smallest measure (area for the 2-dimensional case) within which all
	 * the points lie. The axis-aligned minimum bounding box for a set of points
	 * is its minimum bounding box with edges that are parallel to the
	 * (Cartesian) coordinate axes. Given a set of circles find the area of the
	 * axis-aligned minimum bounding box of the set of points which belong to at
	 * least one of the given circles.
	 * 
	 * Example
	 * 
	 * axisAlignedCirclesBoundingBox([1, 0, 4], [-1, 2, 2], [3, 5, 4]) = 143
	 * 
	 * [input] array.integer x
	 * 
	 * non-empty array of integers representing X coordinates of the centers of
	 * the circles on the plane [input] array.integer y
	 * 
	 * array of integers of the same length as x representing Y coordinates of
	 * the circle centers [input] array.integer r
	 * 
	 * array of positive integers of the same length as x representing circle
	 * radii. i-th elements of x, y and r correspond to a single circle.
	 * [output] integer
	 * 
	 * area of axis-aligned minimum bounding box for the above-mentioned set of
	 * points
	 * 
	 * @param x
	 * @param y
	 * @param r
	 * @return
	 */
	public int axisAlignedCirclesBoundingBox(int[] x, int[] y, int[] r) {

		int minX = x[0] - r[0], maxX = x[0] + r[0], minY = y[0] - r[0], maxY = y[0]
				+ r[0];

		for (int i = 1; i < x.length; i++) {
			minX = Math.min(x[i] - r[i], minX);
			maxX = Math.max(x[i] + r[i], maxX);
			minY = Math.min(y[i] - r[i], minY);
			maxY = Math.max(y[i] + r[i], maxY);
		}
		return (maxX - minX) * (maxY - minY);

	}

	double distance(double[] departure, double[] destination) {

		return 0.00d;
	}

	static boolean crossroads(int[] road1, int[] road2, int crossTime) {
		int[] n = new int[road1.length + road2.length];

		int c = 0;
		for (int i = 0; i < road1.length; i++) {
			n[c++] = road1[i];
		}

		for (int i = 0; i < road2.length; i++) {
			n[c++] = road2[i];
		}

		Arrays.sort(n);

		for (int i = 0; i < n.length; i++) {
			if (i > 0 && n[i] - n[i - 1] <= crossTime) {
				return true;
			}

		}
		return false;

	}

	/**
	 * In linear algebra, the trace of a square matrix A is defined as the sum
	 * of the elements on the main diagonal (the diagonal from the upper left to
	 * the lower right).
	 * 
	 * Example
	 * 
	 * matrixTrace([[1, 1, 1], [0, 5, 0], [2, 1, 3]]) = 9 [input]
	 * array.array.integer matrix
	 * 
	 * 2-dimensional array of integers representing a square matrix [output]
	 * integer
	 * 
	 * the trace of matrix
	 * 
	 * @param matrix
	 * @return
	 */
	int matrixTrace(int[][] matrix) {

		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[i][i];
		}
		return result;
	}

	/**
	 * You are given 2 sorted arrays of integers A and B. You are allowed to
	 * select at most k elements in total from both arrays in order to maximize
	 * the following expression: (Sum of selected elements of A) * (Sum of
	 * selected elements of B).
	 * 
	 * If no elements are chosen from an array, the sum is considered to be 0.
	 * 
	 * Example
	 * 
	 * maxSumProduct( [-10, 10, 20, 90], [-1, 2, 3, 4, 5], 5) = (20 + 90) * (3 +
	 * 4 + 5) = 1320 [input] array.integer a
	 * 
	 * An array sorted in ascending order. [input] array.integer b
	 * 
	 * An array sorted in ascending order [input] integer k
	 * 
	 * 
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	int maxSumProduct(int[] a, int[] b, int k) {

		int best = 0;
		int leftSumA = 0;
		int rightSumA = 0;
		for (int i = 1; i <= Math.min(a.length, k); i++) {
			leftSumA += a[i - 1];
			rightSumA += a[a.length - i];

			int leftSumB = 0;
			int rightSumB = 0;
			for (int j = 1; j <= Math.min(b.length, k - i); j++) {
				leftSumB += b[j - 1];
				rightSumB += b[b.length - j];

				best = Math.max(best,
						Math.max(leftSumA * leftSumB, rightSumA * rightSumB));
			}
		}

		return best;
	}

	/**
	 * Given some integer, find the maximal number you can obtain by deleting
	 * exactly one digit of the given number.
	 * 
	 * Example
	 * 
	 * for 152 output should be 52 for 1001 output should be 101 [input] integer
	 * n
	 * 
	 * integer number not less than 10 [output] integer
	 * 
	 * @param n
	 * @return
	 */
	int deleteDigit(int n) {
		int answer = 0;
		ArrayList<Integer> digits = new ArrayList<>();
		while (n != 0) {
			digits.add(n % 10);
			n /= 10;
		}
		int number = 0;
		for (int deletedIndex = 0; deletedIndex < digits.size(); deletedIndex++) {
			number = 0;
			for (int i = digits.size() - 1; i >= 0; i--) {
				if (i != deletedIndex) {
					number += digits.get(i) * 10;
				}
			}
			answer = Math.max(number, answer);
		}
		return answer;
	}

	/**
	 * Find the smallest integer not less than the given limit which is
	 * divisible by all integers from the given array.
	 * 
	 * Example
	 * 
	 * firstMultiple([2, 3, 4], 13) = 24
	 * 
	 * [input] array.integer divisors
	 * 
	 * Array of positive integers. [input] integer start
	 * 
	 * Positive integer. [output] integer
	 * 
	 * The smallest integer not less than start which is divisible by all
	 * integers from divisors.
	 * 
	 * @param divisors
	 * @param start
	 * @return
	 */
	int firstMultiple(int[] divisors, int start) {

		for (int answer = start;; answer++) {
			boolean correct = true;
			for (int i = 0; i < divisors.length; i++) {
				if (answer % divisors[i] != 0) {
					correct = false;
					break;
				}
			}
			if (correct) {
				return answer;
			}
		}
	}

	/**
	 * You have a set of labels that you will be using to number N boxes however
	 * you know that one of the labels is missing. Find it.
	 * 
	 * Example
	 * 
	 * missingNumber([3, 1]) = 2
	 * 
	 * [input] array.integer arr
	 * 
	 * an unsorted array consisting of different integers from 1 to N inclusive
	 * with only one of them missing [output] integer
	 * 
	 * the missing number
	 * 
	 * @param arr
	 * @return
	 */
	int missingNumber(int[] arr) {
		int n = arr.length + 1, sum = 0, expectedSum = n * (n + 1) / 2;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return expectedSum - sum;
	}

	/**
	 * Given an integer, rearrange its digits in such a way that the resulting
	 * value will have the maximal possible number of divisors. If there are
	 * several possible solutions, return the largest one.
	 * 
	 * Example
	 * 
	 * For n = 21, the output should be 12 (12 has 6 divisors, while 21 has only
	 * 4 divisors). For n = 111, the output should be 111. [input] integer n
	 * 
	 * A positive integer. [output] integer
	 * 
	 * Note: if n contains zeroes, some of the possible rearrangements will
	 * include values with leading zeroes. In the context of this task, such
	 * values are admissible and should be returned without the leading zeroes.
	 * 
	 * @param n
	 * @return
	 */
	int maxNumberOfDivisorsPermutation(int n) {

		// A correct method to swap values in an array.
		class Helper {
			void swap(char[] a, int i, int j) {
				char t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		Helper h = new Helper();

		char[] digits = String.valueOf(n).toCharArray();
		Arrays.sort(digits);
		int bestDivCnt = 1, bestNumber = n;
		while (true) {
			// Checking the number of divisors.
			int cur = Integer.parseInt(new String(digits));
			int divisors = 0;
			for (int i = 1; i <= cur; i++) {
				if (cur % i == 0) {
					divisors++;
				}
			}
			if (divisors >= bestDivCnt) {
				bestDivCnt = divisors;
				bestNumber = cur;
			}

			// Obtaining the next permutation.
			int first;
			for (first = digits.length - 2; first >= 0; first--) {
				if (digits[first] < digits[first + 1]) {
					break;
				}
			}
			if (first == -1) {
				break;
			}
			int second = first + 1;
			while (second + 1 < digits.length
					&& digits[first] < digits[second + 1]) {
				second++;
			}
			h.swap(digits, first, second);
			first++;
			second = digits.length - 1;
			while (first < second) {
				h.swap(digits, first, second);
				first++;
				second--;
			}
		}

		return bestNumber;
	}

	/**
	 * Define a word as a sequence of consecutive letters. Find the longest word
	 * from the given string.
	 * 
	 * Example
	 * 
	 * longestWord("Ready, steady, go!") = "steady"
	 * 
	 * [input] string text
	 * 
	 * [output] string
	 * 
	 * The longest word from text. It's guaranteed that there is a unique output
	 * 
	 * @param text
	 * @return
	 */
	String longestWord(String text) {

		char[] chars = text.toCharArray();
		String answer = "";
		StringBuilder current = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			if ('a' <= chars[i] && chars[i] <= 'z' || 'A' <= chars[i]
					&& chars[i] <= 'Z') {
				current.append(chars[i]);
				if (current.length() > answer.length()) {
					answer = current.toString();
				}
			} else {
				current = new StringBuilder();
			}
		}

		return answer;
	}

	/**
	 * Given an array of distinct integers, find its k-th greatest element.
	 * 
	 * Example
	 * 
	 * For array = [19, 32, 11, 23] and k = 3, the output should be 19.
	 * 
	 * [input] array.integer inputArray
	 * 
	 * An array of distinct integers. [input] integer k
	 * 
	 * A positive integer not exceeding array length. [output] integer
	 * 
	 * k-th greatest element of array.
	 * 
	 * @param inputArray
	 * @param k
	 * @return
	 */
	static int arrayKthGreatestQuick(int[] inputArray, int k) {

		class Helper {
			int[] listToArray(List<Integer> data) {
				int[] res = new int[data.size()];
				for (int i = 0; i < data.size(); i++) {
					res[i] = data.get(i);
				}
				return res;
			}
		}
		;

		int pos = (new Random()).nextInt(inputArray.length);
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		if (inputArray.length == 1) {
			return inputArray[0];
		}

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] <= inputArray[pos]) {
				left.add(inputArray[i]);
			} else {
				right.add(inputArray[i]);
			}
		}

		Helper h = new Helper();

		if (right.size() >= k) {
			return right.get(k - 1);
		}
		return arrayKthGreatestQuick(h.listToArray(left), k - right.size());
	}
	
	/**
	 * Given array of integers, find the maximal possible sum of some of its k
	 * consecutive elements.
	 * 
	 * Example
	 * 
	 * for array = [2, 3, 5, 1, 6], k = 2 output should be 8
	 * 
	 * [input] array.integer inputArray
	 * 
	 * array of positive integers [input] integer k
	 * 
	 * an integer (not greater than the length of inputArray) [output] integer
	 * 
	 * the maximal possible sum
	 * 
	 * @param inputArray
	 * @param k
	 * @return
	 */
	int arrayMaxConsecutiveSum(int[] inputArray, int k) {

		int result = 0, currentSum = 0;

		for (int i = 0; i < k - 1; i++) {
			currentSum += inputArray[i];
		}
		for (int i = k - 1; i < inputArray.length; i++) {
			currentSum += inputArray[i];
			if (currentSum > result) {
				result = currentSum;
			}
			currentSum -= inputArray[i - k + 1];
		}

		return result;
	}

	/**
	 * A spider is standing at the origin (0, 0) of a Cartesian plane and wants
	 * to move to the point (X,Y). At each step, the spider can only move one
	 * square in two of the four directions: U(up), D(down,), L(left), R(right),
	 * depending on where it is heading:
	 * 
	 * if X ≥ 0, Y ≥ 0. The spider can only go U or R. if X ≥ 0, Y ≤ 0. The
	 * spider can only go D or R. if X ≤ 0, Y ≥ 0. The spider can only go U or
	 * L. if X ≤ 0, Y ≤ 0. The spider can only go D or L. Find the number of
	 * ways for the spider to get to the given point (X, Y).
	 * 
	 * Example
	 * 
	 * With (X, Y) = (2, -2), there are only 6 ways:
	 * 
	 * RRDD RDRD RDDR DRRD DRDR DDRR With (X,Y) = (-3, 0), there is only one
	 * way:
	 * 
	 * LLL For (0, 0), the answer is defined to be 1.
	 * 
	 * [input] integer X
	 * 
	 * [input] integer Y
	 * 
	 * [output] integer
	 * 
	 * 
	 * @param X
	 * @param Y
	 * @return
	 */
	int spiderMove(int X, int Y) {

		X = Math.abs(X);
		Y = Math.abs(Y);

		int[] n = new int[X + 1];
		for (int i = 0; i < X + 1; i++) {
			n[i] = 1;
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 1; j < X + 1; j++) {
				n[j] = n[j - 1] + n[j];
			}
		}
		return n[X];
	}


}
