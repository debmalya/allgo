import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class GarmarenaTest {

	

	/**
	 * @param strings
	 * @return
	 */
	private List<String> createShelves(String[] strings) {
		return Arrays.asList(strings);
	}

	/**
	 * @param is
	 * @return
	 */
	private List<Integer> createBallDroppingList(Integer[] is) {
		return Arrays.asList(is);
	}

	@Test
	/**
	 * This will test conversion from string matrix to digital matrix.
	 */
	public void testConversion() {
		int[][] actual = Garmarena.convert(createShelves(new String[] { "1 1 -1", "-1 -1",
		"1 1 -1" }),3);
		
		int[][] expected = new int[][] {{2,1,2,1,0},{1,0,1,0,1},{2,1,2,1,0}};
		assertSame(actual, expected);
		
		actual = Garmarena.convert(createShelves(new String[] { "1 -1 1 -1",
				"1 -1 1",
				"1 -1 1 -1",
				"1 -1 1" }),4);
		
		expected = new int[][] {{2,1,0,1,2,1,0},{1,2,1,0,1,2,1},{2,1,0,1,2,1,0},{1,2,1,0,1,2,1}};
		assertSame(actual, expected);
	}
	
	@Test
	public void testGetLastPosition() {
		int[][] digitalMatrix = new int[][] {{2,1,2,1,0},{1,0,1,0,1},{2,1,2,1,0}};
		int actual = Garmarena.getLastPosition(digitalMatrix, 1);
		Assert.assertEquals(2,actual);
		actual = Garmarena.getLastPosition(digitalMatrix, 2);
		Assert.assertEquals(4,actual);
//		print(digitalMatrix);
		actual = Garmarena.getLastPosition(digitalMatrix, 5);
		Assert.assertEquals(2,actual);
//		print(digitalMatrix);
		
		digitalMatrix = new int[][] {{2,1,2},{2,1,0}};
		
		actual = Garmarena.getLastPosition(digitalMatrix, 1);
		Assert.assertEquals(2,actual);
		
		
		
	}
	
	@Test
	public void testLeftRight() {
		int[][] digitalMatrix = new int[][] {{0,1,2,1,0},{1,0,1,0,1},{2,1,2,1,0}};
		int actual = Garmarena.getLastPosition(digitalMatrix, 1);
//		System.out.println("Check");
		print(digitalMatrix);
		Assert.assertEquals(1,actual);
		
		actual = Garmarena.getLastPosition(digitalMatrix, 5);
//		print(digitalMatrix);
		Assert.assertEquals(4,actual);
		
		digitalMatrix = new int[][] {{2,1,2,1,0},{1,0,1,0,1},{2,1,2,1,0}};
		actual = Garmarena.getLastPosition(digitalMatrix, 1);
		print(digitalMatrix);
		Assert.assertEquals(2,actual);
		actual = Garmarena.getLastPosition(digitalMatrix, 2);
		print(digitalMatrix);
		Assert.assertEquals(4,actual);
		
		actual = Garmarena.getLastPosition(digitalMatrix, 5);
		print(digitalMatrix);
		Assert.assertEquals(2,actual);
	}
	
	

	/**
	 * @param digitalMatrix
	 */
	private void print(int[][] digitalMatrix) {
		for (int row=0; row <digitalMatrix.length; row++) {
			System.out.println(Arrays.toString(digitalMatrix[row]));
		}
		System.out.println("----------------------------------------");
		
	}

	private void assertSame(int[][] actual, int[][] expected) {
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.length,actual.length);
		
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}
	
	@Test
	public final void testFinal() {

		List<Integer> ballDroppingPointList = createBallDroppingList(new Integer[] {
				1, 2, 5 });
		List<String> shelves = createShelves(new String[] { "1 1 0", "0 0",
				"1 1 0" });
		int position = Garmarena.whereIsTheLastBall(3, 3,
				ballDroppingPointList, shelves);
		Assert.assertEquals(2, position);
		
		ballDroppingPointList = createBallDroppingList(new Integer[] {
				1,
				1 });
		shelves = createShelves(new String[] { "1 0 1 0", "1 0 1",
		"1 0 1 0","1 0 1" });
		position = Garmarena.whereIsTheLastBall(4, 2,
				ballDroppingPointList, shelves);
		Assert.assertEquals(1,position);
		
		ballDroppingPointList = createBallDroppingList(new Integer[] {
				3, 4, 5});
		shelves = createShelves(new String[] { "1 1 -1", "-1 -1",
		"1 1 -1" });
		position = Garmarena.whereIsTheLastBall(3, 3,
		ballDroppingPointList, shelves);
		
	}
}
