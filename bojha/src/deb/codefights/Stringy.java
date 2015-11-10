/**
 * 
 */
package deb.codefights;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class Stringy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	static boolean gHappy(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'g') {
				int o = 0;
				if (i < str.length() - 1 && str.charAt(i + 1) == 'g') {
					o = 1;
				} else if (i > 0 && str.charAt(i - 1) == 'g') {
					o = 1;
				}
				if (o == 0)
					return false;
			}
		}
		return true;
	}

	/**
	 * Find the first character that appears more than 1 time in the given
	 * string and return all appearances of this character. If no character
	 * appears in the string more than once, return "".
	 * 
	 * Example
	 * 
	 * FindTheSame("AaabbcAdeefAA") = "AAAA" FindTheSame("abcdDcefDDD") = "cc"
	 * [input] string s
	 * 
	 * A string consisting of Latin letters. [output] string
	 * 
	 * 
	 * @param s
	 * @return
	 */
	static String FindTheSame(String s) {

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (s.lastIndexOf(c) > i)
				return s.replaceAll("[^" + c + "]", "");

		}

		return "";
	}

	static String FindTheSame0(String s) {
		HashMap<Character, Integer> o = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer v = o.get(c);
			if (v == null) {
				v = 0;
			}
			v++;
			o.put(c, v);
		}

		Set<Entry<Character, Integer>> oe = o.entrySet();
		Iterator<Entry<Character, Integer>> oei = oe.iterator();
		while (oei.hasNext()) {
			Entry<Character, Integer> nextEntry = oei.next();
			if (nextEntry.getValue() > 0) {
				return s.replaceAll("[^" + nextEntry.getKey() + "]", "");
			}
		}
		return "";
	}

	/**
	 * You are given a string. Your task is to find the number of vowels that
	 * are places between two consonants. The following letters are vowels: 'a',
	 * 'e', 'i', 'o', 'u' (and their uppercase versions).
	 * 
	 * Example:
	 * 
	 * PlayfulVowel("How are you?") = 1
	 * 
	 * The only vowel between two consonants is 'o' at the 1st position
	 * (0-based).
	 * 
	 * [input] string characters
	 * 
	 * [output] integer
	 * 
	 * @param characters
	 * @return
	 */
	int PlayfulVowel(String characters) {
		characters = characters.toLowerCase();

		int r = 0;
		for (int i = 1; i < characters.length(); i++) {
			char c = characters.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				if (i + 1 < characters.length()) {
					char p = characters.charAt(i - 1);
					char n = characters.charAt(i + 1);
					if (p != 'a' && p != 'e' && p != 'o' && p != 'i'
							&& p != 'u' && n != 'a' && n != 'e' && n != 'o'
							&& n != 'i' && n != 'u' && n != ' ' && p != ' ') {

						r++;
					}
				}

			}
		}
		return r;

	}
}
