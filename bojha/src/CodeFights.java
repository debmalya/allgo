import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Stack;

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
		int r = l;
		int i, j;
		int[] c = new int[l];

		int t = 0;
		boolean[] o = new boolean[l];
		for (i = 0; i < l; i++) {
			c[i] = 10 - objects[i];
			t += objects[i];
		}

		int b = t / 10 + t % 10 > 0 ? 1 : 0;

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
	   * adding digits of the initial number and repeating this process while it has
	   * more than one digit.
	   * 
	   * Given a positive integer as a string, return its digital root.
	   * 
	   * Example
	   * 
	   * For n = "24" the result is 2 + 4 ==> 6. For n = "39" the result is 3 + 9
	   * ==> 12 ==> 1 + 2 ==> 3. For n = "999" the result is 9 + 9 + 9 ==> 27 ==> 2
	   * + 7 ==> 9.
	   * 
	   * [input] string n The input number, can contain up to 100 digits, n > 0
	   * 
	   * [output] integer The digital root. Method documentation to be filled TODO
	   * 
	   * @param n
	   * @return
	   */
	  static int digitalroot (String n)
	  {
	    BigDecimal i = new BigDecimal (n);
	    if (i.compareTo (BigDecimal.ZERO) > 0)
	    {
	      BigDecimal[] r = i.divideAndRemainder (BigDecimal.TEN);
	      int a = (r[1].intValueExact () + digitalroot ((r[0].toPlainString ())));
	      if (a > 9)
	      {
	        return digitalroot ("" + a + "");
	      }
	      return (int)a;

	    }
	    return 0;
	  }



	  /**
	   * 
	   Find the reversed number from the given one.
	   * 
	   * Example: For n = 6587 the answer is 7856. Note: For n = 20 the answer is 2.
	   * 
	   * [input] integer n
	   * 
	   * [output] integer
	   */
	  static int reverse_number (int n)
	  {

	    int r = 0;
	    while (n > 0)
	    {
	      r += n % 10;
	      n /= 10;
	      r *= 10;
	      
	    }
	    return r/10;
	  }

}
