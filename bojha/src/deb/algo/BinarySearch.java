package deb.algo;

public class BinarySearch {
	/**
	 * 
	 * @param items
	 *            sorted ascending order collection of comparable.
	 * @param item
	 *            to be searched.
	 * @param low
	 *            index.
	 * @param high
	 *            index
	 * @return true if exists, false otherwise.
	 */
	public boolean isExists(Comparable[] items, Comparable item, int low,
			int high) {
		if (low > high) {
			return false;
		}
		int mid = low + (high - low) / 2;
		int comparisonResult = items[mid].compareTo(item);
		System.out.println("Compared to " + items[mid]+" result " + comparisonResult+ " low " + low + " high "+ high);
		if (comparisonResult == 0) {
			return true;
		} else if (comparisonResult < 0) {
			low = mid + 1;
		} else {
			high = mid - 1;
		}
		
		return isExists(items, item, low, high);
		
	}
}
