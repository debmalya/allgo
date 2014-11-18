import static org.junit.Assert.*;

import org.junit.Test;


public class WolfOnlineJudgeTest {

	@Test
	public void testScore() {
		WolfOnlineJudge onlineJudge = new WolfOnlineJudge();
		double[] r = onlineJudge.score(new String[]{"YYNY","NYNY","NNNY"});
		for (double each:r) {
			System.out.println(each);
		}
	}

}
