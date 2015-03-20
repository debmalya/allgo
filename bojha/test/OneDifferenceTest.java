import org.junit.Assert;
import org.junit.Test;


public class OneDifferenceTest {
	/**
	 * fn('a','b') = true
fn('aa', 'ab') = true
fn('aa', 'bb') = false
#3# fn('aa', 'a a') = true
#1# fn(' aa', 'aa') = true
#2# fn(' bc', 'bc') = true
#4# fn(' bc ', 'bc') = false
	 */

	@Test
	public void testFn() {
		OneDifference one = new OneDifference();
		Assert.assertTrue(one.fn("a","b"));
		Assert.assertFalse(one.fn("aa","bb"));
		Assert.assertTrue(one.fn("aa","a a"));
		Assert.assertTrue(one.fn(" aa","aa"));
		Assert.assertTrue(one.fn("aab","aa"));
		Assert.assertTrue(one.fn("aa", "a a"));
		Assert.assertTrue(one.fn("aa", " aa"));
		Assert.assertTrue(one.fn(" bc", "bc"));
		Assert.assertFalse(one.fn(" bc ","bc"));
	}

}
