package CountingElement;

public class BinaryCount {
	public int solution(int[] A) {
		int r = 0;
		if (A != null && A.length > 0) {
			int len = A.length;
			int s = 0;
			for (int i = 0; i < len; i++) {
				s += Math.pow(2, A[i]);
			}
			String v = Integer.toBinaryString(3*s);
			len = v.length();
			for (int i = 0; i < len; i++) {
				if (v.charAt(i) == '1') {
					r++;
				}
			}
		}
		return r;
	}
}
