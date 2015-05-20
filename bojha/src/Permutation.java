import java.util.Scanner;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int noOfTestCases = scanner.nextInt();
			int[] inputs = new int[noOfTestCases];
			for (int i = 0;i < noOfTestCases; i++) {
				inputs[i] = scanner.nextInt();
			}
			for (int i = 0; i < noOfTestCases; i++) {
				processEachInput(inputs[i]);
				
			}
		} catch(Throwable ignore) {
			
		}

	}

	/**
	 * @param i
	 * @return
	 */
	public static void processEachInput(int length) {
		
		String letters = "abcdefghij";
		String actualLetters = letters.substring(0,length);
		
		StringBuilder out = new StringBuilder();
		boolean[] used = new boolean[actualLetters.length()];
		permute(length, actualLetters,used,out);
		
	}

	private static void permute(int length, String actualLetters,boolean[] used,StringBuilder out) {
		
		if (out.length() == length) {
			System.out.println(out);
		}
		
		for (int i = 0; i < length; i++) {
			if (used[i]) continue;
			out.append(actualLetters.charAt(i));
			used[i] = true;
			permute(length, actualLetters,used,out);
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}

}
