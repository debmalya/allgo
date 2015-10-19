/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class NextNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You're given a number N. Find the smallest number greater than N which
	 * has the same number of active bits in it (i.e. the same number of 1 in
	 * binary representation).
	 * 
	 * Examples:
	 * 
	 * For N = 1 the output should be 2 (they both have 1 active bit) For N = 3
	 * the output should be 5 (they both have 2 active bits) [input] integer N
	 * 
	 * 1 ≤ n ≤ 10**9. [output] integer
	 * 
	 * 
	 * @param N
	 * @return
	 */
	int nextNumber(int N) {
		int c = c(N);
		int i = N + 1;
		
		for (; ;i++) {
			if (c == c(i)) {
				break;
			}
		}
		
		
		return i;
	}
	int nextNumber0(int N) {

		String o = Integer.toBinaryString(N);
		int c = o.length() - o.replace("1", "").length();
		int r = N + 1;
		while (true) {
			o = Integer.toBinaryString(r);
			int l = o.length() - o.replace("1", "").length();
			if (l == c)
				break;
			r++;
		}
		return r;
	}
	
	private int c(int N) {
		int c = 0;
		while (N > 0){
			c += N % 2;
			N /= 2;
		}
		return c;
		
	}

}
