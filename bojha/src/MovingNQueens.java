public class MovingNQueens {

	public MovingNQueens() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Given the coordinates of N chess queens placed on an infinite chess
	 * board. Goal is to make some valid minimized moves to rearrange the queens so that
	 * in the end no two queens threaten each other. (i.e. no two queens share
	 * the same row, column or diagonal)
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
	 *  Time limit is 10 seconds       
	 * 
	 */
	public String[] rearrange(int[] queenRows, int[] queenCols) {
		String[] results = new String[queenRows.length * 8];

		boolean[] rowOccupancy = new boolean[queenRows.length * 8];
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
