import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * @author debmalya jash debmalya.jash@gmail.com
 */
public class Garmarena {

	/**
	 * Blank positions are digitally represented by 1.
	 */
	private static final int BLANK = 1;

	/**
	 * 
	 */
	private static final String LEFT_CHAR = "-1";

	/**
	 * Represents a blank character.
	 */
	private static final char BLANK_CHAR = ' ';

	/**
	 * Represents right character.
	 */
	private static final char RIGHT_CHAR = '1';

	/**
	 * Motion down and right.
	 */
	private static final int RIGHT = 2;

	/**
	 * Motion down and left.
	 */
	private static final int LEFT = 0;

	/**
	 * Motion down and straight
	 */
	private static final int DOWN = 1;
	
	/**
	 * Impossible to move.
	 */
	private static final int[] IMPOSSIBLE =new int[] { -1, -1 };
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			int noOfTestCases = Integer.parseInt(scanner.nextLine());
			List<Integer> allOutputs = new ArrayList<Integer>(noOfTestCases);
			for (int i = 0; i < noOfTestCases; i++) {
				// Take all inputs for a test case
				// process that inputs
				// add the result into allOutputs
				allOutputs.add(processEachInput(takeEachInput(scanner)));
			}

			// print output one by one
			for (Integer each : allOutputs) {
				System.out.println(each);
			}
		} catch (Throwable th) {
			th.printStackTrace();
			System.err.println("ERR :" + th.getMessage());
		} finally {

		}

	}

	/**
	 * Process each input and store them.
	 * 
	 * @param scanner
	 */
	private static Input takeEachInput(Scanner scanner) {

		Input input = new Input(scanner);
		return input;
	}

	/**
	 * Tell me where last ball will drop finally.
	 * 
	 * @param takeEachInput
	 *            each input
	 * @return last position (column).
	 */
	private static Integer processEachInput(Input takeEachInput) {

		return whereIsTheLastBall(takeEachInput.numberOfShelves,
				takeEachInput.numberOfBalls,
				takeEachInput.ballDroppingPointList, takeEachInput.shelves);
	}

	/**
	 * detects where is the last ball.
	 * 
	 * @param numberOfShelves
	 *            - number of shelves.
	 * @param numberOfBalls
	 *            - number of balls.
	 * @param ballDroppingPointList
	 *            list where balls are dropped.
	 * @param shelves
	 *            shelves position.
	 * @return the place where the last ball will fall out.
	 */
	public static Integer whereIsTheLastBall(int numberOfShelves,
			int numberOfBalls, List<Integer> ballDroppingPointList,
			List<String> shelves) {
		int[][] digitalMatrix = convert(shelves, numberOfShelves);

		int lastPosition = 1;
		for (int i = 0; i < ballDroppingPointList.size(); i++) {
			lastPosition = getLastPosition(digitalMatrix,
					ballDroppingPointList.get(i));
		}

		return lastPosition;

	}

	/**
	 * Input processor class.
	 * 
	 * @author debmalya jash
	 *
	 */
	static class Input {
		int numberOfShelves;
		int numberOfBalls;
		List<Integer> ballDroppingPointList;
		List<String> shelves;

		public Input(Scanner scanner) {
			processNnK(scanner.nextLine());

			int i = 0;
			for (i = 0; i < numberOfBalls; i++) {
				addBallDroppingPoints(Integer.parseInt(scanner.nextLine()));
			}

			for (i = 0; i < numberOfShelves; i++) {
				addShelves(scanner.nextLine());
			}
		}

		/**
		 * @param nextLine
		 */
		private void addShelves(String nextLine) {
			if (shelves == null) {
				shelves = new ArrayList<String>();
			}
			shelves.add(nextLine);

		}

		/**
		 * @param nextLine
		 */
		public void processNnK(String nextLine) {
			String[] nNk = nextLine.split(" ");
			numberOfShelves = Integer.parseInt(nNk[0]);
			numberOfBalls = Integer.parseInt(nNk[1]);
		}

		/**
		 * @param droppingPosition
		 */
		public void addBallDroppingPoints(int droppingPosition) {
			if (ballDroppingPointList == null) {
				ballDroppingPointList = new ArrayList<Integer>();
			}
			ballDroppingPointList.add(droppingPosition);
		}
	}

	/**
	 * @param digitalMatrix
	 *            digital format of the matrix.
	 * @param ballPosition
	 *            - where ball is dropped.
	 * @return last position column.
	 */
	public static int getLastPosition(int[][] digitalMatrix,
			Integer ballPosition) {
		int dropIndex = ballPosition - 1;
		int[] nextPosition = new int[] { 0, dropIndex };
		int previousDirection = RIGHT;
		int[] previousPosition = null;
		while (nextPosition[0] != -1 && nextPosition[1] != -1) {
			previousPosition = nextPosition;
			int row = nextPosition[0];
			int col = nextPosition[1];

			if (digitalMatrix[row][col] == RIGHT) {
				nextPosition = dropRight(digitalMatrix, row, col);
				previousDirection = RIGHT;
			} else if (digitalMatrix[row][col] == LEFT) {
				nextPosition = dropLeft(digitalMatrix, row, col);
				previousDirection = LEFT;
			} else {
				nextPosition = dropStraight(digitalMatrix, row, col);
				previousDirection = DOWN;
			}
			// change RIGHT to LEFT and vice versa.
			if ((col != 0) && (col != digitalMatrix[row].length - 1)) {
				// For the edge shelf there will be no change of orientation.
				digitalMatrix[row][col] = 2 - digitalMatrix[row][col];
			}
		}

		if (previousDirection == RIGHT
				&& previousPosition[1] + 1 < digitalMatrix[previousPosition[0]].length) {
			previousPosition[1] = previousPosition[1] + 1;
		} else if (previousDirection == LEFT && previousPosition[1] - 1 > -1) {
			previousPosition[1] = previousPosition[1] - 1;
		}
		return previousPosition[1] + 1;
	}

	/**
	 * Move straight down.
	 * 
	 * @param digitalMatrix
	 * @param row number.
	 * @param col number.
	 * @return row column after moving down.
	 */
	private static int[] dropStraight(int[][] digitalMatrix, int row, int col) {
		if (row + 1 < digitalMatrix.length) {
			return new int[] { row + 1, col };
		}
		return IMPOSSIBLE;
	}

	/**
	 * Move towards left and down, if possible
	 * 
	 * @param digitalMatrix
	 * @param i
	 * @param dropIndex
	 * @return
	 */
	private static int[] dropLeft(int[][] digitalMatrix, int row, int col) {
		if (row + 1 < digitalMatrix.length && col - 1 > -1) {
			return new int[] { row + 1, col - 1 };
		}
		return IMPOSSIBLE;

	}

	/**
	 * To right shift.
	 * 
	 * @param digitalMatrix
	 * @param row
	 *            number.
	 * @param col
	 *            number.
	 * @param dropIndex
	 *            row, column after right shift. If shift is not possible then
	 */
	private static int[] dropRight(int[][] digitalMatrix, int row, int col) {
		if (row + 1 < digitalMatrix.length
				&& col + 1 < digitalMatrix[row + 1].length) {
			return new int[] { row + 1, col + 1 };
		}
		return IMPOSSIBLE;

	}

	/**
	 * Converts shelved to digital matrix.
	 * @param shelves
	 * @param numberOfShelves
	 * @return double dimension array of size (shelves.size X 2*number of
	 *         shelves - 2 - shelf oriented to right. 0 - shelf oriented to
	 *         left. 1 - blank space.
	 */
	public static int[][] convert(List<String> shelves, int numberOfShelves) {
		int length = 2 * numberOfShelves - 1;
		int[][] digitalMatrix = new int[shelves.size()][length];

		for (int row = 0; row < shelves.size(); row++) {
			String each = shelves.get(row).replace(LEFT_CHAR, "0");
			int col = 0;
			for (; col < each.length(); col++) {
				if (col == 0 && row % 2 == 1) {
					// For alternate rows which contains n - 1 elements.
					digitalMatrix[row][0] = BLANK;
				}
				if (each.charAt(col) == RIGHT_CHAR) {
					digitalMatrix[row][col + row % 2] = RIGHT;
				} else if (each.charAt(col) == BLANK_CHAR) {
					digitalMatrix[row][col + row % 2] = BLANK;
				}
			}

			while (col < length - 1) {
				digitalMatrix[row][++col] = BLANK;
			}
		}
		return digitalMatrix;
	}

}
