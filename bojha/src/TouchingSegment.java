import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class TouchingSegment {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int noOfTestCases = Integer.parseInt(scanner.nextLine());
			int[] result = new int[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				int noOfStraigthLines = Integer.parseInt(scanner.nextLine());
				String[] straightLines = new String[noOfStraigthLines];
				for (int j = 0; j < noOfStraigthLines; j++) {
					straightLines[j] = scanner.nextLine();
				}
				result[i] = getNumberOfLines(straightLines);
			}

			for (int i = 0; i < noOfTestCases; i++) {
				System.out.println("Case " + (i + 1) + ": " + result[i]);
			}
		} catch (Throwable th) {
			System.err.println(th.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	public static int getNumberOfLines(String[] straightLines) {
		int result = 0;
		SortedSet<StraightLine> straightLineSet = new TreeSet<StraightLine>();
		TouchingSegment me = new TouchingSegment();
		for (int i = 0; i < straightLines.length; i++) {
			StraightLine sl = me.new StraightLine(straightLines[i]);
			straightLineSet.add(sl);
		}
		Iterator<StraightLine> iterator = straightLineSet.iterator();
		StraightLine firstConectedLine = null;
		int lineNo = 0;
		while (iterator.hasNext()) {

			StraightLine nextLine = iterator.next();
			if (firstConectedLine != null
					&& firstConectedLine.canBeConnected(nextLine)) {
				result++;
			} else {
				firstConectedLine = nextLine;

				if (lineNo >= 2) {
					break;
				}
				result++;
				lineNo++;
				
			}
		}
		return result;
	}

	public class StraightLine implements Comparable<StraightLine> {
		int start;
		int end;

		@Override
		public int compareTo(StraightLine o) {

			if (start > o.start) {
				return 1;
			} else if (start == o.start) {
				if (end > o.end) {
					return -1;
				} else if (end < o.end) {
					return 1;
				}
				return 0;
			} else {
				return -1;
			}
		}

		public boolean canBeConnected(StraightLine o) {
			return end >= o.start;
		}

		public StraightLine(String value) {
			String[] values = value.split(" ");
			start = Integer.parseInt(values[0]);
			end = Integer.parseInt(values[1]);
		}

		@Override
		public String toString() {
			return "[" + start + ", " + end + "]";
		}

	}
}
