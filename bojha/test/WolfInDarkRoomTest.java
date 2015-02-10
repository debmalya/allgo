import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class WolfInDarkRoomTest {

	@Test
	public void test() {
		WolfInDarkRoom w = new WolfInDarkRoom();
		int r = w.count(3, 3, 0, 0);
		System.out.println(r);
	    assertTrue(r == 8);
	    
	    r = w.count(3, 3, 0, 2);
		System.out.println(r);
	    assertTrue(r == 8);
	}

}
