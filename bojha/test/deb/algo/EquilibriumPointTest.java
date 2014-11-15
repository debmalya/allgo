package deb.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EquilibriumPointTest {

	@Test
	public void test() {
		EquilibriumPoint p = new EquilibriumPoint();
		int e = p.solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1});
		System.out.println(e);
	}

}
