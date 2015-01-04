package CountingElement;

import java.util.Arrays;

public class PermCheck {
	/**
	 * 
	 * @param A
	 * @return 1 if do not have any missing element, 0 otherwise.
	 */
	public int solution(int[] A) {
        // write your code in Java SE 8
		Arrays.sort(A);
		
		int prev = 0;
		for (int i = 0; i < A.length; i++) {
			
			if (i > 0 && (A[i] - prev != 1 || A[i] == prev)) {
				return 0;
			}
			prev = A[i];
		}
		return 1;
    }
}
