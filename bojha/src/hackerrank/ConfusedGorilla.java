/**
 * 
 */
package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class ConfusedGorilla {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int noOfTestCase = scanner.nextInt();
			int[] inputs = new int[noOfTestCase];

			for (int i = 0; i < inputs.length; i++) {
				inputs[i] = scanner.nextInt();
			}
			
			List<String> resultList = getPossibleSteps(inputs);
			for (String each:resultList){
				System.out.println(each);
			}
		} catch (Throwable ignore) {

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	/**
	 * @param inputs
	 * @return
	 */
	public static List<String> getPossibleSteps(int[] inputs) {
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < inputs.length; i++) {
			resultList.add("0 "+inputs[i]);
			resultList.add(inputs[i]+" 0");
			
			for (int j = 1; j < inputs[i]; j++) {
				resultList.add(j+" "+(inputs[i] - j));
			}
			
		}
		return resultList;
	}

}
