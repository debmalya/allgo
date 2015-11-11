/**
 * 
 */
package he;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class DiscoverTheMonk {

	public static void main(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {

			String[] nq = scanner.nextLine().split(" ");
			int n = Integer.parseInt(nq[0]);
			int q = Integer.parseInt(nq[1]);

			String[] a = scanner.nextLine().split(" ");
			int[] ar = new int[n];

			for (int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(a[i]);
			}

			int[] queries = new int[q];
			for (int i = 0; i < q; i++) {
				queries[i] = scanner.nextInt();
			}

			Arrays.sort(ar);
			for (int i = 0; i < q; i++) {
				int index = Arrays.binarySearch(ar, queries[i]);
				System.out.println(index > -1 ? "YES" : "NO");
			}
		}
	}
}
