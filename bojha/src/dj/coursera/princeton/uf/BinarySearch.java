/**
 * 
 */
package dj.coursera.princeton.uf;

/**
 * @author debmalyajash
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int binarySearch(int[] arr, int num) {
		int low = 0;
		int mid =  arr.length / 2;
		int high = arr.length;
		while (low <= high) {
			mid = (low + high) / 2;
			System.out.println(num + " compared with " + arr[mid]);
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
