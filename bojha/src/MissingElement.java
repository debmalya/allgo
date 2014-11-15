import java.util.Arrays;

public class MissingElement {
	/*
	 * A zero-indexed array A consisting of N different integers is given. The
	 * array contains integers in the range [1..(N + 1)], which means that
	 * exactly one element is missing. Your goal is to find that missing
	 * element.
	 */
	public int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);

		int size = A.length;
		int result = 1;
		if (A != null && A.length > 0) {
			result = A[size - 1] + 1;
			for (int i = 0; i < size; i++) {
				if (A[i] != i + 1) {
					result = i + 1;
					break;
				}
			}
		}
		return result;
	}
}
