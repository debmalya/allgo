package deb.algo;

public class SortUtil {
	/**
	 * 
	 * @param v collection of comparable items.
	 * @return true if sorted in ascending order, false otherwise
	 */
	public static boolean isSortedAscending(Comparable[] v) {
		for (int i = 0; i < v.length - 1; i++) {
			if (v[i].compareTo(v[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * To check whether sorted in descending order or not
	 * @param v collection of comparable items.
	 * @return true if sorted in descending order, false otherwise
	 */
	public static boolean isSortedDescending(Comparable[] v) {
		for (int i = 0; i < v.length - 1; i++) {
			if (v[i].compareTo(v[i + 1]) < 0) {
				return false;
			}
		}
		return true;
	}
}
