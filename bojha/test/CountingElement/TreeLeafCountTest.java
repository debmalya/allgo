package CountingElement;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeLeafCountTest {

	@Test
	public void testSolution() {
		Tree tree = new Tree();
		tree.x = 5;
		
		Tree ltree = new Tree();
		ltree.x = 3;
		tree.l = ltree;
		
		Tree ltree1 = new Tree();
		ltree1.x = 20;
		ltree1.l = null;
		ltree1.r = null;
		ltree.l = ltree1;
		
		Tree rtree1 = new Tree();
		rtree1.x = 21;
		rtree1.l = null;
		rtree1.r = null;
		ltree.r = rtree1;
		
		Tree rtree = new Tree();
		rtree.x = 10;
		rtree.l = null;
		rtree.r = null;
		tree.r = rtree;
		
		TreeLeafCount tlc = new TreeLeafCount();
		int r = tlc.solution(tree);
		System.out.println(r);
		
		
	}

}
