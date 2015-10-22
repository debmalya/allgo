/**
 * 
 */
package deb.codefights;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class HammingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i : hammSeq(1500))
			       System.out.println(" " + i);
		System.out.println("Thanks");

	}

	
	public static int[] hammSeq(int aLen) {
		int seq[] = new int[aLen];
		int i, i2, i3, i5, x, x2, x3, x5;

		seq[0] = 1;
		i = 0;
		x = 1;
		i2 = i3 = i5 = -1;
		x2 = 2;
		x3 = 3;
		x5 = 5;
		while (++i < aLen) {
			seq[i] = x = (x2 <= x3 && x2 <= x5) ? x2 : (x3 <= x5) ? x3 : x5;
			while (x2 <= x)
				x2 = 2 * seq[++i2];
			while (x3 <= x)
				x3 = 3 * seq[++i3];
			while (x5 <= x)
				x5 = 5 * seq[++i5];
		}
		return seq;
	}

	/**
	 * A number is called a Hamming number if its largest prime divisor doesn't
	 * exceed 5. Example: 10, 20, 96 etc.. are Hamming numbers, while 7, 22
	 * aren't. . Given a number N determine whether phi(N) is a Hamming number
	 * or not. Brace yourself. This is just a break and a preparation for the
	 * 3rd part - which will be the hardest! . Spoiler alert:
	 * Hamming_number_part3 will be: how many number <= N that phi(N) is a
	 * Hamming number?
	 * 
	 * [input] string N
	 * 
	 * 0 < N < 1012. [output] integer
	 * 
	 * 1 if phi(N) is a Hamming number, 0 otherwise.
	 * 
	 * @param N
	 * @return
	 */
	int Hamming_number_part2(String N) {
	


		int[] d = new int[] { 2, 3, 5 };
		long i = Long.parseLong(N);

		if (i < 1)
			return 0;

		int j = 1;
		for (long e : d) {
			while (i % e == 0) {
				e = (long)Math.pow(e,j);
				i /= e;
			}
		}

		return i == 1 ? 1 : 0;
	}

	int Hamming_number_part22(String N) {
		BigInteger b = new BigInteger(N);
		if (b.longValue() > 5L && b.isProbablePrime(Integer.MAX_VALUE)) {
			return 0;
		}

		BigInteger i = new BigInteger("2");
		BigInteger h = new BigInteger("5");

		while (b.compareTo(BigInteger.ONE) > 0) {
			boolean f = true;
			while (b.mod(i).compareTo(BigInteger.ZERO) == 0) {
				b = b.divide(i);
				if (f && i.compareTo(h) > 0) {
					return 0;
				}
				f = false;

			}
			i = i.add(BigInteger.ONE);
		}

		return 1;
	}

	int Hamming_number_part21(String N) {
		long l = Long.parseLong(N);

		long c = l;
		long i = 2L;

		while (c > 1) {
			while (c % i == 0) {
				c /= i;
				System.out.println(i);
				if (i > 5) {
					return 0;
				}
			}
			i++;

		}

		return 1;
	}

	public int Hamming_number_part20(String N) {

		long l = Long.parseLong(N);
		long c = l;
		for (int i = 2; i <= l / 2; i++) {

			if (c % i == 0) {
				if (i > 5) {
					return 0;
				}
				c /= i;
				i--;

			}
		}

		return 1;
	}

}
