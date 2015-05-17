import java.util.Scanner;


/**
 * @author Debmalya Jash
 * 
 */
public class PrefixSum {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int noOfTestCases = Integer.parseInt(scanner.nextLine());
			int[] result = new int[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				result[i] = getIndex0(scanner.nextLine());
			}

			for (int i = 0; i < noOfTestCases; i++) {
				System.out.println(result[i]);
			}

		} catch (Throwable ignore) {

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * 
	 * @param arr String containing integer, each integer is separated by space.
	 * @return index where sum of earlier indexes are equal to sum of later indexes.
	 * 
	 * e.g. for the input 2 3 1 6
	 * at index 2, sum of earlier indexes 2+3+1 = 6
	 * here we have to return 2.
	 * 
	 * If there is no such index return 0.
	 * 
	 */
	public static int getIndex0(String arr) {
		
		int[][] sum = getSum(arr);
		
		
		for (int i = 0; i < sum[0].length - 1; i++) {
			if (sum[0][i] == sum[1][i + 1]) {
				return i;
			} else {
				for (int j = 0; j < i; j++) {
					if ((sum[0][i] - sum[0][j])== sum[1][i + 1]) {
						return i;
					}
				}
			}
		}
		return 0;
	}

	/**
	 * Returns prefix sum and suffix sum.
	 * @param value string containing numbers each number is separated by space.
	 * @return prefix and suffix sum
	 * if int arr is 1 2 3 4
	 * it will return first element as prefix
	 * 1 1+2 1+2+3 1+2+3+4
	 * 1 3 6 10
	 * 
	 * second element as suffix sum
	 * 1+2+3+4 2+3+4 3+4 4
	 * 10 9 7 4
	 */
	public static int[][] getSum(String value){
		int[][] sum = null;
		String[] arr = value.split(" ");
		if (arr != null ) {
			int maxLen = arr.length - 1;
			
			sum = new int[2][];
			sum[0] = new int[arr.length];
			sum[1] = new int[arr.length];
			
			for (int i = 0; i < arr.length; i++) {
				sum[0][i] += Integer.parseInt(arr[i]);
				sum[1][maxLen - i] += Integer.parseInt(arr[maxLen - i]);
				if (i < maxLen) {
					sum[0][i + 1] += sum[0][i]; 
					sum[1][maxLen - i - 1] += sum[1][maxLen - i];
				}
			}
		}
		return sum;
		
	}
	
	
}
