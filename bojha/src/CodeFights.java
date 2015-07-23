import java.util.Arrays;

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
		for (int i = 0; i < list.length && s < sum; i++){
			s += list[i];
			c++;
			if (s == sum) {
				return c;
			}
		}
		return 0;
	}


}
