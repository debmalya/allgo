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
	 * @return  integer : 0, 1, -1
	 */
	int mobious(String N) {
		int r = -1;
		long l = Long.parseLong(N);
		for (long d = 2; d*d <= l; d++){
			if (l % d == 0){
				
			}
		}
		return r;
	}
}
