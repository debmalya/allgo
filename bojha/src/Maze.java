import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Write a program that determines whether it's possible to escape from the given labyrinth. 
 * In the maze one can only move either vertically or horizontally and can't visit a field that is occupied.
 */

/**
 * @author debmalyajash
 *
 */
public class Maze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<Boolean> resultList = new ArrayList<Boolean>();

			String readString = scanner.nextLine();
			while (readString != null) {

				resultList.add(execute(readString, true));
				readString = scanner.nextLine();
				if (readString.trim().equals("")) {
					for (int i = 0; i < resultList.size(); i++) {
						System.out.println(resultList.get(i) ? "1" : "0");
					}
					readString = null;
				}

			}

		} catch (Throwable ignore) {

		}

	}

	/**
	 * The entrance to the maze is in the field (0,0) and the exit is in the
	 * field (9,9). A field with coordinates (i,j) is represented by the
	 * character in given string on position 10*i+j (starting from 0).
	 * 
	 * @param eachLine
	 */
	public static boolean execute(String eachLine, boolean isFirstTime) {
		// Have to start from (0,0) and end at (9,9)
		// Checking whether those two positions are occupied or not.
		if (eachLine.startsWith("X") || eachLine.endsWith("X")) {
			return false;
		}

		int mazeSize = (int) Math.sqrt(eachLine.length());

		boolean[][] maze = new boolean[mazeSize][mazeSize];

		List<Integer> watchList = new ArrayList<Integer>();

		for (int i = 0; i < eachLine.length(); i++) {
			int row = i / mazeSize;
			int col = i % mazeSize;

			maze[row][col] = 'O' == eachLine.charAt(i) ? true : false;

			if (!maze[row][col]) {
				watchList.add(i);
			}
		}

		if (watchList.size() < 2) {
			return true;
		} else {
			if (isBlockedPoint(maze, mazeSize)) {
				return false;
			}

			if (isBlocked(maze, watchList, mazeSize)) {
				return false;
			}

		}

		return true;
	}

	/**
	 * This checks whether first and last position is free, but surrounded by
	 * occupied cells. Situation is cannot move out of first position and cannot
	 * reach the last position.
	 * 
	 * @param maze
	 * @return true if those two positions are blocked, false otherwise.
	 */
	private static boolean isBlockedPoint(boolean[][] maze, int mazesize) {
		if (maze[0][0] && !maze[0][1] && !maze[1][0]) {
			return true;
		}

		if (maze[mazesize - 1][mazesize - 1]
				&& !maze[mazesize - 1][mazesize - 2]
				&& !maze[mazesize - 2][mazesize - 2]
				&& !maze[mazesize - 2][mazesize - 1]) {
			return true;
		}

		return false;
	}

	/**
	 * @param eachLine
	 * @param mazeSize
	 * @return
	 */
	private static boolean isBlocked(boolean[][] maze, List<Integer> watchList,
			int mazeSize) {
		
		if (watchList.size() > 0) {
			int previous = watchList.get(0);
			int blockSize = 1;
			int maxBlockSize = 0;
			
			Set<Integer> rowSet = new HashSet<Integer>();
			Set<Integer> colSet = new HashSet<Integer>();
			
			int highest_row = -1;
			int highest_col = -1;
			
			highest_row = Math.max(highest_row, previous/mazeSize);
			highest_col = Math.max(highest_col,previous%mazeSize);
			
			for (int i = 1; i < watchList.size(); i++) {
				int current = watchList.get(i);
				int previous_row = previous / mazeSize;
				int previous_col = previous % mazeSize;
				
				int current_row = current / mazeSize;
				int current_col = current % mazeSize;
				rowSet.add(previous_row);
				colSet.add(previous_col);
				
				highest_row = Math.max(highest_row, current_row);
				highest_col = Math.max(highest_col,current_col);

				if (watchList.get(i) - previous == 1) {
					blockSize++;
					
				} else if ((Math.abs(current_row - previous_row) <= 1
						|| Math.abs(current_col - previous_col) <= 1) &&
						current - previous <= mazeSize){
					blockSize++;
					maxBlockSize = Math.max(maxBlockSize, blockSize);					

					
				} else {
					blockSize = 1;
					highest_row = -1;
					highest_col = -1;
				}

				if (blockSize >= mazeSize) {
					rowSet.add(current_row);
					colSet.add(current_col);
					if (rowSet.size() == mazeSize || colSet.size() == mazeSize) {
						return true;
					}
				}
				previous = current;
			}


			if (blockSize >= 2 && highest_col == mazeSize -1 && highest_row == mazeSize -1) {
//				destination unreachable.
				System.out.println("------------------");
				System.out.println("Rowset " + rowSet);
				System.out.println("Colset " + colSet);
				colSet.addAll(rowSet);
				System.out.println(colSet);
//				System.out.println("------------------");
				return true;
			}
			

		}
		return false;
	}


}
