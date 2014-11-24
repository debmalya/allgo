package CountingElement;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Get minimum  positive integer which is not present in this array.
 * Still it has some problem, does not work well with negative integer. Tomorrow will fix it.
 */
public class MissingInteger {
	public int solution(int[] A) {
		// write your code in Java SE 8
		SortedSet<Integer> uniqueSortedSet = new TreeSet<>();

		if (A != null) {
			int size = A.length;
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					if (A[i] > 0) {
						uniqueSortedSet.add(A[i]);
					}
				}

				Iterator<Integer> uniqueIterator = uniqueSortedSet.iterator();
				Integer previous = null;
				Integer minimum = null;
				Integer current = null;

				while (uniqueIterator.hasNext()) {
					current = uniqueIterator.next();
					if (minimum == null) {
						minimum = current - 1;
					}
					if (previous != null
							&& Math.abs(((long) current - (long) previous)) > 1) {
						if (previous + 1 < 0 || previous == Integer.MAX_VALUE) {
							previous = 0;
						}
						return previous + 1;
					}
					previous = current;
				}
				if (current == null) {
					current = 0;
				}
				if  (current < 0 || current == Integer.MAX_VALUE){
					current = 0;
				}
				return current + 1;
			}
		}
		return 1;
	}
}
