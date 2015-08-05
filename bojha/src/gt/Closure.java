/**
 * 
 */
package gt;

/**
 * @author debmalyajash
 *
 *
 */
public class Closure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getClosureCount(int[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		int count = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (!visited[row][col]) {
					
					if (isClosure(matrix, row, col, visited)) {
						System.out.println(row + " , " + col);
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * @param i
	 * @return
	 */
	private boolean isClosure(int[][] matrix, int row, int col,
			boolean[][] visited) {
		if (matrix[row][col] == 1 && !visited[row][col]) {
			checkNeighbours(matrix, row, col, visited);
			return true;
		}

		return false;
	}

	/**
	 * @param matrix
	 * @param row
	 * @param col
	 * @param visited
	 */
	private void checkNeighbours(int[][] matrix, int row, int col,
			boolean[][] visited) {
		if (row > -1 && row < matrix.length && col > -1
				&& col < matrix[row].length) {

			if (matrix[row][col] == 1 && !visited[row][col]) {
				visited[row][col] = true;
				checkNeighbours(matrix, row - 1, col, visited);
				checkNeighbours(matrix, row + 1, col, visited);
				checkNeighbours(matrix, row, col - 1, visited);
				checkNeighbours(matrix, row, col + 1, visited);

			} else {
				visited[row][col] = true;
				return;
			}

		} else {
			return;
		}

	}

}
