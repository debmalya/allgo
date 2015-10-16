/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class SubarraySearch {
	/**
	 * Determine if the given subarray is a subarray of the given array. A
	 * string is a subarray of another string if the first string is not longer
	 * than the second, and all its letters are present in the second string in
	 * the exact same order, but not necessarily consecutive. Cases of the
	 * letters do not matter.
	 * 
	 * Example:
	 * 
	 * subarraysearch("ABCdefgh", "bCf) = true subarraysearch("ABCdefgh", 'i') =
	 * false
	 * 
	 * [input] string array
	 * 
	 * Input string, 2 < array < 10. [input] string subarray
	 * 
	 * A subarray. [output] boolean
	 * 
	 * true if subarray is a subarray of the array, false otherwise.
	 * 
	 * @param array
	 * @param subarray
	 * @return
	 */
	boolean subarraysearch(String array, String subarray) {
		if (array.length() >= subarray.length()) {
			array = array.toLowerCase();
			subarray = subarray.toLowerCase();
			
			
			int[] l = new int[subarray.length()];
			
			for (int i = 0; i < subarray.length(); i++) {
				char c = subarray.charAt(i);
				l[i] = array.indexOf(c);
				if (l[i] == -1) {
					return false;
				} else if (i > 0 && l[i -1] > l[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
