/**
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class PegJumping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int M = Integer.parseInt(scanner.nextLine());
			int[] pegValue = new int[M];
			int i = 0;
			for (i = 0; i < M; i++) {
				pegValue[i] = Integer.parseInt(scanner.nextLine());
			}

			int N = Integer.parseInt(scanner.nextLine());
			String[] board = new String[N];
			for (i = 0; i < N; i++) {
				board[i] = scanner.nextLine();
			}

			String[] ret = getMoves(pegValue, board);
			System.out.println(ret.length);

			for (i = 0; i < ret.length; i++) {
				System.out.println(ret[i]);
			}
			System.out.flush();

		} catch (Throwable th) {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	/**
	 * A peg can move on the board by jumping over an adjacent peg and landing
	 * on an empty space.
	 * 
	 * @param pegValue
	 *            gives you information about each type of peg. Peg type i will
	 *            add a value of pegValue[i] to the score of a sequence when
	 *            it's removed from the board.
	 * @param board
	 *            gives you the board containing N by N cells. Each String
	 *            contains a row of the board. Any numeric character ('0'..'9')
	 *            denotes the zero based type of the peg in that cell and '.'
	 *            denotes an empty space.
	 * @return String[] containing moves.
	 */		
	public static String[] getMoves(int[] pegValue, String[] board) {
		long startTime = System.currentTimeMillis();
		ArrayList<String> movement = new ArrayList<String>(board.length);

		int[][] dboard = new int[board.length - 1][board[0].length()];
		boolean[][] occupancy = new boolean[board.length][];

		for (int i = 0; i < board.length; i++) {
			System.err.println(i + ") " + board[i] + " size "
					+ board[i].length());

			for (int j = 0; j < board[i].length(); j++) {
				if (occupancy[i] == null) {
					occupancy[i] = new boolean[board[i].length()];
				}
				if (board[i].charAt(j) != '.') {
					occupancy[i][j] = true;
					// System.err.println(eachMove);
				} else {
					// empty space.
					if (isRightMovementPossible(j, board[i])) {
						movement.add(i + " " + (j - 2) + " R");
						occupancy[i][j - 2] = false;
						occupancy[i][j - 1] = true;
						occupancy[i][j] = true;
					}
				}
			}
		}
		// System.err.println(movement);
		for (int i = 0; i < occupancy.length; i++) {
			System.err.println();
			if (occupancy[i] != null) {
				for (int j = 0; j < occupancy[i].length; j++) {
					System.err.print(occupancy[i][j] + ",");
				}
			}
		}
		System.err.println("Before");
		try {
			Collection<? extends String> furtherMovement = makeFurtherMovement(occupancy);
			System.err.println("After");
			if (furtherMovement != null && !furtherMovement.isEmpty()) {
				movement.addAll(furtherMovement);
			} else {
				System.err.println("No further movement.");
			}
		} catch (Throwable th) {
			th.printStackTrace(System.err);
			System.err.println("ERR : " + th.getMessage());
		}

		System.err.println("Time taken : " + (System.currentTimeMillis() - startTime)+ " ms.");
		return movement.toArray(new String[0]);
	}

	/**
	 * @param occupancy
	 * @return
	 */
	private static Collection<? extends String> makeFurtherMovement(
			boolean[][] occupancy) {
		ArrayList<String> movementList = new ArrayList<String>();
		for (int i = occupancy.length - 1; i > -1; i--) {
			if (occupancy[i] != null) {
				for (int j = occupancy[i].length - 1; j > -1; j--) {
					String result = getPossibleMovements(i, j, occupancy);
					if (result != null) {
						movementList.add(result);
					}
				}
			}
		}

		return movementList;
	}

	/**
	 * @param i
	 * @param j
	 * @param occupancy
	 * @return
	 */
	public static String getPossibleMovements(int row, int col,
			boolean[][] occupancy) {

		if (upwardMovementPossible(row, col, occupancy)) {
			 System.err.println(row + " " + col + " U");
			return (row)+ " " + col + " U";
		}

		return null;
	}

	/**
	 * @param row
	 * @param col
	 * @param occupancy
	 * @return
	 */
	private static boolean upwardMovementPossible(int row, int col,
			boolean[][] occupancy) {
		if (row > 1 && occupancy[row - 2] != null) {
			if (occupancy[row][col] && occupancy[row - 1][col]
					&& !occupancy[row - 2][col]) {

				occupancy[row][col] = false;
				occupancy[row - 1][col] = true;
				occupancy[row - 2][col] = true;

				return true;
			}
		}
		return false;
	}

	/**
	 * To check whether right movement is possible or not.
	 * 
	 * @param i
	 *            row index
	 * @param j
	 *            column index
	 * @param string
	 * @return
	 */
	private static boolean isRightMovementPossible(int j, String row) {
		if (j - 2 >= 0 && row.charAt(j - 2) != '.' && row.charAt(j - 1) != '.') {
			return true;
		}

		return false;
	}

}
