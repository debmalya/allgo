/**
 * 
 */
package he;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class RomanfDiamond {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int T = scanner.nextInt();
			scanner.nextLine();
			int[] result = new int[T];
			for (int i = 0; i < T; i++) {
				String[] values = scanner.nextLine().split(" ");

				int N = Integer.parseInt(values[0]);
				int M = Integer.parseInt(values[1]);

				int c1 = 0;
				int c2 = 0;
				int c = 0;
				for (int j = 0; j < N; j++) {
					String each = scanner.nextLine();
					if (j % 2 == 0) {
						for (int k = 1; k < M - 1; k+=4) {
							if (each.charAt(k - 1) == '/'
									&& each.charAt(k+1) == '\\') {
								c1++;
							}
						}
					} else {
						for (int k = 1; k < M - 1; k+=4) {
							if (each.charAt(k - 1) == '\\'
									&& each.charAt(k+1) == '/') {
								c2++;
							}
						}
						c += Math.min(c1, c2);
						result[i] += c;
					}
				}

			}
			
			for (int each:result) {
				System.out.println(each);
			}
		}

	}
}
