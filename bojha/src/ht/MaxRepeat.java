package ht;

import java.util.Scanner;

public class MaxRepeat {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases = 0;
		String[] inputs = null;
		try {
			noOfTestCases = Integer.parseInt(scanner.nextLine());

			inputs = new String[noOfTestCases];
			StringBuilder eachInput = new StringBuilder();
			for (int i = 0; i < noOfTestCases; i++) {
				int noOfChars = Integer.parseInt(scanner.nextLine());

				for (int j = 0; j < noOfChars; j++) {
					eachInput.append(scanner.nextLine());
				}
				inputs[i] = eachInput.toString();
				eachInput.delete(0, eachInput.length());
			}
		} catch (Throwable th) {
			System.err.println("ERR : " + th.getMessage());
		} finally {
			scanner.close();
		}

		

		for (int i = 0; i < noOfTestCases; i++) {
			String[] without_a = inputs[i].split("a");

			String[] without_b = inputs[i].split("b");
			
			

			System.out.println(Math.max(getMaxRepeat(without_a),
					getMaxRepeat(without_b)));
		}

	}

	public static int getMaxRepeat(String[] string) {
		int r = 0;
		String prev = "";
		int current = 2;

		for (int i = 0; i < string.length; i++) {

			if (i > 0 && prev.equals(string[i])) {
				++current;
				r = Math.max(r, current);
			} else {
				current = 2;
			}

			prev = string[i];
		}
		return r;
	}

}
