/**
 * 
 */
package hr;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Debmalya
 *
 */
public class Friday {

	/**
	 * 
	 */
	private static final int TWENTY_EIGHT_DAY = 60 * 1000 * 60 * 60 * 24 * 28;

	/**
	 * Some superstitious people believe that Friday the 13th is a day that is
	 * very unlucky.
	 * 
	 * However, Sergey does not agree with them. In order to prove this to
	 * people that nothing scary will happen, he wants to choose two dates and
	 * count the number of Friday the 13th's between them. If this number is
	 * reasonably large, he will be able to tell that it is just a regular day.
	 * 
	 * But now Sergey is quite busy, so he is unable to calculate the number of
	 * Friday the 13th's between the specific dates. Could you write a program
	 * that will do it for him?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// The first line of input consists of a single integer, T, denoting
			// the number of test cases. Then, there are T lines describing the
			// test cases.
			int numberOfTestCases = scanner.nextInt();
			scanner.nextLine();
			// The first (and only) line of a test case contains six single
			// space-separated integers D1, M1, Y1, D2, M2, and Y2, denoting two
			// dates in the DD MM YYYY format. It is guaranteed that they
			// describe two existing dates and the first date is not later than
			// the second one.
			String[] inputs = new String[numberOfTestCases];
			int[] outputs = new int[numberOfTestCases];
			for (int i = 0; i < numberOfTestCases; i++) {
				inputs[i] = scanner.nextLine();
				outputs[i] = process(inputs[i]);
			}

			for (int each : outputs) {
				System.out.println(each);
			}
		}

	}

	/**
	 * @param string
	 *            contains six single space-separated integers D1, M1, Y1, D2,
	 *            M2, and Y2, denoting two dates in the DD MM YYYY format. It is
	 *            guaranteed that they describe two existing dates and the first
	 *            date is not later than the second one.
	 * @return output the number of Fridays the 13th's on a separate line.
	 * 
	 *         1900≤Y1≤Y2≤9999 D1,M1,Y1 describing a correct date D2,M2,Y2
	 *         describing a correct date The date described by D1,M1,Y1 is not
	 *         later than the date described by D2,M2,Y2.
	 */
	public static int process(String string) {
		String[] values = string.split(" ");

		GregorianCalendar calendar1 = new GregorianCalendar();
		GregorianCalendar calendar2 = new GregorianCalendar();

		int blackFriday = 0;

		for (int i = 0; i < values.length; i++) {
			switch (i) {
			case 0:
				calendar1.set(GregorianCalendar.DATE,
						Integer.parseInt(values[i]));
				break;
			case 1:
				calendar1.set(GregorianCalendar.MONTH,
						Integer.parseInt(values[i]) - 1);
				break;
			case 2:
				calendar1.set(GregorianCalendar.YEAR,
						Integer.parseInt(values[i]));
				break;
			case 3:
				calendar2.set(GregorianCalendar.DATE,
						Integer.parseInt(values[i]));
				break;
			case 4:
				calendar2.set(GregorianCalendar.MONTH,
						Integer.parseInt(values[i]) - 1);
				break;
			case 5:
				calendar2.set(GregorianCalendar.YEAR,
						Integer.parseInt(values[i]));
				break;
			default:
				break;
			}
		}

		GregorianCalendar calendar = calendar1;
		blackFriday = getNumberOfBlackFridays(calendar1, calendar2, blackFriday);
		return blackFriday;
	}

	private static int getNumberOfBlackFridays(GregorianCalendar calendar1,
			GregorianCalendar calendar2, int blackFriday) {
		while (calendar1.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.FRIDAY) {
			calendar1.add(GregorianCalendar.DATE, 1);
		}

		
		
		while (!calendar1.after(calendar2)) {
			if (calendar1.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.FRIDAY
					&& calendar1.get(GregorianCalendar.DAY_OF_MONTH) == 13) {
				blackFriday++;
				calendar1.add(GregorianCalendar.DAY_OF_MONTH, 28);
			} else {

				calendar1.add(GregorianCalendar.DAY_OF_MONTH, 7);
			}

		}
		return blackFriday;
	}

	
}

