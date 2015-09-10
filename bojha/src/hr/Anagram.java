/**
 * 
 */
package hr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Anagram {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner in = new Scanner(System.in);
		String src = (in.nextLine());
		String tar = in.nextLine();
		int length = 0;
		Map<Character, Integer> an = new HashMap<Character, Integer>();

		int i = 0;
		for (; i < src.length(); i++) {
			char c = src.charAt(i);
			if (an.containsKey(c))
				an.put(c, an.get(c) + 1);
			else
				an.put(c, 1);
		}

		int j = 0;
		for (; j < tar.length(); j++) {
			char c = tar.charAt(j);
			if (an.containsKey(c) && an.get(c) != 0) {
				an.put(c, an.get(c) - 1);
				length += 2;
			}

		}

		System.out.println(i+j-length);

	}
}
