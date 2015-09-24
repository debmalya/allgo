/**
 * 
 */
package hr;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author debmalyajash first two terms of the series are 0 and 1: the third
 *         term = 12 + 0 = 1 fourth term = 12 + 1 = 2 fifth term = 22 + 1 = 5
 *         ... And so on.
 */
public class ModifiedFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String line = scanner.nextLine();
			String[] values = line.split(" ");
			BigDecimal a = new BigDecimal(values[0]);
			BigDecimal b = new BigDecimal(values[1]);
			int n = Integer.parseInt(values[2]);

			int count = 2;
			BigDecimal t = BigDecimal.ONE;
			while (count < n) {
				t = b.multiply(b).add(a);
				a = b;
				b = t;
				count++;

			}
			System.out.println(t);

		}

	}

}
