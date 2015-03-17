/**
 Write a function that takes a number n and returns an array containing a Fibonacci sequence of length n. 
 If there are multiple ways to do something prefer the simpler way. 
 Here is more information on Fibonacci sequences including the formula: http://en.wikipedia.org/wiki/Fibonacci_number
 */
import java.math.BigInteger;


public class Fibonacci {

	/**
	 * @param n
	 *            - number of fibonacci numbers like to get.
	 * @return n number of fibonacci numbers. e.g. if value of n = 3 it will
	 *         return an array of values 0,1,1 if value of n = 4 it will return
	 *         an array of values 0,1,1,2 if value of n = 5 it will return an
	 *         array of values 0,1,1,2,3
	 */
	public BigInteger[] getFibonacci(int n) {
		// Create an array of size n.
		BigInteger[] values = null;
		if (n >= 0) {
			// array size can not be negative.
			values = new BigInteger[n];
			for (int i = 0; i < n; i++) {
				if (i == 1 || i == 2) {
					values[i] = BigInteger.ONE;
				} else if (i == 0) {
					values[i] = BigInteger.ZERO;
				} else {
					values[i] = values[i - 1].add(values[i - 2]);
				}
			}
		}
		return values;
	}
}