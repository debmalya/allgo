/**
 * 
 */
package deb.algo;

/**
 * @author debmalyajash This is related to prefix sum.
 */
public class MushroomPicker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param mushrooms
	 *            number of mushrooms in each spot.
	 * @param currentSpot
	 *            - index of current post.
	 * @param noOfMovesAllowed
	 *            - no of moves allowed to collect maximum nunber of possible
	 *            mushrooms.
	 * @return maximum number of mushrooms collected.
	 */
	public int getMaxMushrooms(int[] mushrooms, int currentSpot,
			int noOfMovesAllowed) {
		int n = mushrooms.length;
		int result = 0;
		int[] pref = prefixSum(mushrooms);
		
		int upper = Math.min(currentSpot, noOfMovesAllowed) + 1;
		
		for (int index = 0; index < upper; index++) {
			int leftPos = currentSpot - index;
			int rightPos = Math.min(n - 1, Math.max(currentSpot, currentSpot + noOfMovesAllowed - 2 * index));
			result = Math.max(result,countSum(pref, leftPos, rightPos));
		}
		
		
		upper = Math.min(noOfMovesAllowed + 1, n - currentSpot);
		for (int index = 0; index < upper; index++) {
			int rightPos = currentSpot + index;
			int leftPos = Math.max(0, Math.min(currentSpot, currentSpot - (noOfMovesAllowed -2 ) * index));
			result = Math.max(result,countSum(pref, leftPos, rightPos));
			
		}
		
		return result;
	}

	/*
	 * 
	 */
	public int countSum(int[] p, int startIndex, int endIndex) {
		if (p != null && p.length > 0) {
			int length = p.length;
			if (endIndex > startIndex && endIndex < length
					&& startIndex < endIndex) {
				return p[endIndex] - p[startIndex];
			}
		}
		return Integer.MIN_VALUE;
	}

	/*
	 * Calculate prefix sum for the array.
	 */
	public int[] prefixSum(int[] a) {
		int len = a.length;
		int[] sum = new int[len];
		sum[0] = a[0];

		for (int index = 1; index < len; index++) {
			sum[index] = sum[index - 1] + a[index];
		}
		return sum;
	}

}
