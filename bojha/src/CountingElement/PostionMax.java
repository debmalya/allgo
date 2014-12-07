package CountingElement;

import java.util.HashMap;
import java.util.Map;

public class PostionMax {
	public int solution(int[] A) {
		int N = A.length;
		Map<Integer, Integer> positionMap = new HashMap<>();

		int result = 0;

		for (int i = 0; i < N; i++) {
			Integer lastPosition = positionMap.get(A[i]);
			if (lastPosition != null) {
				result = Math.max(result, i - lastPosition);
			} else {
				positionMap.put(A[i], i);
			}
		}

		return result;
	}

	public int solution0(int[] A) {
		int N = A.length;
		int result = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (A[i] == A[j])
					result = Math.max(result, Math.abs(i - j));
		return result;
	}
}
