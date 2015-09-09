/**
 * 
 */
package hr;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int V = scanner.nextInt();
			int n = scanner.nextInt();
			scanner.nextLine();
			String[] arv = scanner.nextLine().split(" ");
			int[] ar = new int[arv.length];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = Integer.parseInt(arv[i]);
			}
			
			int mid = 0;
			int high = arv.length - 1;
			int low = 0;
			while (low <= high) {
				 mid = (low + high) / 2;
				if (V == ar[mid]) {
					System.out.println(mid);
					break;
				} else if (V < ar[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}

	}

}
