import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class NamingConventionTest {

	@Test
	public void testToCamelCase() {
		NamingConvention convention = new NamingConvention();
		String camelCase = convention.toCamelCase("debmalya_jash");
		assertTrue("Expected  'debmalyaJash' but found " + camelCase, "debmalyaJash".equals(camelCase));
		
	}

}
