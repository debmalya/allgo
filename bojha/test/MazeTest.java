import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class MazeTest {

	@Test
	public final void test() {
		boolean actual = Maze
				.execute(
						"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
						true);
		assertTrue(actual);

		actual = Maze
				.execute(
						"OXOOOOOOOOXOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
						true);
		assertFalse(actual);

		actual = Maze
				.execute(
						"XOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
						true);
		assertFalse(actual);

		actual = Maze
				.execute(
						"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOX",
						true);
		assertFalse(actual);

		actual = Maze
				.execute(
						"OOXOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
						true);
		assertTrue(actual);

		actual = Maze.execute("OXXO", true);
		assertFalse(actual);

		actual = Maze.execute("XOOO", true);
		assertFalse(actual);

		actual = Maze.execute("OOOX", true);
		assertFalse(actual);

		actual = Maze.execute("OOXX", true);
		assertFalse(actual);

		actual = Maze.execute("OOXOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOXOXOXOO", true);
		assertFalse(actual);

		actual = Maze.execute("OXOXOOXOO", true);
		assertFalse(actual);

		actual = Maze.execute("XOOOXOOOX", true);
		assertFalse(actual);

		actual = Maze.execute("OOOOXXOXO", true);
		assertFalse(actual);

		actual = Maze.execute("OXOXOOOOO", true);
		assertFalse(actual);

		actual = Maze.execute("OXOO", true);
		assertTrue(actual);

		actual = Maze
				.execute(
						"OOOOOOOOOOXXXXXXXXXXOOOOOOOOOOXXXXXXXXXXOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
						true);
		assertFalse(actual);

		actual = Maze.execute("XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO"
				+ "XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO"
				+ "XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO", true);
		assertFalse(actual);

		actual = Maze.execute("OOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO"
				+ "XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO"
				+ "XOOOOOOOOO" + "XOOOOOOOOO" + "XOOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOO" + "OXXXXXXXXX" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOO" + "OXOOOOOOOO" + "OOXOOOOOOO"
				+ "OOOXOOOOOO" + "OOOOXOOOOO" + "OOOOOXOOOO" + "OOOOOOXOOO"
				+ "OOOOOOOXOO" + "OOOOOOOOXO" + "OOOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OOOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOXX" + "OOOOOOOOXO", true);
		assertFalse(actual);

		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOXO" + "OOOOOOOXOO"
				+ "OOOOOOXOOO" + "OOOOOXOOOO" + "OOOOXOOOOO" + "OOOXOOOOOO"
				+ "OOXOOOOOOO" + "OXOOOOOOOO" + "XOOOOOOOOO", true);
		assertFalse(actual);

		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOXO" + "OOOOOOOXOO"
				+ "OOOOOOXOOO" + "OOOOOXOOOO" + "OOOOXOOOOO" + "OOOXOOOOOO"
				+ "OOXOOOOOOO" + "OXOOOOOOOO" + "OOOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOXO" + "OOOOOOOXOO"
				+ "OOOOOOXOOO" + "OOOOOXOOOO" + "OOOOXOOOOO" + "OOOXOOOOOO"
				+ "OOXOOOOOOO" + "OXOOOOOOOO" + "OOOOOOOOOX", true);
		assertFalse(actual);

		// Last cell is reachable or not test.
		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOOO" + "OXXXXXXXXX"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO"
				+ "OXOOOOOOOO" + "OXOOOOOOOO" + "OXOOOOOOOO", true);
		assertFalse(actual);

		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOOO" + "OXXXXXXXXX"
				+ "OXOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO", true);
		assertTrue(actual);

		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOXO" + "OOOOOOOXOX" + "OOOOOOOXOO", true);
		assertFalse(actual);

		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOXXX" + "OOOOOOOXOO" + "OOOOOOOXOO", true);
		assertFalse(actual);
		
		actual = Maze.execute("OOOOOOOOOX" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOXO" + "OOOOOOOOOX" + "OOOOOOOXOO", true);
		assertTrue(actual);
		
		actual = Maze.execute("OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOX" + "OOOOOOOOXO", true);
		assertFalse(actual);
		
		actual = Maze.execute("OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOXXXXOO", true);
		assertTrue(actual);
		
		actual = Maze.execute("OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOX" + "OOOOOOOOOO" + "OOOOXXXXOO", true);
		assertTrue(actual);
		
		actual = Maze.execute("OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOXX" + "OOOOXXXXOO", true);
		assertFalse(actual);
		
//		This test case is failing
		actual = Maze.execute("OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO" + "OOOOOOOOOO"
				+ "OOOOOOOOOO" + "OOOOOOOOOX" + "OOOOXXXXOO", true);
		assertTrue(actual);

	}

}
