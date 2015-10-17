/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class Summer {
	/**
	 * Any number can be represented as the sum of unique powers of 2. For
	 * example, 15 = 1 + 2 + 4 + 8 = 20 + 21 + 22 + 23. There's a function
	 * called Summer, which calculates the number of powers of two it takes to
	 * get the given number. Your task is to implement this function.
	 * 
	 * Example
	 * 
	 * Summer(15) = 4 Summer(16) = 1
	 * 
	 * [input] integer n
	 * 
	 * Some integer number. [output] integer
	 * 
	 * Summer(n).
	 * 
	 * @param n
	 * @return
	 */
	static int summer(int n) {
		int r = 0;
		String s = Integer.toBinaryString(n);
		for (int i = 0; i <s.length(); i++)
			if (s.charAt(i)== '1')
				r++;
		return r;
	}
	static int summer0(int n) {
		int r = 0;
		if (n < 0) {
			n *= -1;
		}
		
		while (n > 0) {
			if (n % 2 == 1) {
				r++;
			}
			n /= 2;
		}
		return r;
	}
}
