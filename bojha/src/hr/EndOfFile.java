/**
 * 
 */
package hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class EndOfFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> inputs = new ArrayList<String>();
			while (true) {
				String line = scanner.nextLine();
				if (line != null && line.trim().length() > 0) {
					inputs.add(line);
				} else {
					break;
				}
			}

			for (int i = 0; i < inputs.size(); i++) {
				System.out.println((i+1) + " " + inputs.get(i));
			}
		}

	}

}
