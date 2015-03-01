import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MovingNQueens {

	public MovingNQueens() {
		Scanner scanner = null;
		System.err.println("Hello Deb");
		try {
			scanner = new Scanner(System.in);
			int noOfQueens = scanner.nextInt();

			int[] queenRows = new int[noOfQueens];

			for (int i = 0; i < noOfQueens; i++) {
				queenRows[i] = scanner.nextInt();
			}

			noOfQueens = scanner.nextInt();
			int[] queenCols = new int[noOfQueens];

			for (int i = 0; i < noOfQueens; i++) {
				queenCols[i] = scanner.nextInt();
			}

			String[] ret = rearrange(queenRows, queenCols);

			System.out.println(ret.length);

			for (int i = 0; i < ret.length; i++) {
				System.out.println(ret[i]);
			}

			System.out.flush();

		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/**
	 * Given the coordinates of N chess queens placed on an infinite chess
	 * board. Goal is to make some valid minimized moves to rearrange the queens
	 * so that in the end no two queens threaten each other. (i.e. no two queens
	 * share the same row, column or diagonal)
	 * 
	 * @param queenRows
	 *            row (Y) coordinates of the queens.
	 * @param queenCols
	 *            column (X) coordinates of the queens.
	 * @return list of moves as a String[]. We can use at most 8*N moves. Each
	 *         element of the return should be formatted as "INDEX ROW COL".
	 *         Corresponding move will move queen INDEX (0-based) from its
	 *         current position to a cell with coordinates (ROW,COL). Each move
	 *         must be valid chess queen move: the queen can be moved any number
	 *         of unoccupied squares in a straight line vertically, horizontally
	 *         or diagonally.
	 * 
	 *         Time limit is 10 seconds
	 * 
	 */
	public static String[] rearrange(int[] queenRows, int[] queenCols) {

		System.err.println("queenRows :" + queenRows.length + " queenCols :"
				+ queenCols.length);

		int noOfQueens = queenRows.length;

		Map<Integer, List<Integer>> rowMap = new HashMap<Integer, List<Integer>>();
		Map<Integer, List<Integer>> colMap = new HashMap<Integer, List<Integer>>();

		List<String> results = new ArrayList<String>(noOfQueens);
		// SortedSet<Integer> queenPositions = new TreeSet<Integer>();
		int preferred_row = -1;
		int preferred_col = -1;

		for (int i = 0; i < noOfQueens; i++) {
			List<Integer> colOccupiedInTheRow = rowMap.get(queenRows[i]);
			List<Integer> rowOccupiedInTheCol = colMap.get(queenCols[i]);

			if (colOccupiedInTheRow == null) {
				colOccupiedInTheRow = new ArrayList<Integer>();
			}

			if (rowOccupiedInTheCol == null) {
				rowOccupiedInTheCol = new ArrayList<Integer>();
			}

			rowOccupiedInTheCol.add(queenRows[i]);
			colOccupiedInTheRow.add(queenCols[i]);

			rowMap.put(queenRows[i], colOccupiedInTheRow);
			colMap.put(queenCols[i], rowOccupiedInTheCol);

		}
		System.err.println(rowMap);

		if (!rowMap.isEmpty()) {
			Set<Entry<Integer, List<Integer>>> rowSet = rowMap.entrySet();
			Iterator<Entry<Integer, List<Integer>>> rowSetIterator = rowSet
					.iterator();

			while (rowSetIterator.hasNext()) {
				Entry<Integer, List<Integer>> nextEntry = rowSetIterator.next();
				if (nextEntry.getValue().size() > 1) {

				}
			}

		}

		return results.toArray(new String[0]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
