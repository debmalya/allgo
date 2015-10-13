import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class CodeFights {
	/*
	 * Suppose there are n people standing in a circle and they are numbered 1
	 * through n in order. Person 1 starts off with a sword and kills person 2.
	 * He then passes the sword to the next person still standing, in this case
	 * person 3. Person 3 then uses the sword to kill person 4, and passes it to
	 * person 5. This pattern continues around and around the circle until just
	 * one person remains.
	 * 
	 * 
	 * What is the number of this person?
	 * 
	 * 
	 * Example: n = 5
	 * 
	 * 
	 * 1 kills 2, passes to 3. 3 kills 4, passes to 5. 5 kills 1, passes to 3. 3
	 * kills 5 and wins.
	 * 
	 * Input (n) → integer : number of people 1 through n standing in a circle
	 * 
	 * Output → integer : index of the last person standing
	 */
	public int circleSlash(int n) {
		return 0;
	}

	/**
	 * Find the similarity of given sorted arrays A and B, which is defined as
	 * follows: you take the number of elements which are present in both arrays
	 * and divide it by the number of elements which are present in at least one
	 * array.
	 * 
	 * 
	 * It also can be written as a formula sim(A, B) = #(A ∩ B) / #(A ∪ B),
	 * where #(C) is the number of elements in C, ∩ is intersection of arrays, ∪
	 * is union of arrays.
	 * 
	 * 
	 * This is known as Jaccard similarity.
	 * 
	 * 
	 * The answer is guaranteed to fit any floating-point type without rounding.
	 * 
	 * 
	 * Example
	 * 
	 * 
	 * For A = [1, 2, 4, 6, 7] and B = [2, 3, 4, 7]:
	 * 
	 * 
	 * 
	 * elements [2, 4, 7] are present in both arrays;
	 * 
	 * elements [1, 2, 3, 4, 6, 7] are present in at least one of the arrays. So
	 * the similarity equals to 3 / 6 = 0.5.
	 * 
	 * 
	 * 
	 * Input (A) → array.integer : A sorted array of positive integers, all
	 * elements are different and are less than 100, 1 ≤ length ≤ 100
	 * 
	 * Input (B) → array.integer : An array in the same format as A
	 * 
	 * Output → float : similarity of the arrays
	 * 
	 * 
	 * 
	 * 1 double sim(int[] A, int[] B) { 2 ​ 3 } 4 ​ Click run to test your code
	 * 
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	double sim(int[] A, int[] B) {

		int t = A.length;
		int c = 0;
		int[] o = new int[100];

		for (int i = 0; i < t; i++) {
			o[A[i]] = 1;
		}

		for (int i = 0; i < B.length; i++) {
			if (o[B[i]] > 0) {
				c++;
			} else {
				t++;
			}
		}

		return (float) c / t;
	}

	/*
	 * Find the sum for the range 0 ... M for all powers from 0 ... N.
	 * 
	 * 
	 * Example: Input M = 2, N = 3 0^0+1^0+2^0 + 0^1+1^1+2^1 + 0^2+1^2+2^2 +
	 * 0^3+1^3+2^3 = 20 No output ever exceeds 2e9
	 * 
	 * 
	 * 
	 * @param M Input (M) → integer : M < 2e9
	 * 
	 * @param N Input (N) → integer : N < 2e9
	 * 
	 * @return Output → integer : Sum to the Nth power < 2e9
	 */
	int S2N(int M, int N) {
		int r = 0;
		return r;
	}

	/**
	 * Given a set of objects with different weights (integers from 1 to 10),
	 * find the minimum number of boxes needed to put all the objects in. A box
	 * can contain 10 [kg/lbs] max.
	 * 
	 * 
	 * Example: [6, 7, 2, 4] answer would be [6,4],[7,2] = 2 boxes
	 * 
	 * 
	 * 
	 * Input (objects) → array.integer : Objects' weights
	 * 
	 * Output → integer : Min number of boxes
	 */
	public int minBoxes(int[] objects) {

		int l = objects.length;
		// int r = l;
		int i;
		int[] c = new int[l];

		int t = 0;
		// boolean[] o = new boolean[l];
		for (i = 0; i < l; i++) {
			c[i] = 10 - objects[i];
			t += objects[i];
		}

		int b = t / 10 + t % 10 > 0 ? 1 : 0;

		return b;
	}

	/**
	 * Given a set of objects with different weights (integers from 1 to 10),
	 * find the minimum number of boxes needed to put all the objects in. A box
	 * can contain 10 [kg/lbs] max.
	 * 
	 * 
	 * Example: [6, 7, 2, 4] answer would be [6,4],[7,2] = 2 boxes
	 * 
	 * 
	 * 
	 * Input (objects) → array.integer : Objects' weights
	 * 
	 * Output → integer : Min number of boxes
	 */
	public int minBoxes0(int[] objects) {

		int l = objects.length;
		int r = l;
		int i, j;
		int[] c = new int[l];
		boolean[] o = new boolean[l];
		for (i = 0; i < l; i++) {

			c[i] = 10 - objects[i];
			for (j = 0; j < i; j++) {
				if (!o[j] && !o[i] && c[j] == objects[i]) {
					// best match
					o[j] = true;
					o[i] = true;
					r--;
				}
			}
		}

		for (i = 0; i < l; i++) {
			for (j = 0; j < i; j++) {
				if (!o[j] && !o[i] && c[j] > objects[i]) {
					// still matches
					o[j] = true;
					o[i] = true;
					r--;
				}
			}
		}
		return r;
	}

	/**
	 * Mobius function - an important function in number theory. For each given
	 * N, it only has 3 values:
	 * 
	 * 
	 * 
	 * 0 if N divisible by square of a prime. Ex: 4, 8, 9
	 * 
	 * 1 if N not divisible by any square of a prime and have even number of
	 * prime factor. Ex: 6, 10, 21
	 * 
	 * -1 otherwise. Ex: 3, 5, 7, 30 Find mobius(N)
	 * 
	 * @param N
	 *            string : N < 1e12
	 * @return integer : 0, 1, -1
	 * 
	 *         This takes time for large input, which is beyond acceptance
	 *         limit.
	 */
	int mobious(String N) {

		long l = Long.parseLong(N);
		long pc = 0;
		for (long d = 2; d <= l / 2; d++) {
			if (l % d == 0) {
				if (isPrime(d)) {
					if (l % (d * d) == 0) {
						return 0;
					}
					pc++;
				}
			}
		}
		return (int) Math.pow(-1.0, pc);
	}

	boolean isPrime(long n) {

		for (long d = 2; d * d <= n; d++) {
			if (n % d == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given an array of integers, find two non-empty non-intersecting
	 * contiguous sub-arrays in such a way that the total sum of all the
	 * elements in both sub-arrays is the maximum possible, and output that sum.
	 * 
	 * 
	 * Example 1: N = 6 A = [1, 3, 2, -5, 3, 1] Answer: 10 The 2 contiguous
	 * sub-arrays are [1, 3, 2] and [3, 1], and the answer is the sum of all
	 * elements in both sub-arrays.
	 * 
	 * 
	 * Example 2: N = 5 A = [-1, 3, 1, 5, 0] Answer: 9 We can obtain 9 in many
	 * ways, like [3] and [1, 5, 0], or [3, 1] and [5].
	 * 
	 * 
	 * 
	 * Input (N) → integer : Number of integers in the array (2 <= N <= 100).
	 * 
	 * Input (A) → array.integer : The array of N integers (-100 <= Ai <= 100).
	 * 
	 * Output → integer : The maximum sum you can get.
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	int maxSum(int N, int[] A) {
		return 0;
	}

	/**
	 * The sequence of Chando is an infinite sequence of all Chando's numbers in
	 * an ascending order.
	 * 
	 * 
	 * A number is called Chando's if it is an integer that can be represented
	 * as a sum of different positive integer powers of 5.
	 * 
	 * 
	 * The first Chando's numbers are 5, 25, 30, 125, 130, 150...
	 * 
	 * 
	 * Your task is to find the Chando's N-th number for a given N.
	 * 
	 * 
	 * 
	 * Input (N) → integer : 1 <= N <= 7000
	 * 
	 * Output → integer : N-th Chando's number
	 * 
	 * @param N
	 * @return 1 - 5 2 - 25 3 - 30 4 - 125 5 - 130 6 - 150 7 - 155 8 - 625 9 -
	 *         630 and so on.
	 */

	int nthChandosNumber(int N) {
		int r = 0, c = 1;

		while (N > 0) {
			if (N % 2 == 1) {
				r += (int) Math.pow(5, c);
			}
			N /= 2;
			c++;
		}

		return r;

	}

	int nthChandosNumber0(int N) {
		int r = 0;

		char[] cN = Integer.toBinaryString(N).toCharArray();
		int z = cN.length;
		for (int i = z; i > 0; i--) {
			if (cN[z - i] == '1') {
				r += Math.pow(5, i);
			}
		}

		return r;

	}

	/**
	 * 
	 Given an integer N, how many calculations will it take for N to be 1 if
	 * you follow the following rules:
	 * 
	 * 1) if N is even -> divide N by 2
	 * 
	 * 2) if N is odd -> add 1 to N
	 * 
	 * Input (N) → integer :
	 * 
	 * 10 <= N <= 10000 Output → integer :
	 * 
	 * Number of calculations it takes for N to be 1
	 */
	int Num_Calc(int N) {
		if (N == 1) {
			return 0;
		} else if (N % 2 == 1) {
			return 2 + Num_Calc(N / 2 + 1);
		}
		return 1 + Num_Calc(N / 2);
	}

	/**
	 * Given array of symbol frequencies. Return the array of lengths of symbols
	 * in bits after Huffman coding. It is guaranteed that there are no vertexes
	 * in the Huffman tree with equal frequencies and different distances to the
	 * root.
	 * 
	 * 
	 * Examples
	 * 
	 * input: [0.3, 0.3, 0.4] output: [2, 2, 1]
	 * 
	 * 
	 * input: [0.384615, 0.179487, 0.153846, 0.153846, 0.128205] output: [1, 3,
	 * 3, 3, 3]
	 * 
	 * https://en.wikipedia.org/wiki/Huffman_coding
	 */
	int[] huffman_lengths(double[] freq) {
		int[] r = new int[freq.length];
		return r;
	}

	/**
	 * Given N cranes where array A represents their respective maximum lifting
	 * capabilities (in terms of weight) -> what is the maximum weight of an
	 * object that these N cranes can lift together, such that none of the
	 * cranes lift more than their maximum lifting capabilities. For example:
	 * >>> Cranes(3,[10,1,5]) 3 >>> Cranes(2,[10,15]) 20
	 * 
	 * 
	 * 
	 * Input (N) → integer : Input (A) → array.integer : Output → integer :
	 */
	int Cranes(int N, int[] A) {
		Arrays.sort(A);
		return N * A[0];
	}

	/**
	 * Given a sorted array and an integer as inputs, determine if there is a
	 * pair of elements in the array that produce the given integer when
	 * multiplied.
	 * 
	 * 
	 * Examples
	 * 
	 * 
	 * isPairMult([1,2,3,6,15,25], 30) -> true, since 15*2 = 30
	 * isPairMult([2,3,6,15,25], 10) -> false
	 * 
	 * Input 1 (a) → array.integer : array of integers
	 * 
	 * Input 2 (N) → integer : desired product
	 */
	boolean isPairMult(int[] a, int N) {
		int k = a.length;
		for (int i = 0; i < k - 1; i++) {
			for (int j = i + 1; j < k; j++) {
				if (a[i] * a[j] == N) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * You are given a digital number written down on a sheet of paper. Your
	 * task is to figure out if you rotate the given sheet of paper by 180
	 * degrees would the number still look exactly the same.
	 * 
	 * 
	 * Examples
	 * 
	 * 
	 * input: "1" output: false
	 * 
	 * input: "29562" output: true
	 * 
	 * input: "77" output: false
	 * 
	 * Input 1 (number) → string : sequence of digital digits given as a string
	 * 
	 * Output → boolean :
	 */
	boolean digital_number(String number) {
		int l = number.length();

		for (int i = 0; i <= l / 2; i++) {
			char f = number.charAt(i);
			char s = number.charAt(l - i - 1);
			if (f == s && (f == '5' || f == '0' || f == '2' || f == '8')) {

			}

			else if (f == '6' && s == '9') {

			} else if (f == '9' && s == '6') {

			} else {
				return false;
			}
		}
		if (l > 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Given an array of positive integers and an integer sum, find the maximum
	 * number of elements in the given array that sum up to sum.
	 * 
	 * 
	 * max_num_of_ele(10, [10, 3, 7]) = 2 max_num_of_ele(3, [1, 1, 2, 1 ]) = 3
	 * 
	 * Input 1 (sum) → integer : A None negative integer
	 * 
	 * Input 2 (list) → array.integer : Array of Positive integers
	 * 
	 * Output → integer : Maximum number of elements that sum up to sum. Return
	 * 0 if it can't be done.
	 */
	public int max_num_of_ele(int sum, int[] list) {
		Arrays.sort(list);
		int s = 0;
		int c = 0;
		for (int i = 0; i < list.length && s < sum; i++) {
			s += list[i];
			c++;
			if (s == sum) {
				return c;
			}
		}
		return 0;
	}

	/**
	 * The Secret Number
	 * 
	 * 
	 * All numbers from 1 to N have been inserted into an array of N-1 integers
	 * in random order, except for the secret number. Assuming it is less than
	 * N, find the secret number in the given array.
	 * 
	 * 
	 * Example
	 * 
	 * 
	 * N=10, Array: [6, 8, 3, 10, 1, 9, 2, 5, 7] Missing Number: 4
	 * 
	 * N=5, Array: [5, 2, 4, 1] Missing Number: 3
	 * 
	 * Input 1 (A) → array.integer : Array with N-1 numbers (only missing the
	 * 'Secret number')
	 * 
	 * Output → integer : The missing number
	 */
	public int missingNumber(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			if (i > 0 && A[i] > A[i - 1] + 1) {
				return A[i - 1] + 1;
			}
		}
		return 0;
	}

	public int missingNumber0(int[] A) {
		int l = A.length;
		int i = 0;
		for (; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				if (A[i] > A[j]) {
					int t = A[j];
					A[j] = A[i];
					A[i] = t;
				}
			}
			if (i > 0 && A[i] > A[i - 1] + 1) {
				return A[i - 1] + 1;
			}
		}
		return 0;
	}

	/**
	 * 
	 Given an array and a number N call a pair of numbers from the array a
	 * Perfect Pair if their sum is equal to N.
	 * 
	 * Find all of the perfect pairs and return the sum of their indices. Note
	 * that any element of the array can only be counted in one Perfect Pair.
	 * Also if there are multiple correct answers, return the smallest one.
	 * 
	 * Examples
	 * 
	 * pairwise([1, 4, 2, 3, 0, 5], 7) = 11
	 * 
	 * Since the Perfect Pairs are (4, 3) and (2, 5) with indices 1 + 3 + 2 + 5
	 * = 11.
	 * 
	 * pairwise([1, 3, 2, 4], 4) = 1
	 * 
	 * Since the element at index 0 (i.e. 1) and the element at index 1 (i.e. 3)
	 * form the only Perfect Pair.
	 * 
	 * Input 1 (arr) → array.integer :
	 * 
	 * array of non-negative integers Input 2 (N) → integer :
	 * 
	 * positive integer Output → integer :
	 * 
	 * sum of indices and 0 if no Perfect Pair exists
	 */
	public int pairwise(int[] arr, int N) {
		int l = arr.length;
		int r = 0;
		int[] c = new int[l];
		for (int i = 0; i < l - 1; i++) {
			for (int j = i + 1; j < l; j++) {
				if (arr[i] + arr[j] == N && c[i] + c[j] == 0) {
					r += (i + j);
					c[i] = 1;
					c[j] = 1;
				}
			}
		}
		return r;
	}

	/**
	 * A number is called lucky if it consists only of digits 4 and 7. For
	 * example, 44, 747, 4 are lucky numbers, and 745, 423, 111 are not. Your
	 * task is to find the smallest lucky number in range [L, R] , and if there
	 * is none you should return -1.
	 * 
	 * 
	 * Example: For L = 1 and R = 2 the output should be -1. For L = 4 and R = 7
	 * the output should be 4.
	 * 
	 * 
	 * 
	 * Input 1 (L) → integer : 0 ≤ L ≤ R ≤ 10^5
	 * 
	 * Input 2 (R) → integer : Output → integer : The smallest lucky number from
	 * the given range.
	 * 
	 */
	public int LuckyNum(int L, int R) {

		while (L <= R) {

			if (String.valueOf(L).matches("[47]*"))
				return L;
			L++;

		}
		return -1;

	}

	/**
	 * Find the number of N-digit numbers whose sum of digits equals their
	 * product.
	 * 
	 * 
	 * The result should have 2 numbers: the number of N-digit numbers and the
	 * smallest among them.
	 * 
	 * 
	 * Example
	 * 
	 * 
	 * For N = 1 the output should be '10 0'. For N = 2 the output should be '1
	 * 22'.
	 * 
	 * 
	 * 
	 * @param N
	 *            Input 1 (N) → integer : Number of digits, 0 < N < 11
	 * 
	 * @return Output → string : A string that consists of two integers,
	 *         separated by one space character.
	 * 
	 * 
	 * 
	 */
	public String SumAndMultiply(int N) {
		return null;
	}

	/**
	 * Solve a Boolean satisfiability problem efficiently.
	 * 
	 * The C++ committee is holding a conference to approve the final version of
	 * C++17 standard. There are N different concepts to be discussed, which can
	 * be either included or excluded from the release version. There are M
	 * juries who vote for or against these concepts. Every jury votes about
	 * exactly 2 different concepts.
	 * 
	 * The committee will be able to release the new standard if and only if
	 * there is a certain agreement among the juries.
	 * 
	 * The agreement criteria is as follows: For every jury at least one of
	 * his/her votes should be satisfied.
	 * 
	 *
	 * 
	 * Your task is to determine whether there is a possibility of agreement
	 * among the juries. In other words, whether there is a set of concepts to
	 * implement such that the committee meets the agreement criteria.
	 * 
	 * Example
	 * 
	 * For N = 3, M = 3, votes = [[1,2],[-1,-2],[3,1]] the answer is true.
	 * Explanation: The 1st jury voted for concepts 1 and 2, the 2nd jury voted
	 * against concepts 1 and 2, the 3rd jury voted for concepts 3 and 1. The
	 * included concepts could be 1 and 3. This way the 1st jury gets his first
	 * vote satisfied but not the second one, the 2nd jury gets his second vote
	 * satisfied but not the first one. Finally, the 3rd jury gets both votes
	 * satisfied.
	 * 
	 * For N = 2, M = 4, votes = [[1,2],[-1,-2],[1,-2],[-1,2]] the answer is
	 * false. Explanation: Let's say that concept 1 is included. Then concept 2
	 * has to be excluded because of the 2nd jury AND included because of the
	 * 4th jury at the same time. Let's say that concept 1 is NOT included. Then
	 * concept 2 has to be excluded because of the 1st jury AND included because
	 * of the 3rd jury at the same time, which is a contradiction. So there is
	 * no such set of concepts that meets the agreement criteria.
	 * 
	 * [input] integer N
	 * 
	 * The number of concepts, 1 < N < 1000. [input] integer M
	 * 
	 * The umber of juries, 0 < M < 500. [input] array.array.integer votes
	 * 
	 * Votes as an array of arrays of length 2. Each element is in range
	 * [-N,..,-1,1,..,N]. [output] boolean
	 * 
	 * @param N
	 *            - Different concepts
	 * @param M
	 *            - Number of juries
	 * @param votes
	 *            - The data is given as an array of arrays of size M. Each of
	 *            its elements is an array of exactly 2 elements - jury's votes.
	 *            Each vote is a number X. If X is positive, then the jury is
	 *            voting for the Xth concept. If X is negative, then the jury is
	 *            voting against the Xth concept. Concepts are numbered from 1
	 *            to N.
	 * 
	 *            Answer to the task.
	 */
	public static boolean jury_compability(int N, int M, int[][] votes) {

		int[] c = new int[N];
		boolean[] sc = new boolean[N];

		for (int i = 0; i < M; i++) {
			int[] ejv = votes[i];
			for (int j = 0; j < ejv.length; j++) {
				int co = Math.abs(ejv[j]) - 1;
				c[co] += ejv[j];
				if (c[co] > 0) {
					sc[co] = true;
				} else {
					sc[co] = false;
				}
			}
		}

		// Check whether any of the concept selectable
		boolean s = false;
		for (int i = 0; i < sc.length; i++) {
			if (sc[i]) {
				s = true;
			}
		}
		if (!s) {
			return false;
		}
		for (int i = 0; i < votes.length; i++) {
			int[] ejv = votes[i];

			int co = Math.abs(ejv[0]) - 1;
			int co1 = Math.abs(ejv[1]) - 1;

			if ((sc[co] && ejv[0] > 0) || (!sc[co] && ejv[0] < 0)
					|| (sc[co1] && ejv[1] > 0) || (!sc[co1] && ejv[1] < 0)) {
				continue;
			} else {
				// none of the jury criteria satisfied
				return false;
			}
		}

		return true;
	}

	/**
	 * Check the balance in the 2 types parentheses sequence.
	 * 
	 * Given a string of opening and closing parentheses, check whether it’s
	 * balanced. We have 2 types of parentheses: round brackets: (,) and square
	 * brackets: [,]. Assume that the string doesn’t contain any other character
	 * than these, no spaces, words or numbers. Just to remind you, balanced
	 * parentheses require every opening parenthesis to be closed in the reverse
	 * order opened.
	 * 
	 * Example: "([])" and "()()()()[]" are balanced. "([)]","(","[]]" are not.
	 * 
	 * [input] string seq
	 * 
	 * The sequence of parentheses with length in range [0,100]. [output]
	 * boolean
	 * 
	 * The answer to the task.
	 */
	public static boolean correct_parentheses(String seq) {
		Stack<Character> b = new Stack<Character>();
		for (int i = 0; i < seq.length(); i++) {
			char c = seq.charAt(i);
			switch (c) {
			case '(':
			case '[':
				b.push(c);
				break;
			case ')':
				if (b.empty()) {
					return false;
				} else if (b.peek() == '(') {
					b.pop();
				}
				break;
			case ']':
				if (b.empty()) {
					return false;
				} else if (b.peek() == '[') {
					b.pop();
				}
				break;
			default:
				break;
			}
		}
		return b.size() == 0;
	}

	/**
	 * 
	 Find the number of days it takes a snail to reach the top.
	 * 
	 * A snail is climbing a post of height H. Every day it climbs d meters up.
	 * Then at night it sleeps, slowly slipping n meters down.
	 * 
	 * Your task is to calculate the number of days snail needs to climb onto
	 * the post.
	 * 
	 * Example:
	 * 
	 * For H = 30, d = 20, n = 10 the answer is 2. Here snail will climb 20
	 * meters during the day, then -10 at night, slipping back to 10 meters
	 * height, then by the end of the next day it will reach the top. Thus, the
	 * answer is 2.
	 * 
	 * For H = 10, d = 12, n = 5 the answer is 1. Here snail will be able to do
	 * it during the first day. Thus, the answer is 1.
	 * 
	 * For H = 0, d = 2, n = 1 the answer is 0. Here snail is already on top of
	 * the post before day 1. Thus, the answer is 0.
	 * 
	 * [input] integer H Post height 0 ≤ H ≤ 1000
	 * 
	 * [input] integer d The distance travelled up during the day 1 ≤ d ≤ 100.
	 * 
	 * [input] integer n The distance slipped down during the night 0 ≤ n < d.
	 * 
	 * [output] integer The answer to the task.
	 */
	int snail_trip(int H, int d, int n) {
		return H == 0 ? 0 : d > H ? 1 : 1 + (H - d) / (d - n)
				+ ((H - d) % (d - n) > 0 ? 1 : 0);
	}

	/**
	 * Maximize probability of winning in a betting game.
	 * 
	 * Justin, Jessica and John are playing a trivia game. After the first
	 * rounds they have accumulated scores[0], scores[1] and scores[2] points
	 * respectively. Now it's time for the final round. Firstly, each player
	 * decides how many points he/she is going to bet. The bet size can be from
	 * 0 up to the player's current score. When all bets are made, a single
	 * question for all the contestants is announced. If a player answers
	 * correctly, he/she doubles the bet amount, otherwise loses it. After the
	 * final round, the player with the most points wins.
	 * 
	 * A game example: Let the scores be 100, 100, 100. Let's assume that Justin
	 * bets 50, Jessica bets 25, and John bets 75. Let's say Jessica is correct,
	 * while Justin and John are not. New scores are 50 for Justin, 125 for
	 * Jessica and 25 for John. Thus, Jessica has won the game!
	 * 
	 * For all 3 players the probability of answering the question correctly is
	 * equal to 50%. Justin is the last one to make a bet, so he is aware of his
	 * opponents' bets (jessica_bet and john_bet). He wants you to help him make
	 * a bet that will maximize his chances to win.
	 * 
	 * Your task is to calculate the bet that maximizes Justin's chance to win
	 * (draw is the same as losing for him). If there are several such bets,
	 * choose the smallest one. Consequently, if Justin cannot win under any
	 * circumstance or will win under any circumstance, return 0.
	 * 
	 * Example:
	 * 
	 * For scores = [100,100,100], jessica_bet = 25, john_bet = 75 the answer is
	 * 76.
	 * 
	 * Let's look through the possible bets: For bet in range [0, 24] Justin
	 * wins only when his opponents are incorrect, which has 1 / 4 chance. For
	 * bet = 25 Justin wins only when he is correct and both other players are
	 * incorrect, which has 1 / 8 chance. For bet in range [26, 75] Justin wins
	 * only when he is correct and John is incorrect, which has 1 / 4 chance.
	 * For bet in range [76, 100] Justin wins when he is correct, which has
	 * exactly 1 / 2 chance. Thus, the answer is 76.
	 * 
	 * [input] array.integer scores
	 * 
	 * Scores before the final round. 3 elements array. 0 ≤ scoresi ≤ 1000.
	 * [input] integer jessica_bet
	 * 
	 * Jessica's bet 0 ≤ jessica_bet ≤ scores[1]. [input] integer john_bet
	 * 
	 * John's bet 0 ≤ john_bet ≤ scores[2]. [output] integer
	 * 
	 * Answer to the task. CODE
	 */
	int trivia_game(int[] scores, int jessica_bet, int john_bet) {
		return 0;
	}

	/**
	 * A digital root is a positive single-digit integer which is obtained by
	 * adding digits of the initial number and repeating this process while it
	 * has more than one digit.
	 * 
	 * Given a positive integer as a string, return its digital root.
	 * 
	 * Example
	 * 
	 * For n = "24" the result is 2 + 4 ==> 6. For n = "39" the result is 3 + 9
	 * ==> 12 ==> 1 + 2 ==> 3. For n = "999" the result is 9 + 9 + 9 ==> 27 ==>
	 * 2 + 7 ==> 9.
	 * 
	 * [input] string n The input number, can contain up to 100 digits, n > 0
	 * 
	 * [output] integer The digital root.
	 * 
	 * @param n
	 * @return
	 */
	static int digitalroot(String n) {
		BigDecimal i = new BigDecimal(n);
		if (i.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal[] r = i.divideAndRemainder(BigDecimal.TEN);
			int a = (r[1].intValueExact() + digitalroot((r[0].toPlainString())));
			if (a > 9) {
				return digitalroot("" + a + "");
			}
			return (int) a;

		}
		return 0;
	}

	/**
	 * 
	 Find the reversed number from the given one.
	 * 
	 * Example: For n = 6587 the answer is 7856. Note: For n = 20 the answer is
	 * 2.
	 * 
	 * [input] integer n
	 * 
	 * [output] integer
	 */
	static int reverse_number(int n) {

		int r = 0;
		while (n > 0) {
			r += n % 10;
			n /= 10;
			r *= 10;

		}
		return r / 10;
	}

	/**
	 * the length of the maximum non-decreasing contiguous subarray of the
	 * studying days, to study as much before his current exams.
	 * 
	 * Example:
	 * 
	 * For n = 6 and a = [2,2,1,3,4,1] the answer is 3.
	 * 
	 * [input] integer n
	 * 
	 * The number of days. [input] array.integer a
	 * 
	 * The number of hours he studied each day. [output] integer
	 * 
	 * The length of the maximum non-decreasing contiguous subarray.
	 * 
	 * @param n
	 *            - number of days
	 * @param a
	 *            - array containing integers.
	 * @return The length of the maximum non-decreasing contiguous subarray.
	 */
	static int StudyingHours(int n, int[] a) {
		int r = 0;
		int m = 1;
		for (int i = 0; i < a.length; i++) {

			int p = 0;
			for (int j = i; j < i + n && j < a.length; j++) {

				if (j > i && p <= a[j]) {
					m++;
				} else {
					r = Math.max(r, m);
					m = 1;
				}
				p = a[j];
			}
		}
		return Math.max(r, m);
	}

	/**
	 * The Vigenère cipher is a method of encrypting alphabetic text by using a
	 * series of different Caesar (see here) ciphers based on the letters of a
	 * keyword. The Vigenère cipher (see here) consists of several Caesar
	 * ciphers performed consequently with different shift values.
	 * 
	 * Character by character:
	 * 
	 * Loop the keyword into a string of the same length as the message to
	 * encrypt; Encode each character of the keyword: a = 00, b = 01, c = 02, d
	 * = 03, ... z = 25; Shift letters of the original message by the folowing
	 * formula: d[i] = (c[i] + k[i]) % 26 ; where d: characters of the encrypted
	 * message. c: characters of the original message. k: keyword encoding.
	 * 
	 * Given a message and a keyword, write a program to encode it. Note: both
	 * message and keyword are in lowercase and have only characters in range
	 * ['a'..'z'] and spaces (' '). When encoding, skip the space but still keep
	 * it in your result. Good luck.
	 * 
	 * Example:
	 * 
	 * For message = "when the leaves fall" and keyword = "autumn" the result is
	 * "wbxh fue fxuhrs ztfx" For message = "when the leaves fall" and keyword =
	 * "a utu mn" the result is still "wbxh fue fxuhrs ztfx"
	 * 
	 * Explaination: Codes of the message: 22070413 190704 110400210418 05001111
	 * Keyword loop: "autumnautumnautumn....." Codes of the keyword: 00201920
	 * 121300 201920121300 20192012
	 * 
	 * New codes of the message:
	 * 
	 * d[0] = (22 + 00) % 26 = 22 d[1] = (07 + 20) % 26 = 01 d[2] = (04 + 19) %
	 * 26 = 23 ... Finally, we have: 22012307 052004 052320071718 25190523 New
	 * message is: "wbxh fue fxuhrs ztfx".
	 * 
	 * [input] string message
	 * 
	 * Content of the message that you need to encode. [input] string keyword
	 * 
	 * A keyword that you can use to encode the message. [output] string
	 * 
	 * Encoded message.
	 * 
	 * @param message
	 *            to be encrypted.
	 * @param keyword
	 *            keyword to be used for encryption.
	 * @return encrypted message.
	 */
	static String vigenere_encode(String message, String keyword) {
		int c = 0;

		keyword = keyword.replace(" ", "");
		int l = keyword.length();
		StringBuilder m = new StringBuilder();

		while (keyword.length() < message.length()) {
			keyword += keyword.charAt(c++ % l);
		}

		c = 0;
		int k = 0;

		while (c < message.length()) {
			char d = message.charAt(c);
			if (d != ' ') {
				m.append((char) ((d - 'a' + keyword.charAt(k++) - 'a') % 26 + 'a'));
			} else {
				m.append(' ');
			}
			c++;
		}

		return m.toString();
	}

	static String vigenere_encode0(String message, String keyword) {
		int c = 0;

		keyword = keyword.replace(" ", "");
		int l = keyword.length();
		StringBuilder m = new StringBuilder();

		while (keyword.length() < message.length()) {
			keyword += keyword.charAt(c++ % l);
		}

		c = 0;
		int k = 0;

		while (c < message.length()) {
			char d = message.charAt(c);
			if (d != ' ') {
				m.append((char) ((d - 'a' + keyword.charAt(k++) - 'a') % 26 + 'a'));
			} else {
				m.append(' ');
			}
			c++;
		}

		return m.toString();
	}

	/**
	 * Given a string S, your task is to find its substring that occurs most
	 * often in S. Among all such substrings you must find the one which has the
	 * maximum length. As a result return only one integer - the length of the
	 * answer.
	 * 
	 * Example:
	 * 
	 * For S = "abab" the output should be 2.
	 * 
	 * [input] string S
	 * 
	 * 2 ≤ s.length ≤ 200 [output] integer
	 * 
	 * 
	 * @param S
	 * @return
	 */
	static int strings(String S) {
		Set<Character> u = new HashSet<Character>();

		int j = 0;
		int m = 0;
		int d = 0;
		char p = ' ';
		String r = "";

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (!u.add(c)) {
				if (i - j == 1) {
					d++;
					r += c;
					String f = S.replace(r, "");
					if (S.length() - f.length() >= 2 * r.length()) {
						m = Math.max(m, d);

					} else {
						d = 0;
						r = "";
					}

				} else {
					d = 1;
					r += c;
					m = Math.max(m, d);
				}
				j = i;
				p = c;

			} else {
				d = 0;
				r = "";
			}
		}
		return m;

	}

	/**
	 * 
	 You have N unsorted arrays, find their intersection. Return a sorted
	 * array of unique items. An element is a part of the intersection if and
	 * only if it's present in all arrays, the same number of times in each
	 * array. It is a guaranteed that there is at least one element in the
	 * resulting array.
	 * 
	 * Example
	 * 
	 * For arrays = [[2, 1, 5, 3, 5], [3, 5, 5]] the output should be [3, 5].
	 * 
	 * Number 3 appears once in each array. Number 5 appears twice in each
	 * array.
	 * 
	 * [input] array.array.integer arrays 2 ≤ arrays.size ≤ 10.
	 * 
	 * [output] array.integer A sorted array of unique elements.
	 * 
	 * 
	 * 
	 * 
	 * @param arrays
	 * @return
	 */
	static int[] intersection(int[][] arrays) {

		Set<Integer> s = new HashSet<Integer>();
		Map<Integer, Map<Integer, Integer>> l = new HashMap<Integer, Map<Integer, Integer>>();
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				Map<Integer, Integer> a = l.get(arrays[i][j]);
				if (a == null) {
					a = new HashMap<Integer, Integer>();
				}
				Integer v = a.get(i);
				if (v == null) {
					v = 0;
				}
				v++;
				a.put(i, v);
				l.put(arrays[i][j], a);
				s.add(arrays[i][j]);
			}
		}

		Integer[] e = s.toArray(new Integer[0]);

		List<Integer> f = new ArrayList<Integer>();
		for (int i : e) {

			if (l.get(i).size() == arrays.length) {
				// in all arrays it should equal number of occurrences.
				int o = 0;
				boolean tbd = true;

				Map<Integer, Integer> oc = l.get(i);
				for (int k = 0; k < arrays.length; k++) {
					if (k > 0 && o != oc.get(k)) {
						tbd = false;
						break;
					}
					o = oc.get(k);
				}

				if (tbd) {
					f.add(i);
				}
			}
		}

		int[] r = new int[f.size()];
		for (int i = 0; i < f.size(); i++) {
			r[i] = f.get(i);
		}
		Arrays.sort(r);

		return r;
	}

	/**
	 * 
	 * You're given n numbers.
	 * 
	 * Return the sum of digits of all prime numbers among the given numbers.
	 * 
	 * Example
	 * 
	 * For n = 3 and a = [11, 21, 54] the output should be 2. For n = 4 and a =
	 * [22, 7, 121, 17] the output should be 15.
	 * 
	 * [input] integer n 1 ≤ n < 26.
	 * 
	 * [input] array.integer a 1 ≤ a[i] < 27.
	 * 
	 * [output] integer
	 * 
	 * @param n
	 * @param a
	 * @return
	 */

	static int sumofprimenumbers(int n, int[] a) {
		int r = 0;

		for (int i = 0; i < n; i++) {
			boolean p = true && a[i] != 1;

			for (int j = 2; j <= Math.sqrt(a[i]); j++) {
				if (a[i] % j == 0) {
					p = false;
					break;
				}
			}

			if (p) {

				while (a[i] > 0) {
					r += a[i] % 10;
					a[i] /= 10;
				}

			}
		}

		return r;
	}

	public static boolean isPrime(int n, List<Integer> p) {
		int l = 0;

		if (n == 1) {
			return false;
		}

		if (p.contains(n)) {
			return true;
		}
		for (int i = 0; i < p.size(); i++) {
			if (n % p.get(i) == 0) {
				return false;
			}
			l = p.get(i);
		}

		for (int i = l + 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		p.add(n);
		System.out.println(p);
		return true;
	}

	String myConcat(String[] arguments, String separator) {

		String result = "";
		for (int i = 1; i < arguments.length; i++) {
			result += arguments[i];
			result += separator;
		}
		return result;
	}

	/**
	 * Say hello to Invoker, the most versatile hero in the game Defense of the
	 * Ancients (DotA)
	 * 
	 * Invoker combines 3 basic elements: (Q)uas, (W)ex and (E)xort to create 10
	 * different powerful skills:
	 * 
	 * WWW => (E)MP WWQ => (T)ornado WWE => (A)lacrity QQW => (G)host Walk QQQ
	 * => (C)old Snap QQE => (I)ce Wall EEQ => (F)orge Spirit EEE => (S)un
	 * Strike EEW => Chaos (M)eteor QWE => (D)eafening Blast For example, to use
	 * Ice Wall, a player has to prepare 2 Quas and 1 Exort, then hit R to
	 * activate it. Note that the order of the element is not important, i.e.
	 * "QQE" is the same as "QEQ" or "EQQ".
	 * 
	 * Invoker can have only 3 elements prepared at a time. For example, if he
	 * had had "EQQ" prepared before the player hit "W" (a hotkey for Wex), he
	 * would carry "QQW". The new element pushed the oldest one out. Hitting R
	 * does not change the prepared elements, only activates the corespondent
	 * skill.
	 * 
	 * Serin is having trouble controlling Invoker. He wants to know the least
	 * number of keystrokes required to activate a certain list of skills.
	 * 
	 * Given the skills Serin wants to perform in the exact order, return the
	 * least number of keystrokes required to activate them.
	 * 
	 * 1 ≤ |skills| ≤ 10 skills contains only the following characters: 'E',
	 * 'T', 'A', 'G', 'C', 'I', 'F', 'S', 'M', 'D' Since a skill has to be
	 * cooled down after one use, Serin will not attempt to activate any skill
	 * twice in a combo. That is to say, each of the above characters appears at
	 * most once in skills. Examples:
	 * 
	 * For skills = "D" the output should be 4. Serin wants to perform
	 * (D)eafening Blast. The sequence of key strokes can be "QWER", "QEWR",
	 * "WQER", "WEQR", "EQWR" or "EWQR" For skills = "ET" the output should be
	 * 6. This sequence is "WWWRQR" For skills = "ECS" the output should be 12.
	 * The only way is "WWWRQQQREEER" For skills = "DMIETAG" the output should
	 * be 22. The key strokes are "QWERERQQRWWWRQRWEWRQQR" IMPORTANT NOTE: Mind
	 * the time limit!
	 * 
	 * [input] string skills
	 * 
	 * A string represents the skills Serin wants to perform, in order. [output]
	 * integer
	 * 
	 * The least possible number of keystrokes to create that combo.
	 * 
	 * @param skills
	 * @return
	 */
	int Invoke(String skills) {
		return 0;
	}

	/**
	 * You are given two positive integers x and p. Find a modular inverse for x
	 * mod p, where p is prime.
	 * 
	 * Note: the modular inverse of x mod p is the y value that makes (x * y) %
	 * p = 1.
	 * 
	 * Example:
	 * 
	 * For x = 2 and p = 7 the output is 4.
	 * 
	 * [input] integer x
	 * 
	 * A positive integer. [input] integer p
	 * 
	 * A prime number, 1 ≤ x
	 * < p
	 * ≤ 10**9 + 7. [output] integer
	 * 
	 * A modular inverse for x (mod p).
	 * 
	 * @param x
	 * @param p
	 * @return
	 */
	static int ReversePrime1(int x, int p) {
		int i = p;
		p = 1;

		while (p % x != 0)
			// p++;
			p += i;

		return p / x;

	}

	static int ReversePrime(int x, int p) {
		int i = p;
		p = 1;
		while (p % x != 0) {
			p += i;
		}
		return p / x;

	}

	static int ReversePrime3(int x, int p) {
		int y = 0;
		while ((x * y) % p != 1) {
			y++;
		}
		return y;

	}

	static int ReversePrime4(int x, int p) {
		if (x == 1)
			return 1;
		int y = p / x;
		while ((x * y) % p != 1)
			y++;

		return y;

	}

	static int ReversePrime0(int x, int p) {
		return x % p == 1 ? 1 : (p + 1) / x;

	}

	/**
	 * You are given N coins. The ith coin has a value of ai. How many ways are
	 * there to get a sum equal to S using the coins you have?
	 * 
	 * Exapmle
	 * 
	 * For N = 5, S = 8 and a = [2,5,3,3,2] the answer should be 4. The possible
	 * combinations are [1,3,4], [2,3], [2,4] and [3,4,5] (here a number denotes
	 * 1-based index of the coin to take).
	 * 
	 * The first method explanation: [1,3,4] a[1] = 2, a[3] = 3, a[4] = 3, a[1]
	 * + a[3] + a[4] = 8
	 * 
	 * [input] integer N
	 * 
	 * 1 ≤ N ≤ 22. [input] integer S
	 * 
	 * 1 ≤ S ≤ 10000. [input] array.integer a
	 * 
	 * 1 ≤ ai ≤ 100. [output] integer
	 * 
	 * The number of ways to get S. CODE
	 * 
	 * @param N
	 * @param S
	 * @param a
	 * @return
	 */
	static int coins0(int N, int S, int[] a) {
		Arrays.sort(a);
		int r = 0;
		Map<Integer, Integer> c = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			Integer o = c.get(a[i]);
			if (o == null) {
				o = 0;
			}
			o++;
			c.put(a[i], o);
		}

		return r;
	}

	static int coins(int N, int S, int[] a) {
		if (a.length == 1 && a[0] == S) {
			return 1;
		}
		int r = 0;
		int[] pa = new int[a.length];
		int[] sa = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			pa[i] += a[i];
			sa[i] += a[a.length - i - 1];
			if (i > 0) {
				pa[i] += pa[i - 1];
				sa[i] += sa[i - 1];
			}
		}

		for (int i = 0; i < a.length; i++) {

			if (sa[i] == S) {
				r++;
			}
			if (pa[i] == S) {
				r++;
			}
			for (int j = i + 1; j < a.length; j++) {
				if (j < a.length) {

					if (pa[j] - pa[i] == S) {
						r++;
					}
					if (sa[j] - sa[i] == S) {
						r++;
					}

				} else {
					break;
				}
			}
		}

		return r;
	}

	/**
	 * If you write numbers from 1 to N next to each other, how many digits will
	 * be written?
	 * 
	 * Given number N, return the total number of digits written.
	 * 
	 * Examples
	 * 
	 * For N = 10 the answer should be 11, because [12345678910] has 11 digits.
	 * 
	 * [input] integer N
	 * 
	 * 1 ≤ N ≤ 10**8. [output] integer
	 * 
	 * The total number of digits.
	 * 
	 * @param N
	 * @return
	 */
	static int CountingDigits(int N) {
		StringBuilder sb = new StringBuilder();

		while (N > 0) {
			sb.append(N % 9);
			N /= 9;
		}
		return Integer.parseInt(sb.reverse().toString());
	}

	/**
	 * A number whose biggest prime factor doesn't exceed 5 is called a Hamming
	 * number. The Hamming number sequence starts with 1, 2, 3, 4, 5, 6, 8, 9,
	 * 10, 12, 15,... .
	 * 
	 * Let K-Hamming number be a number whose largest prime factor doesn't
	 * exceed K. So any Hamming number is actually 5-Hamming number.
	 * 
	 * Find the number of K-Hamming numbers that are not greater than N.
	 * 
	 * Example:
	 * 
	 * Hamming_number_part1("10", 5) = 9 as there're 9 numbers that satisfy the
	 * given conditions: 1, 2, 3, 4, 5, 6, 8, 9, 10.
	 * 
	 * [input] string N
	 * 
	 * 1 ≤ N < 2**52. [input] integer K
	 * 
	 * 2 ≤ K ≤ 100. [output] integer
	 * 
	 * 
	 * @param N
	 * @param K
	 * @return
	 */
	int Hamming_number_part1(String N, int K) {
		List<Integer> f = new ArrayList<Integer>();
		f.add(2);
		List<Integer> p = new ArrayList<Integer>();
		if (K >= 1) {
			p.add(1);
		}
		if (K >= 2) {
			p.add(2);
		}
		int m = Integer.parseInt(N);
		for (int i = 3; i <= m; i++) {
			// get largest prime factor
			boolean d = false;
			for (int j = 0; j < f.size(); j++) {
				if (i % f.get(j) == 0) {
					d = true;
					break;
				}
			}

			if (!d) {
				f.add(i);
				if (K >= i) {
					p.add(i);
				}
			} else {
				d = false;
				for (int j = K; j < i; j++) {
					if (i % j == 0) {
						d = true;
						break;
					}
				}

				if (!d) {
					p.add(i);
				}
			}

		}
		return p.size();
	}

	/**
	 * A well-ordered number is a number where each digit is greater than the
	 * previous one.
	 * 
	 * Given a number, find out whether it's well-ordered or not.
	 * 
	 * [input] integer n
	 * 
	 * The number to check. [output] boolean
	 * 
	 * true if the given number is well-ordered, false otherwise.
	 * 
	 * @param n
	 * @return
	 */
	static boolean wellOrderedNumber(int n) {
		String s = Integer.toString(n);
		for (int i = 1; i < s.length(); i++) {
			int r = s.charAt(i) - s.charAt(i - 1);
			if (r <= 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 *
	 * You're given an integer N.
	 *
	 * Your task is to return "1234...N...4321".
	 *
	 * Example:
	 *
	 * For N = 5, the output is "123454321". For N = 8, the output is
	 * "123456787654321".
	 *
	 * [input] integer N 0 < N < 10
	 *
	 * [output] string
	 *
	 * @param N
	 * @return
	 */
	static String Palindromic_Number(int N) {
		StringBuilder s = new StringBuilder();
		int i = 0;
		while (i < N) {
			s.append(++i);
		}

		while (i > 1) {
			s.append(--i);
		}

		return s.toString();

	}

	/**
	 * You're given an array of two strings, [s1, s2]. You have to find weather
	 * s2 is a rotation of s1.
	 * 
	 * String s2 is a rotation of string s1 if it's possible to make them equal
	 * by shifting characters in s2 clockwise or counterclockwise.
	 * 
	 * If s2 is a rotation of s1, return "YES", otherwise return "NO".
	 * 
	 * Examples:
	 * 
	 * For Array = ["codefights","fightscode"] the output should be "YES". For
	 * Array = ["code", "odec"] the output should be "YES". For Array =
	 * ["butter", "tterub"] the output should be "NO".
	 * 
	 * In the second example if you rotate s2 clockwise, 'c' will move in front
	 * of the modified string, so it will become code. Thus the answer is "YES".
	 * 
	 * [input] array.string Array
	 * 
	 * An array of length 2, 1 ≤ Array[i] ≤ 100. Each character is a lowercase
	 * Latin letter. [output] string
	 * 
	 * "YES" or "NO".
	 * 
	 * @param Array
	 * @return
	 */
	String stringRotation(String[] Array) {
		String f = Array[0] + Array[0];
		int d = f.length() - f.replace(Array[1], "").length();
		return d == 0 ? "NO" : d % Array[0].length() == 0 ? "YES" : "NO";
	}

	String findAndReplace(String originalString, String stringToFind,
			String stringToReplace) {
		return originalString.replace(stringToFind, stringToReplace);
	}

	/**
	 * Determine the state of a deck of cards after the given number of riffle
	 * shuffles.
	 * 
	 * You are given an array of 2 * n cards representing the initial state of
	 * the cards from top to bottom, and a number of shuffles to perform over
	 * this deck.
	 * 
	 * Assume that every shuffle is done perfectly starting with the lower half
	 * of the cards.
	 * 
	 * Shuffle examples:
	 * 
	 * [1,2,3,4] => divide in halves [1,2],[3,4] => combine [1,3,2,4]
	 * 
	 * The second shuffle:
	 * 
	 * [1,3,2,4] => divide in halves [1,3],[2,4] => combine [1,2,3,4]
	 * 
	 * Examples:
	 * 
	 * Input: [1,2,3,4], 2 Output: [1,2,3,4]
	 * 
	 * Input: [1,2,3,4], 1 Output: [1,3,2,4]
	 * 
	 * Input:
	 * [3,4,7,3,4,6,4,2,2,3,4,5,7,8,9,5,4,3,3,5,6,7,8,8,6,5,4,3,5,6,7,8,5,
	 * 6,3,5,7,8], 17 Output:
	 * [3,5,6,8,6,3,5,8,7,5,3,5,8,5,3,2,6,3,4,7,3,5,7,5,4,
	 * 6,8,6,3,4,9,7,4,2,4,4,7,8]
	 * 
	 * Note that the first and the last elements are always the same.
	 * 
	 * [input] array.integer deck
	 * 
	 * Array representing cards from top to bottom. 2 ≤ |deck| ≤ 100 1 ≤ deck[i]
	 * ≤ 9 It is guaranteed that |deck| is always an even number. [input]
	 * integer numberOfRiffleShuffles
	 * 
	 * The number of shuffles, 0 ≤ numberOfRiffleShuffles ≤ 100. [output]
	 * array.integer
	 * 
	 * The state of the deck of cards after the given number of shuffles. CODE
	 * 
	 * @param deck
	 * @param numberOfRiffleShuffles
	 * @return
	 */
	int[] shuffleState(int[] deck, int numberOfRiffleShuffles) {
		return null;
	}

	/**
	 * Rank of Array Element
	 * 
	 * Given an array A, find the rank of the element at the ith position.
	 * 
	 * The rank of the A[i] is a value equal to the number of elements less than
	 * or equal to A[i] standing before A[i], plus the number of elements less
	 * than A[i] standing after A[i].
	 * 
	 * [input] array.integer A
	 * 
	 * An array of integers, |A| < 15. [input] integer i
	 * 
	 * Index of the element whose rank is to be found. [output] integer
	 * 
	 * Rank of the element at the ith position.
	 * 
	 * @param A
	 * @param i
	 * @return
	 */
	static int RankOfElement(int[] A, int i) {

		int r = 0;
		for (int j = 0; j < A.length; j++)
			// value equal to the number of elements less than or equal to A[i]
			// standing before A[i]
			if (A[j] <= A[i] && j < i)
				r++;
			// number of elements less than A[i] standing after A[i]
			else if (A[j] < A[i] && j > i)
				r++;

		return r;

	}

	static int[][] pyramidMatrix(int N) {
		int[][] r = new int[N][N];

		for (int i = 0; i < N / 2 + N % 2; i++) {
			for (int j = 0; j < N; j++) {
				r[i][j] = (i == 0 || j == 0 || i == N - 1 || j == N - 1) ? 1
						: i < N / 2 + N % 2 ? (i + 1) : 0;
				r[N - i - 1][j] = r[i][j];
			}
		}

		if (N % 2 == 1 && N > 1) {
			r[N / 2][N / 2] = N - 1;
		}
		return r;
	}

	static int[][] pyramidMatrix0(int N) {
		int[][] r = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				r[i][j] = (i == 0 || j == 0 || i == N - 1 || j == N - 1) ? 1
						: i < N / 2 + N % 2 ? (i + 1) : 0;
			}
		}

		return r;
	}

	/**
	 * You are given a string containing a valid mathematical expression. This
	 * expression is given in Roman notation: digits and numbers inside it are
	 * not decimal numerals, but Roman Numerals .
	 * 
	 * Your challenge is to return the integer value of that expression in the
	 * decimal system.
	 * 
	 * The expression can contain the following symbols:
	 * 
	 * operators: '+', '/', '-', '*', '=', '(' and ')'; numerals: 'C', 'D', 'I',
	 * 'M', 'V' and 'X'. Examples:
	 * 
	 * RomanExpression("V+V=") = 10, as 5 + 5 = 10 RomanExpression("IX=") = 9,
	 * as 9 = 9 RomanExpression("(III+VI)*CM=") = 8100, as (3 + 6) * 900 = 8100
	 * [input] string expression
	 * 
	 * A valid mathematical expression to solve. [output] integer
	 * 
	 * Expression value.
	 * 
	 * @param expression
	 * @return
	 */
	int RomanExpression(String expression) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("I", 1);
		m.put("II", 2);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);

		Stack<Character> operator = new Stack<Character>();

		String o1 = "";
		String o2 = "";

		for (int i = 0; i < expression.length(); i++) {

		}
		return 0;
	}

	/**
	 * You are given two integers L and R. What single digit occurs the most
	 * often in all the numbers between them (inclusive)? If there is more than
	 * one solution, return the smallest one.
	 * 
	 * [input] integer L
	 * 
	 * 1 ≤ L ≤ 10**7. [input] integer R
	 * 
	 * 1 ≤ L ≤ R ≤ 107. [output] integer
	 * 
	 * The digit which occurs most often.
	 * 
	 * @param L
	 * @param R
	 * @return
	 */
	static int digit(int L, int R) {

		int[] c = new int[10];
		int r = 0;
		int m = 10;
		for (int i = L; i <= R; i++) {
			int j = i;
			while (j > 0) {
				int k = j % 10;
				c[k]++;
				r = Math.max(r, c[k]);
				j /= 10;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (c[i] == r) {
				return i;
			}
		}

		return m;

	}

	/**
	 * TwoPrimes
	 * 
	 * Write a function which returns true if and only if both input numbers are
	 * prime, otherwise return false.
	 * 
	 * [input] integer a
	 * 
	 * [input] integer b
	 * 
	 * [output] boolean
	 * 
	 * true if both numbers are prime, false otherwise.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static boolean TwoPrimes(int a, int b) {

		if (a == 1 || b == 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(Math.max(a, b)); i++) {
			if (a % i == 0 || b % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * You are given a string S representing a number in the roman numeral
	 * system. Check if the string S contains a correctly written roman number
	 * and if so return this number as an integer, otherwise return -1.
	 *
	 * For reference on how roman numerals work:
	 * https://en.wikipedia.org/wiki/Roman_numerals
	 *
	 * For this challenge we assume that there is no restriction on maximum
	 * number that can be written in roman numerals.
	 *
	 * [input] string s A string S consisting of characters I, V, X, L, C, D, M.
	 * 1 ≤ |S| ≤ 100.
	 *
	 * [output] integer The integer value of the given roman number or -1 if the
	 * input doesn't contain a correct roman numeral.
	 *
	 *
	 * @param s
	 * @return
	 */
	static int RomanNumerals(String s) {
		Map<Character, Integer> rm = new HashMap<Character, Integer>();
		rm.put('I', 1);
		rm.put('V', 5);
		rm.put('X', 10);
		rm.put('L', 50);
		rm.put('D', 500);
		rm.put('C', 100);
		rm.put('M', 1000);

		Stack<Integer> o = new Stack<Integer>();
		int r = 0;
		Integer v = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			v = rm.get(c);
			if (v == null) {
				return -1;
			}
			o.push(v);
		}

		int p = o.peek();
		while (!o.isEmpty()) {
			v = o.pop();
			if (v < p) {
				r -= v;
			} else {
				r += v;
			}
			p = v;
		}

		return r;
	}

	static int RomanNumerals0(String s) {
		Map<Character, Integer> rm = new HashMap<Character, Integer>();
		rm.put('I', 1);
		rm.put('V', 5);
		rm.put('X', 10);
		rm.put('L', 50);
		rm.put('D', 500);
		rm.put('C', 100);
		rm.put('M', 1000);

		Stack<Integer> o = new Stack<Integer>();
		int r = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer v = rm.get(c);
			if (v == null) {
				return -1;
			}
			if (!o.isEmpty()) {
				int b = o.pop();
				if (b < v) {
					r += (v - b);
				} else {
					r += (v + b);
				}

			} else {
				o.push(v);
			}

		}

		if (!o.isEmpty()) {
			r += o.pop();
		}

		return r;
	}

}
