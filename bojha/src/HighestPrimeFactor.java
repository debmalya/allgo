import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HighestPrimeFactor {

	public HighestPrimeFactor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getHighestPrimeFactor(600851475143L));
		System.out.println(getHighestPrimeFactor(6857));
	}

	public static long getHighestPrimeFactor(long value) {
		long divisor = 2L;
		while (value > 1) {
			while (value % divisor == 0) {
				value /= divisor;
			}
			if (value > 1) {
				divisor += 1;
			}
			if (divisor * divisor > value) {
				divisor = value;
				break;
			}
		}
		return divisor;
	}

	public static List<Long> getPrimeFactorList(long value) {
		long divisor = 2L;
		List<Long> factors = new ArrayList<Long>();
		while (value > 1) {
			while (value % divisor == 0) {
				value /= divisor;
				factors.add(divisor);
			}
			if (value > 1) {
				divisor += 1;
				if (divisor * divisor > value) {
					divisor = value;
					factors.add(divisor);
					break;
				}
			}
			
		}
		return factors;
	}

	public static long lcd0(long... values) {
		long result = 1;

		Set<Long> uniqueSet = new HashSet<Long>();
		
		for (long eachValue : values) {
			long divisor = 2L;
			
			while (eachValue > 1) {
				while (eachValue % divisor == 0) {
					eachValue /= divisor;
					if (uniqueSet.add(divisor)) {
						result *= divisor;
					}
				}
				if (eachValue > 1) {
					divisor += 1;
				}
				if (divisor * divisor > eachValue) {
					divisor = eachValue;
					if (uniqueSet.add(divisor)) {
						result *= divisor;
					}
					break;
				}
			}
		}
		return result;
	}
	
	public static long lcd(long... values) {
		long max = 2L;
		for (long each:values) {
			max = Math.max(max, each);
		}
		
		while (true) {
			for (int i = 0; i < values.length; i++) {
				if (max % values[i] != 0) {
					max++;
					i = 0;
					continue;
				}
			}
			return max;
		}
		
		
		
	}
}
