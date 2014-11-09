/**
 * 
 */

/**
 * @author debmalya jash
 * 
 */
public class Target {

	/**
	 * @param n
	 *            is an integer of form 4k+1 and will be between 5 and 49,
	 *            inclusive.
	 * @return String array containing character either with "#" or " ".
	 * 
	 *         Time complexity = O(n/2)
	 * 
	 *         Space Complexity : String array of size n + two character array
	 *         of size n.
	 */
	public String[] draw(final int n) {
		// input validation
		if (n % 4 != 1) {
			throw new IllegalArgumentException(
					"Passed integer must be of form 4K+1");
		}

		if (n < 5 || n > 49) {
			throw new IllegalArgumentException(
					"Passed integer be between 5 and 49, inclusive.");
		}

		// Valid input processing
		String[] result = new String[n];

		int mid = n / 2;
		String[] rows = getMiddleNLastRow(n);

		result[mid] = rows[0];
		result[0] = rows[1];
		result[n - 1] = rows[1];

		char[] oddString = result[mid].toCharArray();
		char[] evenString = result[0].toCharArray();

		for (int i = 1; i < mid; i++) {
			if (i % 2 == 1) {
				// Odd - Remove "#" from the odd string

				if (i == 1) {
					// Start from middle
					oddString[mid] = ' ';

				} else {
					oddString[mid - i + 1] = ' ';
					oddString[mid + i - 1] = ' ';
				}
				result[mid - i] = String.valueOf(oddString);
				result[mid + i] = String.valueOf(oddString);
			} else {
				// Even - Remove "#" from even string
				evenString[i - 1] = ' ';
				evenString[n - i] = ' ';
				result[i] = String.valueOf(evenString);
				result[n - i - 1] = String.valueOf(evenString);
			}
		}

		return result;
	}

	/**
	 * @param n
	 *            - Passed input number. -
	 * @return - middle row and first row. Last row is same as middle row.
	 * 
	 *         Time complexity - Length of the string - O(n). Space complexity -
	 *         Number of characters in the String * 4.
	 */
	public String[] getMiddleNLastRow(int n) {
		StringBuilder middleRow = new StringBuilder(n);
		StringBuilder lastRow = new StringBuilder(n);
		for (int i = 0; i < n; i += 2) {
			middleRow.append("#");
			lastRow.append("#");
			if (i < n - 1) {
				middleRow.append(" ");
				lastRow.append("#");
			}
		}
		String[] rows = new String[] { middleRow.toString(), lastRow.toString() };
		return rows;
	}
}
