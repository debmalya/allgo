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
	 * You're standing at the top left corner of an N × M grid and facing
	 * towards the right. Then you start walking one square at a time in the
	 * direction you are facing. If you reach the border of the grid or if the
	 * next square you are about to visit has already been visited, you turn
	 * right. You stop when all the squares in the grid are visited. What
	 * direction will you be facing when you stop?
	 * 
	 * You can see the example of your long walk in the image below. The numbers
	 * denote the order in which you visit the cells.
	 * 
	 * 
	 * 
	 * Given two integers N and M, denoting the number of rows and columns
	 * respectively, find out the direction you will be facing at the end.
	 * Output "L" for left, "R" for right, "U" for up, and "D" for down.
	 * 
	 * Example:_
	 * 
	 * GRID(3, 3) = "R"
	 * 
	 * This example refers to the picture given in the description. At the end
	 * of your walk you will be standing in the middle of the grid facing right.
	 * 
	 * [input] integer N
	 * 
	 * [input] integer M
	 * 
	 * [output] string
	 * 
	 * The final direction.
	 * 
	 * @param N
	 * @param M
	 * @return
	 */
	static String GRID(int N, int M) {
		String d = "R";
		String p = d;
		int[][] a = new int[N][M];
		int c = 1, x = 0, y = 0, n = 0;

		while (c <= N * M) {
			

			if (a[x][y] == 0) {
				a[x][y] = c++;

			} else {
				n++;
				n = n % 4;
			}

			switch (n) {
			case 0:
				if (y < M - 1 && a[x][y + 1] < 1)
					y++;
				else {
					n = 1;
					p = d;
					d = "D";
					x++;
				}
				break;

			case 1:
				if (x < N - 1 && a[x + 1][y] < 1)
					x++;
				else {
					y--;
					n = 2;
					p = d;
					d = "L";
				}
				break;

			case 2:
				if (y > 0 && a[x][y - 1] < 1) {
					y--;
				} else {
					x--;
					n = 3;
					p = d;
					d = "U";
				}
				break;
			case 3:
				if (x > 0 && a[x - 1][y] < 1) {
					x--;
				} else {
					y++;
					n = 0;
					p = d;
					d = "R";
				}
				break;
			default:
				break;
			}

		}

		return p;

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
