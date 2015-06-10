import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Task3 {
	int count = 0;

	public int solution(int[] A) {
		// write your code in Java SE 8
		Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
		Set<Integer> duplicates = new HashSet<Integer>();
		count = 0;

		int j = A.length - 1;
		for (int i = 0; i <= j; i++, j--) {
			set(A, m, i, duplicates);
			if (i != j) {
				set(A, m, j, duplicates);
			}
		}

		return count;
	}

	private void set(int[] A, Map<Integer, List<Integer>> m, int i,
			Set<Integer> val) {
		boolean isDupli = false;
		if (!val.add(A[i])) {
			// duplicate
			isDupli = true;
		}

		List<Integer> r = m.get(A[i]);
		if (r == null) {
			r = new ArrayList<Integer>();
		}

		if (isDupli) {
			count += r.size();
		}
		r.add(i);
		m.put(A[i], r);

	}
}
