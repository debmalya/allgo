/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class PositiveFrequency {
	public static int maximumPositiveFrequency(int[] input1, int input2) {
		// Write code here
		int change = 0;
		int prev = 0;
		for (int i = 0; i < input2; i++) {
			if (i > 0) {
				if (input1[i] > prev) {
					change += input1[i] - prev;
				}
			}
			prev = input1[i];
		}
		return change;
	}
}
