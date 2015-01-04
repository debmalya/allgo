package CountingElement;

import org.junit.Assert;
import org.junit.Test;

public class PermCheckTest {

	@Test
	public void test() {
		PermCheck perm = new PermCheck();
		int r = perm.solution(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE});
		Assert.assertTrue( r + " KO",r == 0);
		
		r = perm.solution(new int[]{2,1,-1});
		Assert.assertTrue( r + " KO",r == 0);
				
		r = perm.solution(new int[]{4, 1, 3, 2});
		Assert.assertTrue( r + " KO",r == 1);
	}

}
