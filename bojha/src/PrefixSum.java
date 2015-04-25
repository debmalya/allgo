import java.util.Scanner;

/**
 * 
 */

/**
 * @author Debmalya Jash
 * 
 */
public class PrefixSum {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int noOfTestCases = Integer.parseInt(scanner.nextLine());
			int[] result = new int[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				result[i] = getIndex0(scanner.nextLine());
			}

			for (int i = 0; i < noOfTestCases; i++) {
				System.out.println(result[i]);
			}

		} catch (Throwable ignore) {

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	
	public static int getIndex0(String value) {
		String[] values = value.split(" ");
		int[] intValues = new int[values.length];
		int[] prefixSum = new int[values.length];
		int[] suffixSum = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			intValues[i] = Integer.parseInt(values[i]);
			prefixSum[i] += intValues[i];
			if (i < values.length - 1) {
				prefixSum[i + 1] = prefixSum[i];
			}
		}

		int min = values.length;
		for (int i = values.length - 1; i > -1; i--) {

			suffixSum[i] += intValues[i];

			if (i > 0) {
				if (suffixSum[i] == prefixSum[i - 1]) {
					return i - 1;
				} else if (prefixSum[0] == prefixSum[1]) {
					return 0;
				} else {
					for (int j = 0; j < i - 1; j++) {
						if (prefixSum[i - 1] - prefixSum[j] == suffixSum[i]) {
							min = Math.min(min, (i - 1));
						}
					}
				}
				suffixSum[i - 1] += suffixSum[i];
			}
		}

		if (min != values.length) {
			return min;
		}

		return 0;
	}
}
