/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class NumberForm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * S is a list of numbers, sorted in ascending order. Any number in S can be
	 * represented in the form 2i * 3j for some i, j ≥ 0.
	 * 
	 * The first numbers in S are [1, 2, 3, 4, 6, 8, 9, 12, 16].
	 * 
	 * 1 = 2^0 * 3^0. 6 = 2^1 * 3^1. 12 = 2^2 * 3^1. Write the body of a
	 * function that returns the nth element of S.
	 * 
	 * __Examples: __
	 * 
	 * NumberForm(0) = 1 as S[0] = 1. NumberForm(4) = 6 as S[4] = 6.
	 * 
	 * [input] integer N
	 * 
	 * 0 ≤ N ≤ 200. [output] integer
	 * 
	 * 
	 * @param N
	 * @return
	 */
	static int NumberFormula(int N) {
		int seq[] = new int[N+1];
		int i, i2, i3, i5, x, x2, x3, x5;

		seq[0] = 1;
		i = 0;
		x = 1;
		i2 = i3 = i5 = -1;
		x2 = 2;
		x3 = 3;
		x5 = 6;
		while (++i < N+1) {
			seq[i] = x = (x2 <= x3 && x2 <= x5) ? x2 : (x3 <= x5) ? x3 : x5;
			while (x2 <= x)
				x2 = 2 * seq[++i2];
			while (x3 <= x)
				x3 = 3 * seq[++i3];
			while (x5 <= x)
				x5 = x2 * x3;
		}
		return seq[i - 1];
	}

}
