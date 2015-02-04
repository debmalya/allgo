package deb.algo;

import java.util.Scanner;

/**
 * 
 * @author debmalyajash
 * Accepts user input for number of test cases.
 * For each test case accepts number of characters (range 1 - 10)
 * Then permutes the characters.
 * 
 * e.g. if number of character is 1, then output is a.
 * if number of character is 2, then outout is ab,ba.
 * if number of character is 3, then output is abc,acb,bca,bac,cab,cba.
 */
public class Permute {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String mainString = "abcdefghij";
		try {
			int noOfTestCases = scanner.nextInt();

			String[] inputs = new String[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				int noOfChars = scanner.nextInt();
				inputs[i] = mainString.substring(0, noOfChars);
			}
			
			processInputs(inputs);
		} catch (Throwable th) {

		} finally {
			scanner.close();
		}
	}

	public static void processInputs(String[] inputs) {
		for (String each: inputs) {
			processEach(each);
		}
		
	}

	public static void processEach(String each) {
		permute(each);
		
	}

	public static void permute(String each) {
		Permutation permutation = new Permutation(each);
		permutation.permute();
		
		
	}
	
	
}

class Permutation {
	String in;
	StringBuilder out = new StringBuilder();
	boolean[] used = null;

	public Permutation(String in) {
		super();
		this.in = in;
		used = new boolean[in.length()];
	}
	
	public void permute() {
		if (in.length() == out.length()) {
			System.out.println(out);
			return;
		}
		
		for (int i =0; i < in.length(); i++) {
			if (used[i]) {
				continue;
			}
			
			out.append(in.charAt(i));
			used[i]=true;
			permute();
			
			used[i]=false;
			out.setLength(out.length()-1);
//			out.delete(0,out.length()-1);
			
		}
	}

}

