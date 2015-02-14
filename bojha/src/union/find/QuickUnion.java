package union.find;

import java.util.Scanner;



/**
 * 
 * @author debmalyajash Union Find
 */
public class QuickUnion {
	// element container
	private int[] id;

	// number of components.
	private int count;

	public int getCount() {
		return count;
	}

	/**
	 * Get the root.
	 * @param n - whose root will be identified.
	 * @return root of n.
	 */
	public int root(int n) {
		int i = id[n];
		while (i != id[i]) {
			id[i]=id[id[i]];
			i = id[n];
		}
		return i;
	}
	/**
	 * 
	 * @param N
	 *            - count of elements.
	 */
	public QuickUnion(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	/**
	 * 
	 * @param p
	 *            first id
	 * @param q
	 *            second id
	 * @return true if first and second are connected, false otherwise.
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * 
	 * @param p
	 * @return if p is there otherwise throw exception
	 */
	public int find(int p) {
		return root(p);
	}

	/**
	 * 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		
		if (pRoot == qRoot) return;
		
		id[qRoot] = pRoot;
		
		count--;
	}

	public void printArray() {
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i]+ " ");
		}
	}
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			QuickUnion uf = new QuickUnion(N);
			while (scanner.hasNextInt()) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				if (uf.connected(p, q))
					continue;
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
			System.out.println(uf.getCount() + " components");
		}		
	}
}
