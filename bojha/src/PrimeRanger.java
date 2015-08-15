import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class PrimeRanger {

	/**
	 * 
	 */
	private static final int THREE = 3;
	/**
	 * 
	 */
	private static final int TWO = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int noOfTestCases = Integer.parseInt(scanner.nextLine());
			
			int max = 0;
			Input[] inputs = new Input[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				inputs[i] = new Input(scanner);
				max = Math.max(max, inputs[i].max);
			}
			
			max++;
			
			List<Integer> primeList = new ArrayList<Integer>(100000);
			primeList.add(TWO);
			
			for (int prime = THREE; prime < max; prime++) {
				primeList(prime,primeList);
			}
			
			for (int i = 0; i < noOfTestCases; i++) {
				printPrimes(inputs[i].min,inputs[i].max,primeList);
				System.out.println();
			}
			
		}catch(Throwable th) {
			System.err.println("ERR :");
		} finally {
			
		}

	}

	/**
	 * @param min
	 * @param max
	 * @param primeList
	 */
	private static void printPrimes(int min, int max, List<Integer> primeList) {
		for (Integer each:primeList) {
			if (each >= min && each <= max) {
				System.out.println(each);
			}
		}
		
	}

	static class Input {
		int min;
		int max;
		public Input(Scanner scanner) {
			String[] values = scanner.nextLine().split(" ");
			min = Integer.parseInt(values[0]);
			max = Integer.parseInt(values[1]);
		}
	}
	
	/**
	 * 
	 * @param num
	 * @param primeList
	 */
	public static void primeList(int num, List<Integer> primeList) {
		for (int i = 0; i < primeList.size(); i++) {
			if (primeList.get(i) > Math.sqrt(num)) {
				break;
			}
			if (num % primeList.get(i) == 0 ) {
				return;
			}
			
		}
		
		primeList.add(num);
	}
}
