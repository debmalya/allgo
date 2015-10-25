/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Fill the square matrix of the given size n spirally clockwise from the
	 * upper left corner with numbers from 1 to n * n.
	 * 
	 * Example: For n = 3 the output should be
	 * 
	 * [[1,2,3], [8,9,4], [7,6,5]] [input] integer n
	 * 
	 * The matrix size, 1 ≤ n ≤ 50. [output] array.array.integer
	 * 
	 * 
	 * @param n
	 * @return
	 */
	static int[][] SpiralMatrix(int n) {
		int[][] a = new int[n][n];
		int c = 1, x = 0, y = 0;
		int d = 0;
		while (c <= n * n) {
			if (a[x][y] == 0) {
				a[x][y] = c++;

			} else {
				d++;
				d = d % 4;
			}

			switch (d) {
			case 0:
				if (y < n - 1 && a[x][y + 1] < 1)
					y++;
				else {
					d = 1;
					x++;
				}
				break;

			case 1:
				if (x < n - 1 && a[x + 1][y] < 1)
					x++;
				else {
					y--;
					d = 2;
				}
				break;

			case 2:
				if (y > 0 && a[x][y - 1] < 1) {
					y--;
				} else {
					x--;
					d = 3;
				}
				break;
			case 3:
				if (x > 0 && a[x - 1][y] < 1) {
					x--;
				} else {
					y++;
					d = 0;
				}
				break;
			default:
				break;
			}

		}
		return a;
	}

}
