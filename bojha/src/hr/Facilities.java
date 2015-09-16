package hr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Facilities {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfFacilities = scanner.nextInt();
			scanner.nextLine();

			String[] facilities = new String[numberOfFacilities];
			for (int i = 0; i < numberOfFacilities; i++) {
				facilities[i] = scanner.nextLine();
			}

			StringBuilder hotelDescription = new StringBuilder();
			try {
				while (true) {
					String description = scanner.nextLine();
					if (description != null && description.trim().length() > 0) {
						hotelDescription.append(description);
					} else {
						break;
					}
				}
			} catch (Throwable th) {
				// ignore
			}

			String completeDescription = hotelDescription.toString()
					.toLowerCase();
			List<String> matching = new ArrayList<String>();

			for (String key : facilities) {
				String converted = key.toLowerCase();
				if (completeDescription.contains(converted)) {
					matching.add(key);
				}
			}
			Collections.sort(matching);

			for (String each : matching) {
				System.out.println(each);
			}
		}

	}

}
