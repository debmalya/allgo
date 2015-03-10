public class Fibonacci {
	public int[] getFibonacci(int n) {
		if ( n < 0) {
			throw new IllegalArgumentException("parameter can not be less than 0, Passed parameter is " + n);
		}
		// An array of size n.
		int[] values = null;
		
			values = new int[n];
			for (int i = 0; i < n; i++) {
				values[i] = fibonacci(i);
			}
		

		return values;
	}

	/**
	 * 
	 * @param n
	 *            - term number.
	 * @return fibonacci value for nth term.
	 */
	public int fibonacci(int n) {
		if (n < 0) {
			return (int) Math.pow(-1, (n + 1)) * fibonacci(Math.abs(n));
		} else if (n == 1 || n == 2) {
			return 1;
		} else if (n == 0) {
			return 0;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);

	}
}
