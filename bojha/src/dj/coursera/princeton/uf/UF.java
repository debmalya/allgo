/**
 * 
 */
package dj.coursera.princeton.uf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class UF {

	private int[] arr;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			UF uf = new UF(N);
			while (scanner.hasNextInt()) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();

				if (!uf.connected(p, q)) {
					uf.connected(p, q);
					
				}

			}
		}

	}

	public UF(int n) {
		arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = i;
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		arr[i] = j;
		System.out.println(this);
	}

	public void union0(int p, int q) {
		arr[p] = q;
	}

	public int root(int p) {
		while (arr[p] != p) {
			return root(arr[p]);
		}
		return p;
	}
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UF [arr=" + Arrays.toString(arr) + "]";
	}
	
	
}
