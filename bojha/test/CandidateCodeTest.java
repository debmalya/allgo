import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class CandidateCodeTest {

	@Test
	public final void test() {
		
		int actual = EnglishAlphabet.word_count(3, new String[]{"A#A#K","A#S#K","A#K#K"}, "ASK");
		Assert.assertEquals(4, actual);
		
		actual = EnglishAlphabet.word_count(6, new String[]{"A#A#K#A#A#K","A#S#K#A#S#K","A#K#K#A#K#K","A#A#K#A#A#K","A#S#K#A#S#K","A#K#K#A#K#K"}, "ASK");
		Assert.assertEquals(12, actual);
		
//		actual = CandidateCode.word_count(3, new String[]{"A#A#K","A#S#K","A#K#K"}, "ASK");
//		Assert.assertEquals(4, actual);
	}

}
