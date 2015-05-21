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
public class Main {

		public static void main(String[] args) {
			Scanner scanner = null;
			try {
				scanner = new Scanner(System.in);
				int noOfTestCases = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < noOfTestCases; i++) {
					int noOfPoints = Integer.parseInt(scanner.nextLine());
					List<String> pointList = new ArrayList<String>();
					for (int j = 0; j < noOfPoints; j++) {
						pointList.add(scanner.nextLine());
					}
				}
			}catch(Throwable th) {
				
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
}
