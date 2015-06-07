/**
 * 
 */
import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class Task1Test {
	@Test
	public void test() {
		Task1 sl = new Task1();
		int p = sl.solution(new int[] { 1, 2, 5, 9, 9 }, 5);
		Assert.assertEquals(2, p);

		p = sl.solution(new int[] { 1, 2, 3, 5, 9, 9 }, 5);
		Assert.assertEquals(3, p);
		
		p = sl.solution(new int[] { 1, 2, 3, 6, 9, 9 }, 5);
		Assert.assertEquals(-1, p);
	}
}
