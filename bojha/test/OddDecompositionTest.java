import org.junit.Test;


public class OddDecompositionTest {

	@Test
	public void testSolution() {
		OddDecomposition odd = new OddDecomposition();
		int[] n = odd.solution(4);
		n = odd.solution(11);
		
		for (int i = 0; i < n.length; i++) {
			System.out.println(i);
		}
	}

}
