/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class Mostafa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Define a T_Prime number as a number that has exactly 3 distinct divisors.
	 * For example, 4 is a T_Prime number, since its only divisors are 1, 2 and
	 * 4.
	 * 
	 * My friends Amr and Farag left the classes and started to play
	 * hide-and-seek in the college. Amr can search in 5 places, identified by
	 * some numbers. Since Farag is an intelligent person, he hides only in
	 * places identified by the T_Prime numbers. If Amr searches a place
	 * identified by the T_Prime number, he finds Farag and wins.
	 * 
	 * Given the identifier of the places Amr searched in, determine if he found
	 * Farag, i.e. if there is a place identified by the T_Prime number he
	 * searched in.
	 * 
	 * Example:
	 * 
	 * HideGame([1 , 3 , 4 , 5 , 6]) = "Amr", since 4 is a T_Prime number.
	 * HidGame([15 , 100 , 20 , 3 , 2]) = "Farag", since Amr didn't search in
	 * the room marked by a T_Prime number, so he lost. [input] array.integer
	 * identifiers
	 * 
	 * Array of length 5, identifiers of the places to search in. [output]
	 * string
	 * 
	 * "Amr" if Amr finds Farag, "Farag" otherwise.
	 * 
	 * @param identifiers
	 * @return
	 */
	static String HideGame(int[] identifiers) {
		for (int i = 0; i < identifiers.length; i++) {
			if (d(identifiers[i]) == 1) {
				return "Amr";
			}
		}
		return "Farag";
	}

	static int d(int n) {
		int c = 0;
		for (int i = 2; i <= n /2; i++) {
			if (n % i == 0) {
				c++;
				if (c > 1) return 2;
			}
		}
		return c;
	}

}
