/**
 * 
 */
package ht;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class FormatHTMLCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			int numberOfCharacters = scanner.nextInt();
			System.out.println(EncodeHtml(input, numberOfCharacters));
		}

	}

	/**
	 * @param input
	 * @return
	 */
	public static String EncodeHtml(String input, int numberOfCharacters) {
		int i = 0;
		String result = input.substring(0,numberOfCharacters);
		// Anything comes with <..> must be terminated by </..>.
		boolean startTag = false;
		boolean endTag = false;

		List<String> htmlElements = new ArrayList<String>();
		String eachElement = "";
		while (i < numberOfCharacters) {

			if (result.charAt(i) == '<') {
				// something started.
				startTag = true;
			} else if (result.charAt(i) == '>') {
				if (startTag) {
					startTag = false;
					htmlElements.add(eachElement);

				}
				if (endTag) {
					htmlElements.remove(eachElement);
					// p,b eachElement without “<” “>” these characters.
					endTag = false;
				}
				eachElement = "";
			} else if (result.charAt(i) == '/' && i > 0
					&& result.charAt(i - 1) == '<') {
				// found matching tag
				startTag = false;
				endTag = true;

			} else if (startTag || endTag) {
				eachElement += result.charAt(i);
			}

			i++;

		}
		// now htmlElement will have entries not ended properly. p,i
		// first entry is p
		// last entry is i.
		// <p>The <b>quick</b> brown <i>f
		for (int j = htmlElements.size() - 1; j > -1; j--) {
			result += "</" + htmlElements.get(j) + ">";
		}
		// </i> and </p> will be added in the result.
		// result = <p>The <b>quick</b> brown <i>f</i></p>
		return result;
	}

}
