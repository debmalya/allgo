public class EquilibriumIndex {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int r = 0;

		
		if (A != null && A.length > 1) {
			int size = A.length;
			long[] s = new long[size];
			
			// prefix sum
			for (int i = 0; i < size; i++) {
				if (i > 0) {
					s[i] = s[i - 1] + A[i];
				} else {
					s[i] = A[i];
				}
			}
			
			for (int i = 1; i < size; i++) {
				if (s[i - 1] == s[size - 1] - s[i]) {
					return i;
				}
			}

		}

		return r;
	}
}
