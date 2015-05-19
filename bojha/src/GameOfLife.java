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
public class GameOfLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> till42 = new ArrayList<Integer>();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				int value = scanner.nextInt();

				if (value != 42) {
					till42.add(value);
				} else {
					break;
				}
			}
			
			for (int i = 0; i < till42.size(); i++) {
				System.out.println(till42.get(i));
			}
			till42.clear();

		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		}

	}

}
