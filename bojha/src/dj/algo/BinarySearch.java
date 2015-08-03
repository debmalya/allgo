/**
 * 
 */
package dj.algo;

/**
 * @author debmalyajash
 *
 */
public class BinarySearch {

	public static int rank(int[] A, int key) {
		int mid = A.length / 2;
		int low = 0;
		int high = A.length - 1;
		while (low < high) {
			if (key > A[mid]) {
				low = mid + 1;
			} else if (key < A[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
			mid = (high + low) / 2;
		}
		return -1;
	}
}
