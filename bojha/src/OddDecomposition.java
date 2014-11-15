import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OddDecomposition {
	public int[] solution(int N) {
		// write your code in Java SE 8
		Set<Integer> r = getDecomposition(N);

		if (!check(N,r)) {
			r = new TreeSet<Integer>();
		}
		Integer[] re = r.toArray(new Integer[0]);
		int[] ret = new int[re.length];
		for (int i = 0; i < re.length; i++) {
			ret[i] = re[i];
		}
		return ret;
	}

	/*
	 * Whether sum matches the number or not.
	 */
	private boolean check(int N, Set<Integer> values) {
		Iterator<Integer> vi = values.iterator();
		Integer sum = 0;
		while (vi.hasNext()) {
			sum += vi.next();
		}
		return N == sum;
	}

	/**
	 * 
	 * @param N
	 * @return odd decompositions.
	 */
	private Set<Integer> getDecomposition(int N) {
		Set<Integer> r = new TreeSet<Integer>();
		
		while (N >= 1) {
			int n = (int)Math.sqrt(N);
			if (n % 2 == 0) {
			  n++;
			}
			
			if (r.add(n)){
			  N -= n;
			} else if (N % 2 == 1) {
				r.add(N);
				N = 0;
			} else {
				r.add(N -1);
				N = 1;
			}
		}
		return r;
	}
}
