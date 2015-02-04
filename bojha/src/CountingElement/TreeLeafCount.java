package CountingElement;

public class TreeLeafCount {
	private int c = 0;
	public int solution(Tree T) {
		// write your code in Java SE 8
		int r = 0;
		c = 0;
		if (T != null) {
			getCount(T,T.x);
		}
		return c;
	}

	private void getCount(Tree t,int rootValue) {
		
		if (t.l != null) {
			if (t.l.x > rootValue) {
				c++;
			}
			getCount(t.l,rootValue);
		}
		
		if (t.r != null) {
			if (t.r.x > rootValue) {
				c++;
			}
			getCount(t.r,rootValue);
		}
		
		
	}
}
