/**
 * 
 */
package hr;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Imba {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			
			int[] inputs = new int[testCases];
			
			for (int i = 0; i < testCases; i++) {
				inputs[i] = scanner.nextInt();
			}
			
			for (int i = 0; i < testCases; i++) {
				System.out.println(imba(inputs[i]));
			}
		} finally {

		}
	}
	
	private static String imba(final int n) {
		StringBuilder imba = new StringBuilder("");

		int i = 1;
		int m = n;
		while (i <= m) {
			imba.append(m--);

			if (i < m) {
				imba.append(" ");
				imba.append(i++);

			}
			imba.append(" ");

		}

		return imba.reverse().toString().trim();
	}
}
